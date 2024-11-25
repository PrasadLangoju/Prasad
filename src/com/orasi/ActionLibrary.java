/**
 * @version 2
 *
 */
 package com.orasi;
 
 import java.util.*;
 import java.util.function.*;
 import java.io.*;
 import java.lang.reflect.*;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import java.util.regex.*;
 import com.orasi.datasource.*;
 import com.orasi.alchemy.mediation.execution.*;
 import java.util.concurrent.atomic.AtomicInteger;
 import com.orasi.event.*;
 import com.orasi.event.chain.*;
 import com.orasi.event.handler.EventHandler;
 import com.orasi.model.*;
 import java.time.*;
 import com.microsoft.playwright.options.*;
 import com.microsoft.playwright.*;
 
 public class ActionLibrary
 {
    private static Logger log = LoggerFactory.getLogger(ActionLibrary.class );
 
    private static final Pattern CONTEXT_REGEX = Pattern.compile( "\\$\\{([^}]*)\\}" );
 

    private static final AtomicInteger testCounter = new AtomicInteger();
    private static final AtomicInteger stepCounter = new AtomicInteger();

    public static final int getTestCounter() {
      return testCounter.incrementAndGet();
    }

    public static final int getStepCounter() {
      return stepCounter.incrementAndGet();
    }
 

 private static EventChain eventChain = new EventChain();

 public static void addEventHandler( EventHandler eventHandler ) {
   eventHandler.setEventChain(eventChain);
   eventChain.addEventHandler(eventHandler);
 }

 public static void notifyListeners( Event e ) {
   
   eventChain.handle( e );
 }

  private static List<Throwable> getThrowableList(Throwable throwable) {
    final List<Throwable> list = new ArrayList<>();
    while (throwable != null && !list.contains(throwable)) {
      list.add(throwable);
      throwable = throwable.getCause();
    }
    return list;
  }

  private static Throwable getRootCause(final Throwable throwable) {
    final List<Throwable> list = getThrowableList(throwable);
    return list.isEmpty() ? throwable : list.get(list.size() - 1);
  }

 
 
 
 public static void Click_v1( int executionId, int stepIdentifier, int testExecutionId, BrowserWrapper bW, Map<String,Object> variableMap, Map<String,Object> contextMap, String contextName, Stack<String> callStack, Stack<Integer> stepStack )
 {
 
   Locator targetLocator = (Locator) variableMap.get( "targetLocator" );
 
   String method = (String) variableMap.get( "method" );
 

 

    if (method != null && !method.isEmpty()) {

      try {
        switch (method) {
          case "No Wait":
            targetLocator.click(new Locator.ClickOptions().setTimeout(0));
            break;
          case "Default":
          case "Simple":
            targetLocator.click();
            break;
          case "Right":
            targetLocator.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
            break;
          case "Double":
            targetLocator.click(new Locator.ClickOptions().setClickCount(2));
            break;
          default:
            throw new IllegalArgumentException("Invalid method specified as " + method);
        }
      } catch (Exception e) {
        throw new IllegalArgumentException("Could not locate element defined by targetLocator");
      }

    } else {
      throw new IllegalArgumentException("The METHOD parameter must be specified");
    }

    
 if ( variableMap != null ) {
   variableMap.clear();
 }
}

 
 public static void Keys_v1( int executionId, int stepIdentifier, int testExecutionId, BrowserWrapper bW, Map<String,Object> variableMap, Map<String,Object> contextMap, String contextName, Stack<String> callStack, Stack<Integer> stepStack )
 {
 
   Boolean Control = Boolean.parseBoolean( variableMap.get( "Control" ) + "" );
 
   Boolean Shift = Boolean.parseBoolean( variableMap.get( "Shift" ) + "" );
 
   Boolean Alt = Boolean.parseBoolean( variableMap.get( "Alt" ) + "" );
 
   String Key = (String) variableMap.get( "Key" );
 

 

    String toType = Key.substring( 0, 1 ).toUpperCase() + Key.substring(1).toLowerCase();

    if (Control != null && Control.booleanValue()) {
      toType = "Control+" + toType;
    }

    if (Shift != null && Shift.booleanValue()) {
      toType = "Shift+" + toType;
    }

    if (Alt != null && Control.booleanValue()) {
      toType = "Alt+" + toType;
    }

    bW.getPage().keyboard().press(toType);

    
 if ( variableMap != null ) {
   variableMap.clear();
 }
}

 
 public static void Navigate_v1( int executionId, int stepIdentifier, int testExecutionId, BrowserWrapper bW, Map<String,Object> variableMap, Map<String,Object> contextMap, String contextName, Stack<String> callStack, Stack<Integer> stepStack )
 {
 
   String url = (String) variableMap.get( "url" );
 
   Long timeout = null;
   Number _timeout = (Number) variableMap.get( "timeout" );
   if ( _timeout != null ) timeout = _timeout.longValue();
 

 

    Page.NavigateOptions nO = new Page.NavigateOptions();
    nO.setTimeout(timeout);
    bW.getPage().navigate(url, nO);

    
 if ( variableMap != null ) {
   variableMap.clear();
 }
}

 
 public static void Browser_v1( int executionId, int stepIdentifier, int testExecutionId, BrowserWrapper bW, Map<String,Object> variableMap, Map<String,Object> contextMap, String contextName, Stack<String> callStack, Stack<Integer> stepStack )
 {
 
   String action = (String) variableMap.get( "action" );
 
   Long height = null;
   Number _height = (Number) variableMap.get( "height" );
   if ( _height != null ) height = _height.longValue();
 
   Long width = null;
   Number _width = (Number) variableMap.get( "width" );
   if ( _width != null ) width = _width.longValue();
 

 

    switch (action) {
      case "Back":
        bW.getPage().goBack();
        break;
      case "Forward":
        bW.getPage().goForward();
        break;
      case "Refresh":
        bW.getPage().reload();
        break;
      case "Maximize":
        // webDriver.manage().window().maximize();
        break;
      case "Minimize":
        // webDriver.manage().window().minimize();
        break;
      case "Full Screen":
        // webDriver.manage().window().fullscreen();
        break;
      case "Resize":
        bW.getPage().setViewportSize(width.intValue(), height.intValue());
        break;
      case "Close":
        //
    }

    if (contextName != null) {
      contextMap.put(contextName, bW.getPage().url());
    }

    
 if ( variableMap != null ) {
   variableMap.clear();
 }
}

 
 public static void Type_v1( int executionId, int stepIdentifier, int testExecutionId, BrowserWrapper bW, Map<String,Object> variableMap, Map<String,Object> contextMap, String contextName, Stack<String> callStack, Stack<Integer> stepStack )
 {
 
   String value = (String) variableMap.get( "value" );
 
   Boolean clearFirst = Boolean.parseBoolean( variableMap.get( "clearFirst" ) + "" );
 
   Locator targetLocator = (Locator) variableMap.get( "targetLocator" );
 

 

    if( clearFirst ) {
      targetLocator.clear();
    }

    targetLocator.fill( value );

    
 if ( variableMap != null ) {
   variableMap.clear();
 }
}


 }
