
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

    

bC = new ByFactoryCollection("q", "17564.3732");
bC.add( new ByFactory( ByXPath.class, "//TEXTAREA[@id=\"APjFqb\"]", "IDRule", "17564.3734" ) );
bC.add( new ByFactory( ById.class, "APjFqb", "IDRule", "17564.3736" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"APjFqb\"]", "IDRule", "17564.3738" ) );
bC.add( new ByFactory( ByXPath.class, "//TEXTAREA[@name=\"q\"]", "NameRule", "17564.3740" ) );
bC.add( new ByFactory( ByName.class, "q", "NameRule", "17564.3742" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"q\"]", "NameRule", "17564.3744" ) );


objectMap.put( "17564.3732", bC );
/* Page: default 
    
    */

    /* Page: facebook - Google Search 
    
    */

    

bC = new ByFactoryCollection("Facebook-loginorsignupFacebookhttps://wwwfacebookcom", "17564.3753");
bC.add( new ByFactory( ByXPath.class, "//A[@href='https://www.facebook.com/']", "AttributeRule", "17564.3755" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@href='https://www.facebook.com/']", "AttributeRule", "17564.3757" ) );
bC.add( new ByFactory( ByXPath.class, "//A[@data-ved='2ahUKEwijqo7PgMqIAxU7S2cHHfNJJAwQFnoECAgQAQ']", "AttributeRule", "17564.3759" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@data-ved='2ahUKEwijqo7PgMqIAxU7S2cHHfNJJAwQFnoECAgQAQ']", "AttributeRule", "17564.3761" ) );
bC.add( new ByFactory( ByXPath.class, "//A[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.facebook.com/&ved=2ahUKEwijqo7PgMqIAxU7S2cHHfNJJAwQFnoECAgQAQ']", "AttributeRule", "17564.3763" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.facebook.com/&ved=2ahUKEwijqo7PgMqIAxU7S2cHHfNJJAwQFnoECAgQAQ']", "AttributeRule", "17564.3765" ) );


objectMap.put( "17564.3753", bC );
/*
    Site: www.facebook.com
    Add a description of www.facebook.com
    */
    /* Page: Facebook  log in or sign up 
    
    */

    

bC = new ByFactoryCollection("email", "17564.3772");
bC.add( new ByFactory( ByXPath.class, "//INPUT[@id=\"email\"]", "IDRule", "17564.3774" ) );
bC.add( new ByFactory( ById.class, "email", "IDRule", "17564.3776" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"email\"]", "IDRule", "17564.3778" ) );
bC.add( new ByFactory( ByXPath.class, "//INPUT[@name=\"email\"]", "NameRule", "17564.3780" ) );
bC.add( new ByFactory( ByName.class, "email", "NameRule", "17564.3782" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"email\"]", "NameRule", "17564.3784" ) );


objectMap.put( "17564.3772", bC );


bC = new ByFactoryCollection("pass", "17564.3789");
bC.add( new ByFactory( ByXPath.class, "//INPUT[@id=\"pass\"]", "IDRule", "17564.3791" ) );
bC.add( new ByFactory( ById.class, "pass", "IDRule", "17564.3793" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"pass\"]", "IDRule", "17564.3795" ) );
bC.add( new ByFactory( ByXPath.class, "//INPUT[@name=\"pass\"]", "NameRule", "17564.3797" ) );
bC.add( new ByFactory( ByName.class, "pass", "NameRule", "17564.3799" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"pass\"]", "NameRule", "17564.3801" ) );


objectMap.put( "17564.3789", bC );




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
