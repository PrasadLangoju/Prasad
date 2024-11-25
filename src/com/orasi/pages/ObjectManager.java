package com.orasi.pages;

import com.microsoft.playwright.*;
import java.util.*;
import com.orasi.datasource.DataSourceProvider;

public class ObjectManager {
  private static final ObjectManager singleton = new ObjectManager();
  
  public static final ObjectManager instance() {
    return singleton;
  }
  
  private final Map<String,PlayWrightPage> pageMap = new HashMap<>( 10 );
  private final Map<String,LocatorFactory> objectMap = new HashMap<>( 10 );
  
  private ObjectManager() {
    //
    // Pages for www.google.com
    //
    registerPage( new page_google() );
    registerPage( new page_a_default() );
    registerPage( new page_facebook___google_search() );
    
//
    // Pages for www.facebook.com
    //
    registerPage( new page_facebook__log_in_or_sign_up() );
    

  }

  private void registerPage( PlayWrightPage p ) {
    p.getObjects().forEach( t -> {
      pageMap.put( t.getAlchemyId(), p );
      objectMap.put( t.getAlchemyId(), t );
    } );
  }
  
  public Locator getObject( Page page, Object alchemyIdentifier, Map<String,Object> contextMap, DataSourceProvider dM ) {

    if ( alchemyIdentifier instanceof Locator l ) {
      return l;
    }
    
    LocatorFactory lF = objectMap.get( alchemyIdentifier + "" );
    if ( lF == null ) {
      return null;
    }
    return lF.create(page, contextMap, dM);
  }

  public LocatorFactory getObject( String alchemyIdentifier ) {
    return objectMap.get( alchemyIdentifier );
  }

  public PlayWrightPage getPageFor( String alchemyIdentifier ) {
    return pageMap.get( alchemyIdentifier );
  }
}
