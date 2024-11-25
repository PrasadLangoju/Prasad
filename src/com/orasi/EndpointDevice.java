package com.orasi;

import com.google.gson.Gson;
import com.orasi.event.spi.StepEvent;
import com.orasi.model.StepException;
import com.orasi.model.StepPayload;
import static com.orasi.ActionLibrary.getStepCounter;
import com.microsoft.playwright.*;
import static com.orasi.ActionLibrary.notifyListeners;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controls the definition and connection logic for a specific device
 */
public class EndpointDevice {

  private final Pattern contextPattern = Pattern.compile("#\\{([^}]*)}");
  private final Logger log = LoggerFactory.getLogger(EndpointDevice.class);
  private static final String URL = "URL";

  private final ExecutionRouter router;
  private final ExecutionTarget executionTarget;

  private int queueIndex;

  /**
   * Creates an endpoint definition containing both the router and device
   * connection information
   *
   * @param router
   * @param executionTarget
   */
  public EndpointDevice(ExecutionRouter router, ExecutionTarget executionTarget) {
    this.router = router;
    this.executionTarget = executionTarget;
  }

  /**
   * Defines the maximum amount of connections that this browser definition can
   * handle. The allows tests to be split across multiple devices for faster
   * executions
   *
   * @return
   */
  public int getMaximumAvailable() {
    return getExecutionTarget().getMaximumAvailable();
  }

  /**
   * A friendly name for this device
   *
   * @return
   */
  public String getName() {
    return getExecutionTarget().getName() + " at " + getRouter().getName();
  }

  public String getId() {
    return getExecutionTarget().getAlchemyIdentifier();
  }

  /**
   *
   * @param keyName
   * @return
   */
  public String getProperty(String keyName) {
    String value = getValue(getRouter().getProperty(keyName));
    if (value == null) {
      return getValue(getExecutionTarget().getProperty(keyName), getExecutionTarget().getProperty(keyName));
    } else {
      return value;
    }
  }

  private String getValue(String value) {
    return getValue(value, value);
  }

  private String getValue(String value, String defaultValue) {
    if (value == null) {
      return defaultValue;
    }
    Matcher m = contextPattern.matcher(value);

    if (m.find()) {
      return System.getProperty(m.group(1), defaultValue);
    }

    return defaultValue;
  }

  public BrowserWrapper connect(TestWrapper tW, int textExecutionId) throws StepException {

    StepPayload sP = new StepPayload();
    sP.setActionName("Establishing Connection");
    sP.setExecutionId(TestSuite.instance().getExecutionId());
    int parentStep = getStepCounter();
    sP.setStepId(parentStep);
    sP.setTestExecutionId(textExecutionId);
    sP.setParentStep(0);
    sP.setStepDetail("{'actionDisplay': 'Establishing Connection to " + getExecutionTarget().getName() + " on " + getRouter().getName() + "' }");
    notifyListeners(new StepEvent(sP, tW.getName(), 1));
    try {

      Playwright pW = Playwright.create();
      BrowserWrapper bW = null;
      try {
        switch (getValue(executionTarget.getPropertyMap().get("browserName")).toLowerCase()) {
          case "edge", "msedge", "microsoftedge" -> bW = new BrowserWrapper(pW.chromium().launch());
          case "chrome", "chromium", "google" -> bW = new BrowserWrapper(pW.chromium().launch());
          case "firefox", "mozilla" -> bW = new BrowserWrapper(pW.firefox().launch());
          case "safari", "mac", "macos", "apple" -> bW = new BrowserWrapper(pW.webkit().launch());
        }
        
        sP.setStatus( 1 );
        notifyListeners(new StepEvent(sP, tW.getName(), 4));
        return bW;
      } catch (Exception e) {

        StringBuilder errorBuilder = new StringBuilder();
        errorBuilder.append("Error connecting to ").append(getExecutionTarget().getName()).append(" at ").append(getRouter().getName()).append(" using:\r\n");

        getRouter().getPropertyMap().keySet().forEach(key -> {
          errorBuilder.append("\tROUTER: ").append(key).append(" = [").append(getValue(getRouter().getPropertyMap().get(key))).append("]\r\n");
        });

        getExecutionTarget().getPropertyMap().keySet().forEach(key -> {
          errorBuilder.append("\tTARGET: ").append(key).append(" = [").append(getValue(getExecutionTarget().getPropertyMap().get(key))).append("]\r\n");
        });
        errorBuilder.append(e.getMessage()).append("\r\n");

        log.atError().log(errorBuilder.toString(), e);

        sP.setStatus(-1);
        sP.setMessage(errorBuilder.toString());
        notifyListeners(new StepEvent(sP, tW.getName(), 3));
        throw new StepException(sP.getStepId(), StepException.Threshold.FATAL, e, errorBuilder.toString(), sP, StepException.FailureType.Infrastructure);
      }
    } catch (StepException e) {
      notifyListeners(new StepEvent(sP, tW.getName(), 3));
      throw e;
    }

  }

  /**
   * Disconnect and close the current connection
   *
   * @param webDriver
   */
  public void disconnect(BrowserWrapper bW) {
    try {
      log.info("Closing connection to " + getExecutionTarget().getName() + " at " + getRouter().getName());
      bW.close();
    } catch (Exception e) {
      log.atError().log("Failed to close connection", e);
    }
  }

  /**
   * @return the routerDetail
   */
  public String getRouterDetail() {
    return getRouter().getRouterDetail();
  }

  /**
   * @return the targetDetail
   */
  public String getTargetDetail() {
    return getExecutionTarget().getTargetDetail();
  }

  /**
   * @return the router
   */
  public ExecutionRouter getRouter() {
    return router;
  }

  /**
   * @return the executionTarget
   */
  public ExecutionTarget getExecutionTarget() {
    return executionTarget;
  }

}
