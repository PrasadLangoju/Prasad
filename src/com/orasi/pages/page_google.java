package com.orasi.pages;

import com.microsoft.playwright.*;
import java.util.*;
import com.microsoft.playwright.options.*;

public class page_google extends AbstractPlayWrightPage {
  public page_google() {
    List<LocatorFactory> factoryList;
    
factoryList = new ArrayList<>(10);
    factoryList.add( new LocatorFactory( 1, "//div[@jsname='vdLsw']/following-sibling::textarea[1]", "SiblingRule", "22681.1712", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@class='gLFyf']", "AttributeRule", "22681.1714", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@class='gLFyf']", "AttributeRule", "22681.1716", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@aria-controls='Alh6id']", "AttributeRule", "22681.1718", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@aria-controls='Alh6id']", "AttributeRule", "22681.1720", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@aria-owns='Alh6id']", "AttributeRule", "22681.1722", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@aria-owns='Alh6id']", "AttributeRule", "22681.1724", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@title='Search']", "AttributeRule", "22681.1726", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@title='Search']", "AttributeRule", "22681.1728", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@jsaction='paste:puy29d;']", "AttributeRule", "22681.1730", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@jsaction='paste:puy29d;']", "AttributeRule", "22681.1732", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@aria-label='Search']", "AttributeRule", "22681.1734", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@aria-label='Search']", "AttributeRule", "22681.1736", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@aria-autocomplete='both']", "AttributeRule", "22681.1738", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@aria-autocomplete='both']", "AttributeRule", "22681.1740", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@aria-expanded='false']", "AttributeRule", "22681.1742", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@aria-haspopup='false']", "AttributeRule", "22681.1744", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@aria-haspopup='false']", "AttributeRule", "22681.1746", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@autocapitalize='off']", "AttributeRule", "22681.1748", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@autocapitalize='off']", "AttributeRule", "22681.1750", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@autocomplete='off']", "AttributeRule", "22681.1752", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@autocorrect='off']", "AttributeRule", "22681.1754", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@autocorrect='off']", "AttributeRule", "22681.1756", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@maxlength='2048']", "AttributeRule", "22681.1758", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@maxlength='2048']", "AttributeRule", "22681.1760", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@role='combobox']", "AttributeRule", "22681.1762", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@role='combobox']", "AttributeRule", "22681.1764", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@rows='1']", "AttributeRule", "22681.1766", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@rows='1']", "AttributeRule", "22681.1768", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@spellcheck='false']", "AttributeRule", "22681.1770", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@spellcheck='false']", "AttributeRule", "22681.1772", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@data-ved='0ahUKEwjbmLzXjPeJAxVDzjQHHcPgJXgQ39UDCAc']", "AttributeRule", "22681.1774", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@data-ved='0ahUKEwjbmLzXjPeJAxVDzjQHHcPgJXgQ39UDCAc']", "AttributeRule", "22681.1776", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@style='caret-color: transparent !important;']", "AttributeRule", "22681.1778", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@id=\"APjFqb\"]", "IDRule", "22681.1780", "" ) );
factoryList.add( new LocatorFactory( 1, "APjFqb", "IDRule", "22681.1782", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@id=\"APjFqb\"]", "IDRule", "22681.1784", "" ) );
factoryList.add( new LocatorFactory( 1, "//textarea[@name=\"q\"]", "NameRule", "22681.1786", "" ) );
factoryList.add( new LocatorFactory( 1, "q", "NameRule", "22681.1788", "" ) );
factoryList.add( new LocatorFactory( 1, "//*[@name=\"q\"]", "NameRule", "22681.1790", "" ) );
addLocator( "22681.1710", new LocatorFactory( 5, null, "q", "22681.1710", "" ).setTieredList( factoryList ) );
    
  }
}