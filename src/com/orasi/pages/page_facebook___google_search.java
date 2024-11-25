package com.orasi.pages;

import com.microsoft.playwright.*;
import java.util.*;
import com.microsoft.playwright.options.*;

public class page_facebook___google_search extends AbstractPlayWrightPage {
  public page_facebook___google_search() {
    List<LocatorFactory> factoryList;
    
factoryList = new ArrayList<>(10);
    factoryList.add( new LocatorFactory( 1, "//a[@href='https://m.facebook.com/']", "AttributeRule", "22681.1801", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@href='https://m.facebook.com/']", "AttributeRule", "22681.1803", "" ) );
factoryList.add( new LocatorFactory( 1, "//a[@data-ved='2ahUKEwi934vZjPeJAxWrgq8BHQ7fPB8QFnoECA4QAQ']", "AttributeRule", "22681.1805", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@data-ved='2ahUKEwi934vZjPeJAxWrgq8BHQ7fPB8QFnoECA4QAQ']", "AttributeRule", "22681.1807", "" ) );
factoryList.add( new LocatorFactory( 1, "//a[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://m.facebook.com/&ved=2ahUKEwi934vZjPeJAxWrgq8BHQ7fPB8QFnoECA4QAQ']", "AttributeRule", "22681.1809", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@ping='/url?sa=t&source=web&rct=j&opi=89978449&url=https://m.facebook.com/&ved=2ahUKEwi934vZjPeJAxWrgq8BHQ7fPB8QFnoECA4QAQ']", "AttributeRule", "22681.1811", "" ) );
factoryList.add( new LocatorFactory( 1, "//a[./h3[text()=\"Facebook - log in or sign up\"]]", "ChildRule[TextRule]", "22681.1813", "" ) );
factoryList.add( new LocatorFactory( 1, "(//a[@jsname='UWckNb'])[1]", "IndexedAttributeRule", "22681.1815", "" ) );
factoryList.add( new LocatorFactory( 1, "//div[@class='tF2Cxc']/div[1]/div[1]/span[1]/a[1]", "ParentRule[AttributeRule]", "22681.1817", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@class='tF2Cxc']/div[1]/div[1]/span[1]/a[1]", "ParentRule[AttributeRule]", "22681.1819", "" ) );
factoryList.add( new LocatorFactory( 1, "/body[1]/div[3]/div[1]/div[12]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/a[1]", "AbsoluteRule", "22681.1821", "" ) );
addLocator( "22681.1799", new LocatorFactory( 5, null, "Facebook-loginorsignupFacebookhttps://mfacebookcom", "22681.1799", "" ).setTieredList( factoryList ) );
    
  }
}