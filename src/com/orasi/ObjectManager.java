
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

    

bC = new ByFactoryCollection("q", "18250.428");
bC.add( new ByFactory( ByXPath.class, "//TEXTAREA[@id=\"APjFqb\"]", "IDRule", "18250.430" ) );
bC.add( new ByFactory( ById.class, "APjFqb", "IDRule", "18250.432" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"APjFqb\"]", "IDRule", "18250.434" ) );
bC.add( new ByFactory( ByXPath.class, "//TEXTAREA[@name=\"q\"]", "NameRule", "18250.436" ) );
bC.add( new ByFactory( ByName.class, "q", "NameRule", "18250.438" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"q\"]", "NameRule", "18250.440" ) );


objectMap.put( "18250.428", bC );
/* Page: default 
    
    */

    /* Page: facebook - Google Search 
    
    */

    

bC = new ByFactoryCollection("Facebook-loginorsignupFacebookhttps://wwwfacebookcom", "18250.449");
bC.add( new ByFactory( ByXPath.class, "//A[@href='https://www.facebook.com/']", "AttributeRule", "18250.451" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@href='https://www.facebook.com/']", "AttributeRule", "18250.453" ) );
bC.add( new ByFactory( ByXPath.class, "//A[@data-ved='2ahUKEwjzjcSToOCIAxVx-TgGHVCPAMQQFnoECAsQAQ']", "AttributeRule", "18250.455" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@data-ved='2ahUKEwjzjcSToOCIAxVx-TgGHVCPAMQQFnoECAsQAQ']", "AttributeRule", "18250.457" ) );
bC.add( new ByFactory( ByXPath.class, "//A[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.facebook.com/&ved=2ahUKEwjzjcSToOCIAxVx-TgGHVCPAMQQFnoECAsQAQ']", "AttributeRule", "18250.459" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.facebook.com/&ved=2ahUKEwjzjcSToOCIAxVx-TgGHVCPAMQQFnoECAsQAQ']", "AttributeRule", "18250.461" ) );


objectMap.put( "18250.449", bC );
/*
    Site: www.facebook.com
    Add a description of www.facebook.com
    */
    /* Page: Facebook  log in or sign up 
    
    */

    

bC = new ByFactoryCollection("email", "18250.468");
bC.add( new ByFactory( ByXPath.class, "//INPUT[@id=\"email\"]", "IDRule", "18250.470" ) );
bC.add( new ByFactory( ById.class, "email", "IDRule", "18250.472" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"email\"]", "IDRule", "18250.474" ) );
bC.add( new ByFactory( ByXPath.class, "//INPUT[@name=\"email\"]", "NameRule", "18250.476" ) );
bC.add( new ByFactory( ByName.class, "email", "NameRule", "18250.478" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"email\"]", "NameRule", "18250.480" ) );


objectMap.put( "18250.468", bC );


bC = new ByFactoryCollection("pass", "18250.485");
bC.add( new ByFactory( ByXPath.class, "//INPUT[@id=\"pass\"]", "IDRule", "18250.487" ) );
bC.add( new ByFactory( ById.class, "pass", "IDRule", "18250.489" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"pass\"]", "IDRule", "18250.491" ) );
bC.add( new ByFactory( ByXPath.class, "//INPUT[@name=\"pass\"]", "NameRule", "18250.493" ) );
bC.add( new ByFactory( ByName.class, "pass", "NameRule", "18250.495" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"pass\"]", "NameRule", "18250.497" ) );


objectMap.put( "18250.485", bC );




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
