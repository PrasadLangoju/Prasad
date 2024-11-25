package com.orasi.pages;

import java.lang.reflect.InvocationTargetException;
import com.microsoft.playwright.*;
import java.util.*;
import com.microsoft.playwright.options.*;
import com.orasi.datasource.*;

/**
 * A class used to construct a locator compatible with PlayWright that has been
 * scanned and processed replacing and alchemy specific replaceable values such
 * as data, context, etc
 */
public class LocatorFactory {

  private final int methodId;
  private final String descriptor;
  private final String name;
  private final String alchemyId;
  private final String shadowHost;
  private List<LocatorFactory> tieredList;

  /**
   *
   * @param methodId The type of locator
   * @param descriptor The textual descriptor definition
   * @param name A friendly name for this locator
   * @param alchemyId A unique identifier for this locator
   */
  public LocatorFactory(int methodId, String descriptor, String name, String alchemyId) {
    this(methodId, descriptor, name, alchemyId, null);
  }

  /**
   *
   * @param methodId The type of locator
   * @param descriptor The textual descriptor definition
   * @param name A friendly name for this locator
   * @param alchemyId A unique identifier for this locator
   * @param shadowHost An optional parameter instructing this locator is relative to a shadow root
   */
  public LocatorFactory(int methodId, String descriptor, String name, String alchemyId, String shadowHost) {
    this.methodId = methodId;
    this.descriptor = descriptor;
    this.name = name;
    this.alchemyId = alchemyId;
    this.shadowHost = shadowHost;
  }

  public LocatorFactory setTieredList( List<LocatorFactory> tieredList ) {
    this.tieredList = tieredList;
    return this;
  }

  /**
   * Given the current context map and a data source provider, this generates a
   * locator
   *
   * @param contextMap
   * @param dM
   * @return
   */
  public Locator create(Page page, Map<String, Object> contextMap, DataSourceProvider dM) {

    Locator shadowLocator = null;

    if (shadowHost != null && !shadowHost.trim().isEmpty()) {
      shadowLocator = ObjectManager.instance().getObject(page, shadowHost, contextMap, dM);
    }

    String useDescriptor = dM.replaceValues(descriptor, contextMap) + "";
    Locator useLocator = null;

    switch( methodId ) {
      case 1 -> { useLocator = page.locator( "xpath=" + useDescriptor );}
      case 2 -> { useLocator = page.locator( "css=" + useDescriptor );}
      case 4 -> { useLocator = page.locator( "#" + useDescriptor );}
      case 5 -> { 
        Locator tieredLocator = null;
        for ( LocatorFactory lF : tieredList ) {
          if ( tieredLocator == null ) {
            tieredLocator = lF.create( page, contextMap, dM );
          } else {
            tieredLocator = tieredLocator.or( lF.create( page, contextMap, dM ) );
          }
        }
	useLocator = tieredLocator;
      }
      case 7 -> { useLocator = page.locator( "." + useDescriptor );}
      case 8 -> { useLocator = page.locator( "xpath=//" + useDescriptor );}
      case 9 -> { useLocator = page.locator( "[name='" + useDescriptor + "']" );}
      case 10 -> { useLocator = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName( useDescriptor ) );}
      case 11 -> { useLocator = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName( useDescriptor ).setExact( true ) );}
      default -> { useLocator = page.locator( "xpath=" + useDescriptor );}
    }

    if (shadowLocator == null) {
      return useLocator;
    } else {
      throw new IllegalArgumentException( "Shadow DOM not supported yet" );
    }

  }

  /**
   *
   * @return
   */
  public String getDescriptor() {
    return descriptor;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the alchemyId
   */
  public String getAlchemyId() {
    return alchemyId;
  }

  /**
   * @return the shadowHost
   */
  public String getShadowHost() {
    return shadowHost;
  }
}
