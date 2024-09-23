
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

    

bC = new ByFactoryCollection("q", "17998.1216");
bC.add( new ByFactory( ByXPath.class, "//TEXTAREA[@id=\"APjFqb\"]", "IDRule", "17998.1218" ) );
bC.add( new ByFactory( ById.class, "APjFqb", "IDRule", "17998.1220" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"APjFqb\"]", "IDRule", "17998.1222" ) );
bC.add( new ByFactory( ByXPath.class, "//TEXTAREA[@name=\"q\"]", "NameRule", "17998.1224" ) );
bC.add( new ByFactory( ByName.class, "q", "NameRule", "17998.1226" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"q\"]", "NameRule", "17998.1228" ) );


objectMap.put( "17998.1216", bC );
/* Page: default 
    
    */

    /* Page: facebook - Google Search 
    
    */

    

bC = new ByFactoryCollection("Facebook-loginorsignupFacebookhttps://wwwfacebookcom", "17998.1237");
bC.add( new ByFactory( ByXPath.class, "//A[@href='https://www.facebook.com/']", "AttributeRule", "17998.1239" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@href='https://www.facebook.com/']", "AttributeRule", "17998.1241" ) );
bC.add( new ByFactory( ByXPath.class, "//A[@data-ved='2ahUKEwjCurGhktmIAxXlna8BHQ0sAcwQFnoECAsQAQ']", "AttributeRule", "17998.1243" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@data-ved='2ahUKEwjCurGhktmIAxXlna8BHQ0sAcwQFnoECAsQAQ']", "AttributeRule", "17998.1245" ) );
bC.add( new ByFactory( ByXPath.class, "//A[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.facebook.com/&ved=2ahUKEwjCurGhktmIAxXlna8BHQ0sAcwQFnoECAsQAQ']", "AttributeRule", "17998.1247" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.facebook.com/&ved=2ahUKEwjCurGhktmIAxXlna8BHQ0sAcwQFnoECAsQAQ']", "AttributeRule", "17998.1249" ) );


objectMap.put( "17998.1237", bC );
/*
    Site: www.facebook.com
    Add a description of www.facebook.com
    */
    /* Page: Log in to Facebook 
    
    */

    

bC = new ByFactoryCollection("email", "17998.1256");
bC.add( new ByFactory( ByXPath.class, "//INPUT[@id=\"email\"]", "IDRule", "17998.1258" ) );
bC.add( new ByFactory( ById.class, "email", "IDRule", "17998.1260" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"email\"]", "IDRule", "17998.1262" ) );
bC.add( new ByFactory( ByXPath.class, "//INPUT[@name=\"email\"]", "NameRule", "17998.1264" ) );
bC.add( new ByFactory( ByName.class, "email", "NameRule", "17998.1266" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"email\"]", "NameRule", "17998.1268" ) );


objectMap.put( "17998.1256", bC );


bC = new ByFactoryCollection("pass", "17998.1273");
bC.add( new ByFactory( ByXPath.class, "//INPUT[@id=\"pass\"]", "IDRule", "17998.1275" ) );
bC.add( new ByFactory( ById.class, "pass", "IDRule", "17998.1277" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"pass\"]", "IDRule", "17998.1279" ) );
bC.add( new ByFactory( ByXPath.class, "//INPUT[@name=\"pass\"]", "NameRule", "17998.1281" ) );
bC.add( new ByFactory( ByName.class, "pass", "NameRule", "17998.1283" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"pass\"]", "NameRule", "17998.1285" ) );


objectMap.put( "17998.1273", bC );




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
