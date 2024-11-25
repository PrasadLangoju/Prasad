package com.orasi;

import com.orasi.pages.*;

public class VariableWrapper {

  private final String name;
  private final Object value;
  private final String textValue;

  public VariableWrapper(String name, Object value, String textValue) {
    this.name = name;
    this.value = value;

    LocatorFactory lF = ObjectManager.instance().getObject(textValue);
    if (lF != null && lF.getName() != null) {
      this.textValue = lF.getName() + " (" + textValue + ")";
      return;
    }
    TestWrapper tW = TestManager.instance().getTest(textValue);
    if (tW != null && tW.getName() != null) {
      this.textValue = tW.getName() + " (" + textValue + ")";
      return;
    }
    
    this.textValue = textValue;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the value
   */
  public Object getValue() {
    return value;
  }

  /**
   * @return the textValue
   */
  public String getTextValue() {
    return textValue;
  }

}
