package com.orasi.pages;

import com.microsoft.playwright.*;
import java.util.*;
import com.microsoft.playwright.options.*;

public class page_facebook__log_in_or_sign_up extends AbstractPlayWrightPage {
  public page_facebook__log_in_or_sign_up() {
    List<LocatorFactory> factoryList;
    
factoryList = new ArrayList<>(10);
    factoryList.add( new LocatorFactory( 1, "//input[@type='text']", "AttributeRule", "22681.1830", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@type='text']", "AttributeRule", "22681.1832", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@class='inputtext _55r1 _6luy']", "AttributeRule", "22681.1834", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@class='inputtext _55r1 _6luy']", "AttributeRule", "22681.1836", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@data-testid='royal_email']", "AttributeRule", "22681.1838", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@data-testid='royal_email']", "AttributeRule", "22681.1840", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@placeholder='Email address or phone number']", "AttributeRule", "22681.1842", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@placeholder='Email address or phone number']", "AttributeRule", "22681.1844", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@autofocus='1']", "AttributeRule", "22681.1846", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@autofocus='1']", "AttributeRule", "22681.1848", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@aria-label='Email address or phone number']", "AttributeRule", "22681.1850", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@aria-label='Email address or phone number']", "AttributeRule", "22681.1852", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@id=\"email\"]", "IDRule", "22681.1854", "" ) );
factoryList.add( new LocatorFactory( 1, "email", "IDRule", "22681.1856", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@id=\"email\"]", "IDRule", "22681.1858", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@name=\"email\"]", "NameRule", "22681.1860", "" ) );
factoryList.add( new LocatorFactory( 1, "email", "NameRule", "22681.1862", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@name=\"email\"]", "NameRule", "22681.1864", "" ) );
addLocator( "22681.1828", new LocatorFactory( 5, null, "email", "22681.1828", "" ).setTieredList( factoryList ) );
    
factoryList = new ArrayList<>(10);
    factoryList.add( new LocatorFactory( 1, "//input[@type='password']", "AttributeRule", "22681.1871", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@type='password']", "AttributeRule", "22681.1873", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@class='inputtext _55r1 _6luy _9npi']", "AttributeRule", "22681.1875", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@class='inputtext _55r1 _6luy _9npi']", "AttributeRule", "22681.1877", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@data-testid='royal_pass']", "AttributeRule", "22681.1879", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@data-testid='royal_pass']", "AttributeRule", "22681.1881", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@placeholder='Password']", "AttributeRule", "22681.1883", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@placeholder='Password']", "AttributeRule", "22681.1885", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@aria-label='Password']", "AttributeRule", "22681.1887", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@aria-label='Password']", "AttributeRule", "22681.1889", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@id=\"pass\"]", "IDRule", "22681.1891", "" ) );
factoryList.add( new LocatorFactory( 1, "pass", "IDRule", "22681.1893", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@id=\"pass\"]", "IDRule", "22681.1895", "" ) );
factoryList.add( new LocatorFactory( 1, "//input[@name=\"pass\"]", "NameRule", "22681.1897", "" ) );
factoryList.add( new LocatorFactory( 1, "pass", "NameRule", "22681.1899", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@name=\"pass\"]", "NameRule", "22681.1901", "" ) );
factoryList.add( new LocatorFactory( 1, "//div[@class='_6luy _55r1 _1kbt _9nyi']/input[1]", "ParentRule[AttributeRule]", "22681.1903", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@class='_6luy _55r1 _1kbt _9nyi']/input[1]", "ParentRule[AttributeRule]", "22681.1905", "" ) );
factoryList.add( new LocatorFactory( 1, "//div[@id=\"passContainer\"]/input[1]", "ParentRule[IDRule]", "22681.1907", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@id=\"passContainer\"]/input[1]", "ParentRule[IDRule]", "22681.1909", "" ) );
addLocator( "22681.1869", new LocatorFactory( 5, null, "pass", "22681.1869", "" ).setTieredList( factoryList ) );
    
  }
}