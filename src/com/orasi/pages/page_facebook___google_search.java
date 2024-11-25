package com.orasi.pages;

import com.microsoft.playwright.*;
import java.util.*;
import com.microsoft.playwright.options.*;

public class page_facebook___google_search extends AbstractPlayWrightPage {
  public page_facebook___google_search() {
    List<LocatorFactory> factoryList;
    
factoryList = new ArrayList<>(10);
    factoryList.add( new LocatorFactory( 1, "//a[@href='https://www.facebook.com/']", "AttributeRule", "22681.1568", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@href='https://www.facebook.com/']", "AttributeRule", "22681.1570", "" ) );
factoryList.add( new LocatorFactory( 1, "//a[@data-ved='2ahUKEwj29rPViveJAxVEc_UHHfDzAcYQFnoECBsQAQ']", "AttributeRule", "22681.1572", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@data-ved='2ahUKEwj29rPViveJAxVEc_UHHfDzAcYQFnoECBsQAQ']", "AttributeRule", "22681.1574", "" ) );
factoryList.add( new LocatorFactory( 1, "//a[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.facebook.com/&ved=2ahUKEwj29rPViveJAxVEc_UHHfDzAcYQFnoECBsQAQ']", "AttributeRule", "22681.1576", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.facebook.com/&ved=2ahUKEwj29rPViveJAxVEc_UHHfDzAcYQFnoECBsQAQ']", "AttributeRule", "22681.1578", "" ) );
factoryList.add( new LocatorFactory( 1, "//a[./h3[text()=\"Facebook - log in or sign up\"]]", "ChildRule[TextRule]", "22681.1580", "" ) );
factoryList.add( new LocatorFactory( 1, "(//a[@jsname='UWckNb'])[1]", "IndexedAttributeRule", "22681.1582", "" ) );
factoryList.add( new LocatorFactory( 1, "//div[@class='tF2Cxc']/div[1]/div[1]/span[1]/a[1]", "ParentRule[AttributeRule]", "22681.1584", "" ) );
factoryList.add( new LocatorFactory( 1, "/body[1]/div[3]/div[1]/div[13]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/a[1]", "AbsoluteRule", "22681.1586", "" ) );
addLocator( "22681.1566", new LocatorFactory( 5, null, "Facebook-loginorsignupFacebookhttps://wwwfacebookcom", "22681.1566", "" ).setTieredList( factoryList ) );
    
  }
}