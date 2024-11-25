package com.orasi.pages;

import com.microsoft.playwright.*;
import java.util.*;
import com.orasi.datasource.DataSourceProvider;

public interface PlayWrightPage {
  Locator getObject( Page page, Object alchemyIdentifier, Map<String,Object> contextMap, DataSourceProvider dM );
  LocatorFactory getObject( String alchemyIdentifier );
  Collection<LocatorFactory> getObjects();
}