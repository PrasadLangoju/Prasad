
package com.orasi;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.By.*;
import org.openqa.selenium.*;
import com.orasi.datasource.*;


public class ObjectManager {
  private static final ObjectManager singleton = new ObjectManager();
  
  public static final ObjectManager instance() {
    return singleton;
  }
  
  private final Map<String,ByFactory> objectMap = new HashMap<>( 10 );
  
  private ObjectManager() {
    ByFactoryCollection bC = null;
    /*
    Site: www.google.com
    Add a description of www.google.com
    */
    /* Page: Google 
    
    */

    

bC = new ByFactoryCollection("q", "17503.1876");
bC.add( new ByFactory( ByXPath.class, "//TEXTAREA[@id=\"APjFqb\"]", "IDRule", "17503.1878" ) );
bC.add( new ByFactory( ById.class, "APjFqb", "IDRule", "17503.1880" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"APjFqb\"]", "IDRule", "17503.1882" ) );
bC.add( new ByFactory( ByXPath.class, "//TEXTAREA[@name=\"q\"]", "NameRule", "17503.1884" ) );
bC.add( new ByFactory( ByName.class, "q", "NameRule", "17503.1886" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"q\"]", "NameRule", "17503.1888" ) );


objectMap.put( "17503.1876", bC );
/* Page: default 
    
    */

    /* Page: facebook - Google Search 
    
    */

    

bC = new ByFactoryCollection("Facebook-loginorsignupFacebookhttps://wwwfacebookcom", "17503.1897");
bC.add( new ByFactory( ByXPath.class, "//A[@href='https://www.facebook.com/']", "AttributeRule", "17503.1899" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@href='https://www.facebook.com/']", "AttributeRule", "17503.1901" ) );
bC.add( new ByFactory( ByXPath.class, "//A[@data-ved='2ahUKEwjc9r_otceIAxXmzTgGHSB5KfwQFnoECAgQAQ']", "AttributeRule", "17503.1903" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@data-ved='2ahUKEwjc9r_otceIAxXmzTgGHSB5KfwQFnoECAgQAQ']", "AttributeRule", "17503.1905" ) );
bC.add( new ByFactory( ByXPath.class, "//A[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.facebook.com/&ved=2ahUKEwjc9r_otceIAxXmzTgGHSB5KfwQFnoECAgQAQ']", "AttributeRule", "17503.1907" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.facebook.com/&ved=2ahUKEwjc9r_otceIAxXmzTgGHSB5KfwQFnoECAgQAQ']", "AttributeRule", "17503.1909" ) );


objectMap.put( "17503.1897", bC );
/*
    Site: www.facebook.com
    Add a description of www.facebook.com
    */
    /* Page: Facebook  log in or sign up 
    
    */

    

bC = new ByFactoryCollection("email", "17503.1916");
bC.add( new ByFactory( ByXPath.class, "//INPUT[@id=\"email\"]", "IDRule", "17503.1918" ) );
bC.add( new ByFactory( ById.class, "email", "IDRule", "17503.1920" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"email\"]", "IDRule", "17503.1922" ) );
bC.add( new ByFactory( ByXPath.class, "//INPUT[@name=\"email\"]", "NameRule", "17503.1924" ) );
bC.add( new ByFactory( ByName.class, "email", "NameRule", "17503.1926" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"email\"]", "NameRule", "17503.1928" ) );


objectMap.put( "17503.1916", bC );


bC = new ByFactoryCollection("pass", "17503.1933");
bC.add( new ByFactory( ByXPath.class, "//INPUT[@id=\"pass\"]", "IDRule", "17503.1935" ) );
bC.add( new ByFactory( ById.class, "pass", "IDRule", "17503.1937" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"pass\"]", "IDRule", "17503.1939" ) );
bC.add( new ByFactory( ByXPath.class, "//INPUT[@name=\"pass\"]", "NameRule", "17503.1941" ) );
bC.add( new ByFactory( ByName.class, "pass", "NameRule", "17503.1943" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"pass\"]", "NameRule", "17503.1945" ) );


objectMap.put( "17503.1933", bC );




  }
  
  public By getObject( Object alchemyIdentifier, Map<String,Object> contextMap, DataSourceProvider dM ) {
    
    if ( alchemyIdentifier instanceof By ) {
      return (By) alchemyIdentifier;
    }
    
    ByFactory by = objectMap.get( alchemyIdentifier + "" );
    if ( by == null ) {
      return new By() {
        @Override
        public List<WebElement> findElements(SearchContext sc) {
          throw new RuntimeException( "Could not find and object using [" + alchemyIdentifier + "]" );
        }
      };
    }
    return by.create(contextMap, dM);
  }

  public ByFactory getObject( String alchemyIdentifier ) {
   
    return objectMap.get( alchemyIdentifier );
  }
}
