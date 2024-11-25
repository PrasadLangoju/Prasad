package com.orasi.pages;

import com.microsoft.playwright.*;
import java.util.*;
import com.orasi.datasource.DataSourceProvider;

public abstract class AbstractPlayWrightPage implements PlayWrightPage{

  private final Map<String,LocatorFactory> locatorMap = new HashMap<>( 10 );

  protected AbstractPlayWrightPage() {

  }

  protected void addLocator( String name, LocatorFactory lF ) {
    locatorMap.put( name, lF );
  }

  @Override
  public Collection<LocatorFactory> getObjects() {
    return locatorMap.values();
  }

  @Override
  public Locator getObject( Page page, Object alchemyIdentifier, Map<String,Object> contextMap, DataSourceProvider dM ) {
    if ( alchemyIdentifier instanceof Locator ) {
      return (Locator) alchemyIdentifier;
    }
    
    Locator locator = locatorMap.get( alchemyIdentifier + "" ).create(page, contextMap, dM);
    return locator;
  }

  @Override
  public LocatorFactory getObject( String alchemyIdentifier ) {
    return locatorMap.get( alchemyIdentifier );
  }

   protected Locator createTieredLocator( List<Locator> locatorList ) {
     Locator baseLocator = null;
     for ( int i=0; i<locatorList.size(); i++ ) {
       if ( baseLocator == null ) {
         baseLocator = locatorList.get( i );
       } else {
         baseLocator = baseLocator.or( locatorList.get( i ) );
       }
     }
     
     return baseLocator;
   }

}