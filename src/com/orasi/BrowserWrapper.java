
package com.orasi;

import com.microsoft.playwright.*;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author allen
 */
public class BrowserWrapper implements Browser {

  private final Browser b;
  private Page page;
  private Frame frame;
  private BrowserContext browserContext;
  
  public BrowserWrapper( Browser b ) {
    this.b = b;
    this.browserContext = b.newContext();
    this.page = browserContext.newPage();
  }
  
  public boolean hasFrame() {
    return frame != null;
  }
  
  public boolean hasPage() {
    return page != null;
  }
  
  public Locator locator( String locator ) {
    
    if ( page == null ) {
      page = browserContext.pages().get( 0 );
    }
    
    if ( frame != null ) {
      return frame.locator(locator);
    } else if ( page != null ) {
      return page.locator(locator);
    } else {
      throw new IllegalArgumentException( "Neither page now frame is set" );
    }
  }
  
  

  @Override
  public void onDisconnected(Consumer<Browser> handler) {
    b.onDisconnected(handler);
  }

  @Override
  public void offDisconnected(Consumer<Browser> handler) {
    b.offDisconnected(handler);
  }

  @Override
  public BrowserType browserType() {
    return b.browserType();
  }

  @Override
  public void close(Browser.CloseOptions options) {
    b.close(options);
  }

  @Override
  public List<BrowserContext> contexts() {
    return b.contexts();
  }

  @Override
  public boolean isConnected() {
    return b.isConnected();
  }

  @Override
  public CDPSession newBrowserCDPSession() {
    return b.newBrowserCDPSession();
  }

  @Override
  public BrowserContext newContext(Browser.NewContextOptions options) {
    return b.newContext(options);
  }

  @Override
  public Page newPage(Browser.NewPageOptions options) {
    return b.newPage(options);
  }

  @Override
  public void startTracing(Page page, Browser.StartTracingOptions options) {
    b.startTracing(page, options);
  }

  @Override
  public byte[] stopTracing() {
    return b.stopTracing();
  }

  @Override
  public String version() {
    return b.version();
  }

  @Override
  public void close() {
    b.close();
  }

  @Override
  public BrowserContext newContext() {
    return b.newContext();
  }

  @Override
  public Page newPage() {
    return b.newPage();
  }

  @Override
  public void startTracing(Page page) {
    b.startTracing(page);
  }

  @Override
  public void startTracing() {
    b.startTracing();
  }

  /**
   * @return the page
   */
  public Page getPage() {
    return page;
  }

  /**
   * @param page the page to set
   */
  public void setPage(Page page) {
    this.page = page;
  }

  /**
   * @return the browserContext
   */
  public BrowserContext getBrowserContext() {
    return browserContext;
  }

  /**
   * @param browserContext the browserContext to set
   */
  public void setBrowserContext(BrowserContext browserContext) {
    this.browserContext = browserContext;
  }

  /**
   * @return the frame
   */
  public Frame getFrame() {
    return frame;
  }

  /**
   * @param frame the frame to set
   */
  public void setFrame(Frame frame) {
    this.frame = frame;
  }
  
}
