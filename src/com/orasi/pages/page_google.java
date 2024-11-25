package com.orasi.pages;

import com.microsoft.playwright.*;
import java.util.*;
import com.microsoft.playwright.options.*;

public class page_google extends AbstractPlayWrightPage {
  public page_google() {
    List<LocatorFactory> factoryList;
    
factoryList = new ArrayList<>(10);
    factoryList.add( new LocatorFactory( 1, "//div[@jsname='vdLsw']/following-sibling::textarea[1]", "SiblingRule", "22681.1485", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@class='gLFyf']", "AttributeRule", "22681.1487", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@class='gLFyf']", "AttributeRule", "22681.1489", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@aria-controls='Alh6id']", "AttributeRule", "22681.1491", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@aria-controls='Alh6id']", "AttributeRule", "22681.1493", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@aria-owns='Alh6id']", "AttributeRule", "22681.1495", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@aria-owns='Alh6id']", "AttributeRule", "22681.1497", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@title='Search']", "AttributeRule", "22681.1499", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@title='Search']", "AttributeRule", "22681.1501", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@jsaction='paste:puy29d;']", "AttributeRule", "22681.1503", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@jsaction='paste:puy29d;']", "AttributeRule", "22681.1505", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@aria-label='Search']", "AttributeRule", "22681.1507", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@aria-label='Search']", "AttributeRule", "22681.1509", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@aria-autocomplete='both']", "AttributeRule", "22681.1511", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@aria-autocomplete='both']", "AttributeRule", "22681.1513", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@aria-expanded='false']", "AttributeRule", "22681.1515", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@aria-haspopup='false']", "AttributeRule", "22681.1517", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@aria-haspopup='false']", "AttributeRule", "22681.1519", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@autocapitalize='off']", "AttributeRule", "22681.1521", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@autocapitalize='off']", "AttributeRule", "22681.1523", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@autocomplete='off']", "AttributeRule", "22681.1525", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@autocorrect='off']", "AttributeRule", "22681.1527", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@autocorrect='off']", "AttributeRule", "22681.1529", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@maxlength='2048']", "AttributeRule", "22681.1531", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@maxlength='2048']", "AttributeRule", "22681.1533", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@role='combobox']", "AttributeRule", "22681.1535", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@role='combobox']", "AttributeRule", "22681.1537", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@rows='1']", "AttributeRule", "22681.1539", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@rows='1']", "AttributeRule", "22681.1541", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@spellcheck='false']", "AttributeRule", "22681.1543", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@spellcheck='false']", "AttributeRule", "22681.1545", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@data-ved='0ahUKEwjUnKnTiveJAxUB4zQHHehTMh8Q39UDCAc']", "AttributeRule", "22681.1547", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@data-ved='0ahUKEwjUnKnTiveJAxUB4zQHHehTMh8Q39UDCAc']", "AttributeRule", "22681.1549", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@id=\"APjFqb\"]", "IDRule", "22681.1551", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@name=\"q\"]", "NameRule", "22681.1553", "" ) );
factoryList.add( new LocatorFactory( 1, "q", "NameRule", "22681.1555", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@name=\"q\"]", "NameRule", "22681.1557", "" ) );
addLocator( "22681.1483", new LocatorFactory( 5, null, "q", "22681.1483", "" ).setTieredList( factoryList ) );
    
  }
}