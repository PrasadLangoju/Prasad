/**
  * @version 0
  */
 package org.org_1.git_testing;

 import java.util.*;
 import java.util.function.*;
 import java.io.*;
 import java.lang.reflect.*;
 import org.apache.commons.logging.*;
 import com.microsoft.playwright.options.*;
 import com.microsoft.playwright.*;
 import com.google.gson.*;
 import static com.orasi.ActionLibrary.*;
 import com.orasi.event.spi.*;
 import com.orasi.event.configuration.*;
 import com.orasi.*;
 import com.orasi.model.*;
 import com.orasi.datasource.*;
 import com.orasi.alchemy.mediation.execution.*;
 import java.time.*;
 
 public class t1 extends AbstractTestWrapper
 {
   Map<String,FunctionVariableWrapper> ingressSignature = new HashMap<>( 5 );;

   public t1() {
     super(13403, "22681.1475", "T1", "Add a description of T1", 0, "", "".split(","), "{\"symphonyId\":0,\"id\":13403,\"name\":\"T1\",\"description\":\"Add a description of T1\",\"userId\":15,\"userConfidence\":0,\"organizationId\":1,\"organizationConfidence\":0,\"status\":1,\"reviewFlag\":0,\"createDate\":\"Nov 25, 2024, 8:40:44 AM\",\"modifyDate\":\"Nov 25, 2024, 8:40:44 AM\",\"version\":0,\"lockUserId\":0,\"level\":1,\"pre\":\"\",\"post\":\"\",\"deviceTagNames\":\"\",\"changeCount\":0,\"uniqueContributors\":0,\"stepCount\":0,\"testUserConfidence\":0.0,\"errorHandler\":\"\",\"classificationId\":0,\"synchronizationId\":0,\"storageVersion\":2,\"alchemyId\":1475,\"alchemySeed\":22681,\"referenceSuiteID\":0,\"signature\":\"null\",\"acls\":[],\"changed\":false}");
   }

   private void sleep( long sleepTime ) {
    try {
      Thread.sleep( sleepTime );
    } catch( InterruptedException ignoreMe) {
      
    }
  }
 
 	@Override
   public void _executeTest( int executionId, int testExecutionId, final BrowserWrapper bW, final Map<String,Object> contextMap, String contextName, final Stack<String> callStack, final Stack<Integer> stepStack )
   {
    String testName = "t1";

    if ( contextMap.get( "__callStyle" ) == null ) { contextMap.put( "__callStyle", 1 ); }
    callStack.push( getClass().getName() );
    if ( stepStack.isEmpty() ) stepStack.push( 0 );
    int callStyle = (Integer) contextMap.get( "__callStyle" );
    final Deque<StepEvent> eventList = new ArrayDeque<>( 10 );

    DataSourceProvider dS = DataSourceProviderFactory.instance().getDataSourceProvider();
    if ( dS == null ) {
      throw new IllegalArgumentException( "No Data Source Provider was specified" );
    }

    //
    // Initialize the Action Mediator for this test
    //
    ActionMediator aM = new ActionMediator(executionId, testExecutionId, testName, bW, contextMap, callStack, stepStack, callStyle);
    VariableMediator vM = new VariableMediator();
    

    try
    {
      
      
      
      
      

      
      vM.clear();

      ingressSignature.clear();
      

      vM.addVariable( createVariable( "url", 15, true, "http://www.google.com", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "timeout", 2, true, "30000", dS, contextMap, bW ) );
      

      if ( !ingressSignature.isEmpty() ) {
	vM.addVariable( new VariableWrapper( "__dS", dS, "" ) );
        vM.addVariable( new VariableWrapper( "ingressSignature", ingressSignature, "" ) );
      }
      eventList.add( aM.executeAction( "Navigate_v1", "", 1, vM.generateVariables(), vM.generateVariableDefinitions(), "{\"templateImplId\":320,\"checkpointId\":1,\"alchemyId\":1478,\"alchemySeed\":22681,\"pauseBefore\":0,\"waitFor\":5000,\"pauseAfter\":0,\"variableList\":[{\"value\":\"http://www.google.com\",\"inputId\":7,\"templateId\":0,\"inputName\":\"url\",\"inputDescription\":\"The Application Locator\",\"inputData\":\"null\",\"inputTypeId\":15,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"30000\",\"inputId\":7,\"templateId\":0,\"inputName\":\"timeout\",\"inputDescription\":\"The time in milliseconds to wait for a page to load\",\"inputData\":\"null\",\"inputTypeId\":2,\"inputRequired\":1,\"status\":1,\"changed\":false}],\"functionVariables\":[],\"status\":1,\"actionId\":5,\"parentId\":0,\"endpointId\":0,\"templateId\":0,\"tversion\":1,\"tstyleId\":127,\"tstatus\":1,\"verifiedBy\":0,\"onFailure\":1,\"invertResult\":false,\"actionDisplay\":\"Navigate to {var:url}\",\"changed\":false}", stepStack.peek(), (t4) -> {  return null; }, false, 0, 5000, 0, 1 ) );
      
      vM.clear();

      ingressSignature.clear();
      

      vM.addVariable( createVariable( "action", 10, true, "Resize", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "height", 2, true, "767.0", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "width", 2, true, "1024.0", dS, contextMap, bW ) );
      

      if ( !ingressSignature.isEmpty() ) {
	vM.addVariable( new VariableWrapper( "__dS", dS, "" ) );
        vM.addVariable( new VariableWrapper( "ingressSignature", ingressSignature, "" ) );
      }
      eventList.add( aM.executeAction( "Browser_v1", "", 1, vM.generateVariables(), vM.generateVariableDefinitions(), "{\"templateImplId\":325,\"checkpointId\":1,\"alchemyId\":1479,\"alchemySeed\":22681,\"pauseBefore\":0,\"waitFor\":5000,\"pauseAfter\":0,\"variableList\":[{\"value\":\"Resize\",\"inputId\":0,\"templateId\":0,\"inputName\":\"action\",\"inputDescription\":\"The action to take on the browser\",\"inputData\":\"Back,Forward,Refresh,Resize,Maximize,Minimize,Full Screen,Close\",\"inputTypeId\":10,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"767.0\",\"inputId\":0,\"templateId\":0,\"inputName\":\"height\",\"inputDescription\":\"When the Resize method is selected, this value will specify the height of the browser\",\"inputData\":\"\",\"inputTypeId\":2,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"1024.0\",\"inputId\":0,\"templateId\":0,\"inputName\":\"width\",\"inputDescription\":\"When the Resize method is selected, this value will specify the width of the browser\",\"inputData\":\"\",\"inputTypeId\":2,\"inputRequired\":1,\"status\":1,\"changed\":false}],\"functionVariables\":[],\"status\":1,\"actionId\":37,\"parentId\":0,\"endpointId\":0,\"templateId\":0,\"tversion\":1,\"tstyleId\":127,\"tstatus\":1,\"verifiedBy\":0,\"onFailure\":1,\"invertResult\":false,\"actionDisplay\":\"Perform the {var:action} browser action\",\"changed\":false}", stepStack.peek(), (t4) -> {  return null; }, false, 0, 5000, 0, 1 ) );
      
      vM.clear();

      ingressSignature.clear();
      

      vM.addVariable( createVariable( "targetLocator", 5, true, "22681.1483", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "method", 10, false, "Default", dS, contextMap, bW ) );
      

      if ( !ingressSignature.isEmpty() ) {
	vM.addVariable( new VariableWrapper( "__dS", dS, "" ) );
        vM.addVariable( new VariableWrapper( "ingressSignature", ingressSignature, "" ) );
      }
      eventList.add( aM.executeAction( "Click_v1", "", 1, vM.generateVariables(), vM.generateVariableDefinitions(), "{\"templateImplId\":326,\"checkpointId\":1,\"alchemyId\":1558,\"alchemySeed\":22681,\"pauseBefore\":0,\"waitFor\":5000,\"pauseAfter\":0,\"variableList\":[{\"value\":\"22681.1483\",\"inputId\":1,\"templateId\":0,\"inputName\":\"targetLocator\",\"inputDescription\":\"The name of the locator retrieved from the elements\",\"inputTypeId\":5,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"Default\",\"inputId\":59,\"templateId\":0,\"inputName\":\"method\",\"inputDescription\":\"The method used to click.  If omitted, default is used\",\"inputData\":\"Default,No Wait,Simple,Double,Right\",\"inputTypeId\":10,\"inputRequired\":0,\"status\":1,\"changed\":false}],\"functionVariables\":[],\"status\":1,\"actionId\":1,\"parentId\":0,\"endpointId\":0,\"templateId\":0,\"tversion\":1,\"tstyleId\":127,\"tstatus\":1,\"verifiedBy\":0,\"onFailure\":1,\"invertResult\":false,\"actionDisplay\":\"Click on {var:targetLocator}\",\"changed\":false}", stepStack.peek(), (t4) -> {  return null; }, false, 0, 5000, 0, 1 ) );
      
      vM.clear();

      ingressSignature.clear();
      

      vM.addVariable( createVariable( "value", 1, true, "facebook", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "clearFirst", 4, true, "true", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "targetLocator", 5, true, "22681.1483", dS, contextMap, bW ) );
      

      if ( !ingressSignature.isEmpty() ) {
	vM.addVariable( new VariableWrapper( "__dS", dS, "" ) );
        vM.addVariable( new VariableWrapper( "ingressSignature", ingressSignature, "" ) );
      }
      eventList.add( aM.executeAction( "Type_v1", "", 1, vM.generateVariables(), vM.generateVariableDefinitions(), "{\"templateImplId\":328,\"checkpointId\":1,\"alchemyId\":1559,\"alchemySeed\":22681,\"pauseBefore\":0,\"waitFor\":5000,\"pauseAfter\":0,\"variableList\":[{\"value\":\"facebook\",\"inputId\":31,\"templateId\":0,\"inputName\":\"value\",\"inputDescription\":\"The text to type\",\"inputData\":\"null\",\"inputTypeId\":1,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"true\",\"inputId\":32,\"templateId\":0,\"inputName\":\"clearFirst\",\"inputDescription\":\"A flag indicating if the value should first be cleared\",\"inputData\":\"null\",\"inputTypeId\":4,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"22681.1483\",\"inputId\":33,\"templateId\":0,\"inputName\":\"targetLocator\",\"inputDescription\":\"The element that will receive the text\",\"inputTypeId\":5,\"inputRequired\":1,\"status\":1,\"changed\":false}],\"functionVariables\":[],\"status\":1,\"actionId\":17,\"parentId\":0,\"endpointId\":0,\"templateId\":0,\"tversion\":1,\"tstyleId\":127,\"tstatus\":1,\"verifiedBy\":0,\"onFailure\":1,\"invertResult\":false,\"actionDisplay\":\"Type {var:value} into {var:targetLocator}\",\"changed\":false}", stepStack.peek(), (t4) -> {  return null; }, false, 0, 5000, 0, 1 ) );
      
      vM.clear();

      ingressSignature.clear();
      

      vM.addVariable( createVariable( "Control", 4, true, "", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "Shift", 4, true, "", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "Alt", 4, true, "", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "Key", 1, true, "ENTER", dS, contextMap, bW ) );
      

      if ( !ingressSignature.isEmpty() ) {
	vM.addVariable( new VariableWrapper( "__dS", dS, "" ) );
        vM.addVariable( new VariableWrapper( "ingressSignature", ingressSignature, "" ) );
      }
      eventList.add( aM.executeAction( "Keys_v1", "", 1, vM.generateVariables(), vM.generateVariableDefinitions(), "{\"templateImplId\":329,\"checkpointId\":1,\"alchemyId\":1560,\"alchemySeed\":22681,\"pauseBefore\":0,\"waitFor\":5000,\"pauseAfter\":0,\"variableList\":[{\"value\":\"\",\"inputId\":0,\"templateId\":0,\"inputName\":\"Control\",\"inputDescription\":\"Is the Control key pressed as part of this key sequence\",\"inputData\":\"\",\"inputTypeId\":4,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"\",\"inputId\":0,\"templateId\":0,\"inputName\":\"Shift\",\"inputDescription\":\"Is the Shift key pressed as part of this key sequence\",\"inputData\":\"\",\"inputTypeId\":4,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"\",\"inputId\":0,\"templateId\":0,\"inputName\":\"Alt\",\"inputDescription\":\"Was the Alt key pressed as part of this key sequence\",\"inputData\":\"\",\"inputTypeId\":4,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"ENTER\",\"inputId\":0,\"templateId\":0,\"inputName\":\"Key\",\"inputDescription\":\"An attempt will be made first to find a constart mapping to this string.  If not found, it will send the keys supplied as individual characters\",\"inputData\":\"\",\"inputTypeId\":1,\"inputRequired\":1,\"status\":1,\"changed\":false}],\"functionVariables\":[],\"status\":1,\"actionId\":35,\"parentId\":0,\"endpointId\":0,\"templateId\":0,\"tversion\":1,\"tstyleId\":127,\"tstatus\":1,\"verifiedBy\":0,\"onFailure\":1,\"invertResult\":false,\"actionDisplay\":\"Send the keys {var:Key} to your application\",\"changed\":false}", stepStack.peek(), (t4) -> {  return null; }, false, 0, 5000, 0, 1 ) );
      
      vM.clear();

      ingressSignature.clear();
      

      vM.addVariable( createVariable( "targetLocator", 5, true, "22681.1566", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "method", 10, false, "Default", dS, contextMap, bW ) );
      

      if ( !ingressSignature.isEmpty() ) {
	vM.addVariable( new VariableWrapper( "__dS", dS, "" ) );
        vM.addVariable( new VariableWrapper( "ingressSignature", ingressSignature, "" ) );
      }
      eventList.add( aM.executeAction( "Click_v1", "", 1, vM.generateVariables(), vM.generateVariableDefinitions(), "{\"templateImplId\":326,\"checkpointId\":1,\"alchemyId\":1587,\"alchemySeed\":22681,\"pauseBefore\":0,\"waitFor\":5000,\"pauseAfter\":0,\"variableList\":[{\"value\":\"22681.1566\",\"inputId\":1,\"templateId\":0,\"inputName\":\"targetLocator\",\"inputDescription\":\"The name of the locator retrieved from the elements\",\"inputTypeId\":5,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"Default\",\"inputId\":59,\"templateId\":0,\"inputName\":\"method\",\"inputDescription\":\"The method used to click.  If omitted, default is used\",\"inputData\":\"Default,No Wait,Simple,Double,Right\",\"inputTypeId\":10,\"inputRequired\":0,\"status\":1,\"changed\":false}],\"functionVariables\":[],\"status\":1,\"actionId\":1,\"parentId\":0,\"endpointId\":5,\"templateId\":0,\"tversion\":1,\"tstyleId\":127,\"tstatus\":1,\"verifiedBy\":0,\"onFailure\":1,\"invertResult\":false,\"actionDisplay\":\"Click on {var:targetLocator}\",\"changed\":false}", stepStack.peek(), (t4) -> {  return null; }, false, 0, 5000, 0, 1 ) );
      
      vM.clear();

      ingressSignature.clear();
      

      vM.addVariable( createVariable( "value", 1, true, "srimanikanta", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "clearFirst", 4, true, "true", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "targetLocator", 5, true, "22681.1593", dS, contextMap, bW ) );
      

      if ( !ingressSignature.isEmpty() ) {
	vM.addVariable( new VariableWrapper( "__dS", dS, "" ) );
        vM.addVariable( new VariableWrapper( "ingressSignature", ingressSignature, "" ) );
      }
      eventList.add( aM.executeAction( "Type_v1", "", 1, vM.generateVariables(), vM.generateVariableDefinitions(), "{\"templateImplId\":328,\"checkpointId\":1,\"alchemyId\":1630,\"alchemySeed\":22681,\"pauseBefore\":0,\"waitFor\":5000,\"pauseAfter\":0,\"variableList\":[{\"value\":\"srimanikanta\",\"inputId\":31,\"templateId\":0,\"inputName\":\"value\",\"inputDescription\":\"The text to type\",\"inputData\":\"null\",\"inputTypeId\":1,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"true\",\"inputId\":32,\"templateId\":0,\"inputName\":\"clearFirst\",\"inputDescription\":\"A flag indicating if the value should first be cleared\",\"inputData\":\"null\",\"inputTypeId\":4,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"22681.1593\",\"inputId\":33,\"templateId\":0,\"inputName\":\"targetLocator\",\"inputDescription\":\"The element that will receive the text\",\"inputTypeId\":5,\"inputRequired\":1,\"status\":1,\"changed\":false}],\"functionVariables\":[],\"status\":1,\"actionId\":17,\"parentId\":0,\"endpointId\":5,\"templateId\":0,\"tversion\":1,\"tstyleId\":127,\"tstatus\":1,\"verifiedBy\":0,\"onFailure\":1,\"invertResult\":false,\"actionDisplay\":\"Type {var:value} into {var:targetLocator}\",\"changed\":false}", stepStack.peek(), (t4) -> {  return null; }, false, 0, 5000, 0, 1 ) );
      
      vM.clear();

      ingressSignature.clear();
      

      vM.addVariable( createVariable( "Control", 4, true, "", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "Shift", 4, true, "", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "Alt", 4, true, "", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "Key", 1, true, "TAB", dS, contextMap, bW ) );
      

      if ( !ingressSignature.isEmpty() ) {
	vM.addVariable( new VariableWrapper( "__dS", dS, "" ) );
        vM.addVariable( new VariableWrapper( "ingressSignature", ingressSignature, "" ) );
      }
      eventList.add( aM.executeAction( "Keys_v1", "", 1, vM.generateVariables(), vM.generateVariableDefinitions(), "{\"templateImplId\":329,\"checkpointId\":1,\"alchemyId\":1631,\"alchemySeed\":22681,\"pauseBefore\":0,\"waitFor\":5000,\"pauseAfter\":0,\"variableList\":[{\"value\":\"\",\"inputId\":0,\"templateId\":0,\"inputName\":\"Control\",\"inputDescription\":\"Is the Control key pressed as part of this key sequence\",\"inputData\":\"\",\"inputTypeId\":4,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"\",\"inputId\":0,\"templateId\":0,\"inputName\":\"Shift\",\"inputDescription\":\"Is the Shift key pressed as part of this key sequence\",\"inputData\":\"\",\"inputTypeId\":4,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"\",\"inputId\":0,\"templateId\":0,\"inputName\":\"Alt\",\"inputDescription\":\"Was the Alt key pressed as part of this key sequence\",\"inputData\":\"\",\"inputTypeId\":4,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"TAB\",\"inputId\":0,\"templateId\":0,\"inputName\":\"Key\",\"inputDescription\":\"An attempt will be made first to find a constart mapping to this string.  If not found, it will send the keys supplied as individual characters\",\"inputData\":\"\",\"inputTypeId\":1,\"inputRequired\":1,\"status\":1,\"changed\":false}],\"functionVariables\":[],\"status\":1,\"actionId\":35,\"parentId\":0,\"endpointId\":5,\"templateId\":0,\"tversion\":1,\"tstyleId\":127,\"tstatus\":1,\"verifiedBy\":0,\"onFailure\":1,\"invertResult\":false,\"actionDisplay\":\"Send the keys {var:Key} to your application\",\"changed\":false}", stepStack.peek(), (t4) -> {  return null; }, false, 0, 5000, 0, 1 ) );
      
      vM.clear();

      ingressSignature.clear();
      

      vM.addVariable( createVariable( "Control", 4, true, "false", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "Shift", 4, true, "false", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "Alt", 4, true, "false", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "Key", 1, true, "TAB", dS, contextMap, bW ) );
      

      if ( !ingressSignature.isEmpty() ) {
	vM.addVariable( new VariableWrapper( "__dS", dS, "" ) );
        vM.addVariable( new VariableWrapper( "ingressSignature", ingressSignature, "" ) );
      }
      eventList.add( aM.executeAction( "Keys_v1", "", 1, vM.generateVariables(), vM.generateVariableDefinitions(), "{\"templateImplId\":329,\"checkpointId\":1,\"alchemyId\":1632,\"alchemySeed\":22681,\"pauseBefore\":0,\"waitFor\":5000,\"pauseAfter\":0,\"variableList\":[{\"value\":\"false\",\"inputId\":0,\"templateId\":0,\"inputName\":\"Control\",\"inputDescription\":\"Is the Control key pressed as part of this key sequence\",\"inputData\":\"\",\"inputTypeId\":4,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"false\",\"inputId\":0,\"templateId\":0,\"inputName\":\"Shift\",\"inputDescription\":\"Is the Shift key pressed as part of this key sequence\",\"inputData\":\"\",\"inputTypeId\":4,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"false\",\"inputId\":0,\"templateId\":0,\"inputName\":\"Alt\",\"inputDescription\":\"Was the Alt key pressed as part of this key sequence\",\"inputData\":\"\",\"inputTypeId\":4,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"TAB\",\"inputId\":0,\"templateId\":0,\"inputName\":\"Key\",\"inputDescription\":\"An attempt will be made first to find a constart mapping to this string.  If not found, it will send the keys supplied as individual characters\",\"inputData\":\"\",\"inputTypeId\":1,\"inputRequired\":1,\"status\":1,\"changed\":false}],\"functionVariables\":[],\"status\":1,\"actionId\":35,\"parentId\":0,\"endpointId\":5,\"templateId\":0,\"tversion\":1,\"tstyleId\":127,\"tstatus\":1,\"verifiedBy\":0,\"onFailure\":1,\"invertResult\":false,\"actionDisplay\":\"Send the keys {var:Key} to your application\",\"changed\":false}", stepStack.peek(), (t4) -> {  return null; }, false, 0, 5000, 0, 1 ) );
      
      vM.clear();

      ingressSignature.clear();
      

      vM.addVariable( createVariable( "value", 1, true, "langoju", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "clearFirst", 4, true, "true", dS, contextMap, bW ) );
      vM.addVariable( createVariable( "targetLocator", 5, true, "22681.1634", dS, contextMap, bW ) );
      

      if ( !ingressSignature.isEmpty() ) {
	vM.addVariable( new VariableWrapper( "__dS", dS, "" ) );
        vM.addVariable( new VariableWrapper( "ingressSignature", ingressSignature, "" ) );
      }
      eventList.add( aM.executeAction( "Type_v1", "", 1, vM.generateVariables(), vM.generateVariableDefinitions(), "{\"templateImplId\":328,\"checkpointId\":1,\"alchemyId\":1675,\"alchemySeed\":22681,\"pauseBefore\":0,\"waitFor\":5000,\"pauseAfter\":0,\"variableList\":[{\"value\":\"langoju\",\"inputId\":31,\"templateId\":0,\"inputName\":\"value\",\"inputDescription\":\"The text to type\",\"inputData\":\"null\",\"inputTypeId\":1,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"true\",\"inputId\":32,\"templateId\":0,\"inputName\":\"clearFirst\",\"inputDescription\":\"A flag indicating if the value should first be cleared\",\"inputData\":\"null\",\"inputTypeId\":4,\"inputRequired\":1,\"status\":1,\"changed\":false},{\"value\":\"22681.1634\",\"inputId\":33,\"templateId\":0,\"inputName\":\"targetLocator\",\"inputDescription\":\"The element that will receive the text\",\"inputTypeId\":5,\"inputRequired\":1,\"status\":1,\"changed\":false}],\"functionVariables\":[],\"status\":1,\"actionId\":17,\"parentId\":0,\"endpointId\":5,\"templateId\":0,\"tversion\":1,\"tstyleId\":127,\"tstatus\":1,\"verifiedBy\":0,\"onFailure\":1,\"invertResult\":false,\"actionDisplay\":\"Type {var:value} into {var:targetLocator}\",\"changed\":false}", stepStack.peek(), (t4) -> {  return null; }, false, 0, 5000, 0, 1 ) );
      

      
      
      
      
    } catch( BreakException e ) {
      throw e;
    } catch (EOTException e) {
      if (e.getStepPayload() == null) {
        e.setStepPayload(new StepPayload());
      }
      e.getStepPayload().setMessage(e.getMessage());
      if (!e.isTestPassed()) {
        try {
          e.getStepPayload().setScreenShot(screenShot(bW));
          e.getStepPayload().setSource(bW.getPage().content());
          
        } catch (Exception _e) {
          e.getStepPayload().setMessage("Could not acquire details from connected endpoint");
        }
      }
      throw e;
    } catch (StepException e) {
      log.error( e.getMessage(), e );
      if (e.getStepPayload() == null) {
        e.setStepPayload( new StepPayload() );
      }
      try {
        e.getStepPayload().setScreenShot(screenShot(bW));
        e.getStepPayload().setSource(bW.getPage().content());
        e.getStepPayload().setMessage(e.getMessage());
      } catch (Exception _e) {
        log.error( _e.getMessage(), _e );
        e.getStepPayload().setMessage("Could not acquire details from connected endpoint");
      }
      notifyListeners(new StepEvent(e.getStepPayload(), testName, 3));
      throw e;
    } finally {
      if ( eventList.peek() != null ) {
        notifyListeners(new StepEvent(eventList.peek().getPayload(), testName, 2));
      } else {
        notifyListeners(new StepEvent(new StepPayload(), testName, 2));
      }
      callStack.pop();
    }
  }

  
  private byte[] screenShot(BrowserWrapper bW ) {
    return bW.getPage().screenshot( new Page.ScreenshotOptions().setType(ScreenshotType.PNG).setFullPage(true) );
  }
 }