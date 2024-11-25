package com.orasi.pages;

import com.microsoft.playwright.*;
import java.util.*;
import com.microsoft.playwright.options.*;

public class page_facebook__log_in_or_sign_up extends AbstractPlayWrightPage {
  public page_facebook__log_in_or_sign_up() {
    List<LocatorFactory> factoryList;
    
factoryList = new ArrayList<>(10);
    factoryList.add( new LocatorFactory( 1, "//input[@type='text']", "AttributeRule", "22681.1595", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@type='text']", "AttributeRule", "22681.1597", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@class='inputtext _55r1 _6luy']", "AttributeRule", "22681.1599", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@class='inputtext _55r1 _6luy']", "AttributeRule", "22681.1601", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@data-testid='royal_email']", "AttributeRule", "22681.1603", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@data-testid='royal_email']", "AttributeRule", "22681.1605", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@placeholder='Email address or phone number']", "AttributeRule", "22681.1607", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@placeholder='Email address or phone number']", "AttributeRule", "22681.1609", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@autofocus='1']", "AttributeRule", "22681.1611", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@autofocus='1']", "AttributeRule", "22681.1613", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@aria-label='Email address or phone number']", "AttributeRule", "22681.1615", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@aria-label='Email address or phone number']", "AttributeRule", "22681.1617", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@id=\"email\"]", "IDRule", "22681.1619", "" ) );
factoryList.add( new LocatorFactory( 1, "email", "IDRule", "22681.1621", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@id=\"email\"]", "IDRule", "22681.1623", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@name=\"email\"]", "NameRule", "22681.1625", "" ) );
factoryList.add( new LocatorFactory( 1, "email", "NameRule", "22681.1627", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@name=\"email\"]", "NameRule", "22681.1629", "" ) );
addLocator( "22681.1593", new LocatorFactory( 5, null, "email", "22681.1593", "" ).setTieredList( factoryList ) );
    
factoryList = new ArrayList<>(10);
    factoryList.add( new LocatorFactory( 1, "//input[@type='password']", "AttributeRule", "22681.1636", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@type='password']", "AttributeRule", "22681.1638", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@class='inputtext _55r1 _6luy _9npi']", "AttributeRule", "22681.1640", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@class='inputtext _55r1 _6luy _9npi']", "AttributeRule", "22681.1642", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@data-testid='royal_pass']", "AttributeRule", "22681.1644", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@data-testid='royal_pass']", "AttributeRule", "22681.1646", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@placeholder='Password']", "AttributeRule", "22681.1648", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@placeholder='Password']", "AttributeRule", "22681.1650", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@aria-label='Password']", "AttributeRule", "22681.1652", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@aria-label='Password']", "AttributeRule", "22681.1654", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@id=\"pass\"]", "IDRule", "22681.1656", "" ) );
factoryList.add( new LocatorFactory( 1, "pass", "IDRule", "22681.1658", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@id=\"pass\"]", "IDRule", "22681.1660", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@name=\"pass\"]", "NameRule", "22681.1662", "" ) );
factoryList.add( new LocatorFactory( 1, "pass", "NameRule", "22681.1664", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@name=\"pass\"]", "NameRule", "22681.1666", "" ) );
factoryList.add( new LocatorFactory( 1, "//div[@class='_6luy _55r1 _1kbt _9nyi']/input[1]", "ParentRule[AttributeRule]", "22681.1668", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@class='_6luy _55r1 _1kbt _9nyi']/input[1]", "ParentRule[AttributeRule]", "22681.1670", "" ) );
factoryList.add( new LocatorFactory( 1, "//div[@id=\"passContainer\"]/input[1]", "ParentRule[IDRule]", "22681.1672", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@id=\"passContainer\"]/input[1]", "ParentRule[IDRule]", "22681.1674", "" ) );
addLocator( "22681.1634", new LocatorFactory( 5, null, "pass", "22681.1634", "" ).setTieredList( factoryList ) );
    
  }
}