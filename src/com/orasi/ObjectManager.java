
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

    

bC = new ByFactoryCollection("q", "17267.3182");
bC.add( new ByFactory( ByXPath.class, "//TEXTAREA[@id=\"APjFqb\"]", "IDRule", "17267.3184" ) );
bC.add( new ByFactory( ById.class, "APjFqb", "IDRule", "17267.3186" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"APjFqb\"]", "IDRule", "17267.3188" ) );
bC.add( new ByFactory( ByXPath.class, "//TEXTAREA[@name=\"q\"]", "NameRule", "17267.3190" ) );
bC.add( new ByFactory( ByName.class, "q", "NameRule", "17267.3192" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"q\"]", "NameRule", "17267.3194" ) );


objectMap.put( "17267.3182", bC );
/* Page: default 
    
    */

    /* Page: facebook - Google Search 
    
    */

    

bC = new ByFactoryCollection("Facebook-loginorsignupFacebookhttps://wwwfacebookcom", "17267.3203");
bC.add( new ByFactory( ByXPath.class, "//A[@href='https://www.facebook.com/']", "AttributeRule", "17267.3205" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@href='https://www.facebook.com/']", "AttributeRule", "17267.3207" ) );
bC.add( new ByFactory( ByXPath.class, "//A[@data-ved='2ahUKEwij-NXH6byIAxVExTgGHWG0BX8QFnoECBkQAQ']", "AttributeRule", "17267.3209" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@data-ved='2ahUKEwij-NXH6byIAxVExTgGHWG0BX8QFnoECBkQAQ']", "AttributeRule", "17267.3211" ) );
bC.add( new ByFactory( ByXPath.class, "//A[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.facebook.com/&ved=2ahUKEwij-NXH6byIAxVExTgGHWG0BX8QFnoECBkQAQ']", "AttributeRule", "17267.3213" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.facebook.com/&ved=2ahUKEwij-NXH6byIAxVExTgGHWG0BX8QFnoECBkQAQ']", "AttributeRule", "17267.3215" ) );


objectMap.put( "17267.3203", bC );
/* Page: rahulshetty academy - Google Search 
    
    */

    

bC = new ByFactoryCollection("RahulShettyAcademy:SeleniumAPITestingSoftwareRahulShettyAcademyh...", "17267.3278");
bC.add( new ByFactory( ByXPath.class, "//A[@href='https://rahulshettyacademy.com/']", "AttributeRule", "17267.3280" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@href='https://rahulshettyacademy.com/']", "AttributeRule", "17267.3282" ) );
bC.add( new ByFactory( ByXPath.class, "//A[@data-ved='2ahUKEwiT-Kas7byIAxWnyDgGHdMlPX4QFnoECAoQAQ']", "AttributeRule", "17267.3284" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@data-ved='2ahUKEwiT-Kas7byIAxWnyDgGHdMlPX4QFnoECAoQAQ']", "AttributeRule", "17267.3286" ) );
bC.add( new ByFactory( ByXPath.class, "//A[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://rahulshettyacademy.com/&ved=2ahUKEwiT-Kas7byIAxWnyDgGHdMlPX4QFnoECAoQAQ']", "AttributeRule", "17267.3288" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://rahulshettyacademy.com/&ved=2ahUKEwiT-Kas7byIAxWnyDgGHdMlPX4QFnoECAoQAQ']", "AttributeRule", "17267.3290" ) );


objectMap.put( "17267.3278", bC );
/*
    Site: rahulshettyacademy.com
    Add a description of rahulshettyacademy.com
    */
    /* Page: Selenium, API Testing, Software Testing & More QA Tutorials | Rahul Shetty Academy 
    
    */

    

bC = new ByFactoryCollection("LOGIN", "17267.3298");
bC.add( new ByFactory( ByXPath.class, "//A[@href='https://courses.rahulshettyacademy.com/sign_in']", "AttributeRule", "17267.3300" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@href='https://courses.rahulshettyacademy.com/sign_in']", "AttributeRule", "17267.3302" ) );
bC.add( new ByFactory( ByXPath.class, "//A[@class='theme-btn register-btn']", "AttributeRule", "17267.3304" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@class='theme-btn register-btn']", "AttributeRule", "17267.3306" ) );
bC.add( new ByFactory( ByXPath.class, "//A[./SPAN[@class='icon fa fa-lock']]", "ChildRule[AttributeRule]", "17267.3308" ) );
bC.add( new ByFactory( ByXPath.class, "//A[./*[@class='icon fa fa-lock']]", "ChildRule[AttributeRule]", "17267.3310" ) );
bC.add( new ByFactory( ByXPath.class, "(//DIV[@class='login-btn'])[2]/A[1]", "ParentRule[IndexedAttributeRule]", "17267.3312" ) );


objectMap.put( "17267.3298", bC );
/* Page: default 
    
    */

    /* Page: Rahul Shetty Academy 
    
    */

    

bC = new ByFactoryCollection("email", "17267.3322");
bC.add( new ByFactory( ByXPath.class, "//INPUT[@id=\"email\"]", "IDRule", "17267.3324" ) );
bC.add( new ByFactory( ById.class, "email", "IDRule", "17267.3326" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"email\"]", "IDRule", "17267.3328" ) );
bC.add( new ByFactory( ByXPath.class, "//INPUT[@name=\"email\"]", "NameRule", "17267.3330" ) );
bC.add( new ByFactory( ByName.class, "email", "NameRule", "17267.3332" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"email\"]", "NameRule", "17267.3334" ) );


objectMap.put( "17267.3322", bC );


bC = new ByFactoryCollection("password", "17267.3340");
bC.add( new ByFactory( ByXPath.class, "//INPUT[@id=\"password\"]", "IDRule", "17267.3342" ) );
bC.add( new ByFactory( ById.class, "password", "IDRule", "17267.3344" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"password\"]", "IDRule", "17267.3346" ) );
bC.add( new ByFactory( ByXPath.class, "//INPUT[@name=\"password\"]", "NameRule", "17267.3348" ) );
bC.add( new ByFactory( ByName.class, "password", "NameRule", "17267.3350" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"password\"]", "NameRule", "17267.3352" ) );


objectMap.put( "17267.3340", bC );
/*
    Site: sso.teachable.com
    Add a description of sso.teachable.com
    */
    /*
    Site: www.facebook.com
    Add a description of www.facebook.com
    */
    /* Page: Facebook  log in or sign up 
    
    */

    

bC = new ByFactoryCollection("email", "17267.3222");
bC.add( new ByFactory( ByXPath.class, "//INPUT[@id=\"email\"]", "IDRule", "17267.3224" ) );
bC.add( new ByFactory( ById.class, "email", "IDRule", "17267.3226" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"email\"]", "IDRule", "17267.3228" ) );
bC.add( new ByFactory( ByXPath.class, "//INPUT[@name=\"email\"]", "NameRule", "17267.3230" ) );
bC.add( new ByFactory( ByName.class, "email", "NameRule", "17267.3232" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"email\"]", "NameRule", "17267.3234" ) );


objectMap.put( "17267.3222", bC );


bC = new ByFactoryCollection("pass", "17267.3239");
bC.add( new ByFactory( ByXPath.class, "//INPUT[@id=\"pass\"]", "IDRule", "17267.3241" ) );
bC.add( new ByFactory( ById.class, "pass", "IDRule", "17267.3243" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@id=\"pass\"]", "IDRule", "17267.3245" ) );
bC.add( new ByFactory( ByXPath.class, "//INPUT[@name=\"pass\"]", "NameRule", "17267.3247" ) );
bC.add( new ByFactory( ByName.class, "pass", "NameRule", "17267.3249" ) );
bC.add( new ByFactory( ByXPath.class, "//*[@name=\"pass\"]", "NameRule", "17267.3251" ) );


objectMap.put( "17267.3239", bC );




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
