/**
 * @version 0
 */
  
package com.orasi;
  
import java.util.*;
import java.util.concurrent.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.orasi.event.spi.*;
import static com.orasi.ActionLibrary.*;
import com.orasi.integration.*;
import com.orasi.event.Event;
import com.orasi.event.action.EventAction;
import com.orasi.event.handler.AbstractEventHandler;
import com.orasi.event.hook.EventHook;
import com.orasi.model.*;
import org.apache.commons.cli.*;
import com.orasi.secrets.*;
import com.orasi.datasource.*;
import java.io.InputStream;
import java.util.logging.LogManager;
import com.google.gson.Gson;

  
  
public class TestSuite {

  static {
    try ( InputStream iS = TestSuite.class.getClassLoader().getResourceAsStream( "logging.properties") ) {
      LogManager.getLogManager().readConfiguration(iS);
    } catch( Exception e ) {
      e.printStackTrace();
    }
  }

  private static final Random numberGenerator = new Random();
  public static final String generateCharacters(int characterCount) {
    StringBuilder sB = new StringBuilder();
    for (int i = 0; i < characterCount; i++) {
      int rV = numberGenerator.nextInt(26);

      rV += numberGenerator.nextBoolean() ? 65 : 97;

      sB.append((char) rV);

    }

    return sB.toString();
  }

  private static int failureCount = 0;
  private static int failureLevel = 0;

  private static class TestFailureHandler extends AbstractEventHandler<TestPayload> {

      public TestFailureHandler() {
        super( EventAction.ALL, EventHook.FAILURE.getId(), TestEvent.EVENT_TYPE );
      }
    
      @Override
      protected void _handleEvent(Event<TestPayload> e) {
        if ( e.getPayload().getFailureType() > failureLevel ) {
          failureLevel = e.getPayload().getFailureType();
        }
        failureCount++;
      }

    }
  
    private final Options cliOptions = new Options();
  private static CommandLine cli;
  private int threadCount = 30;
  private static final Logger log = LoggerFactory.getLogger(TestSuite.class);
  private static final TestSuite singleton = new TestSuite();
  private int executionId;
  private int checkFailureLevel = 2;

  private String name;
  private String description;
  private int id;
  private String userName;
  private List<String> testList;
  private List<String> targetList;
  private List<ExecutionRouter> routerList = new ArrayList<>(5);

  private static final Map<String, Map<String, String>> environmentMap = new HashMap<>(10);
  
    private TestSuite() {
  
    }

    public CommandLine getCommandLine() {
      return cli;
    }

    public Options getOptions() {
      return cliOptions;
    }

    public void addOptions(Option[] options) {
      for (Option option : options) {
        cliOptions.addOption(option);
      }
    }

    public String getOption( String name, String defaultValue ) {
      if ( cli.hasOption(name) ) {
        if ( TestSuite.instance().getOptions().getOption(name).hasArg() ) {
          return cli.getOptionValue(name);
        } else {
          return "true";
        }
      } else {
        return defaultValue;
      }
    }
  
    public String getOption( String key, String name, String defaultValue ) {
      String keyName = key + "_" + name;
      if ( cli.hasOption(keyName) ) {
        if ( TestSuite.instance().getOptions().getOption(keyName).hasArg() ) {
          return cli.getOptionValue(keyName);
        } else {
          return "true";
        }
      } else {
        return defaultValue;
      }
    }

  private static boolean hasValue(String option, String value) {
    String[] oV = cli.getOptionValues(option);
    if (oV != null) {
      for (String v : oV) {
        if (v.equals(value)) {
          return true;
        }
      }
      return false;
    } else {
      return true;
    }
    
  }

   
    public static void main(String[] args) {

            System.out.println( "                                                                                \n" +
"                                                                                \n" +
"                                                                                \n" +
"                                                                        &##     \n" +
"                                                               &######&  %%     \n" +
"                              &##################%              &&#& &%#& ####% \n" +
"                             &#####################&         %#% %#######& %#   \n" +
"                            ########################&      #####%##&  %####%    \n" +
"                          &###########################    %##########%%###%     \n" +
"                         ##############################&%##%  #######%          \n" +
"                       &#####################################%#####%%##%        \n" +
"                      #################  &#####################%%#####          \n" +
"                    &################      ###################%  ####           \n" +
"                   ################%         ######################             \n" +
"                  ################%           ####################              \n" +
"                %################&             &################&               \n" +
"               ###################            %###################              \n" +
"             &#####################%         ######################             \n" +
"           &#########################      &########################%           \n" +
"           ###########################%   ############################&         \n" +
"         ############################### ##############################         \n" +
"        ################&##############################&#################       \n" +
"      #################   &###########################&  &################      \n" +
"    &################      &########################%      ################%    \n" +
"   &################         %#####################&        &################   \n" +
"  ################&           %###################            ################% \n" +
" ################&              %%%%%%%%%%%%%%%%&              &################");
      
      System.out.println( "\n\nAlchemy by Orasi");
      System.out.println( "Copyright Orasi, Inc. | All Rights Reserved.\n\n");

      DataSourceProviderFactory.instance().setDataSourceProvider( DataManager.instance() );

      TestSuite.instance().getOptions().addOption(new Option("h", "help", false, "Print this message"));
      Option o = new Option("t", "tags", true, "A space separated list of test tags.  Each test that contains any of the supplied tags will be executed.");
      o.setArgs(Option.UNLIMITED_VALUES);
      TestSuite.instance().getOptions().addOption(o);

      o = new Option("it", "includetests", true, "A space separated list of test identifiers that will be executed");
      o.setArgs(Option.UNLIMITED_VALUES);
      TestSuite.instance().getOptions().addOption(o);

      TestSuite.instance().getOptions().addOption(new Option("e", "environment", true, "The environment variable set to use during execution"));
      TestSuite.instance().getOptions().addOption(new Option("p", "threadcount", true, "The maximum amount of threads to run in parellel"));
      TestSuite.instance().getOptions().addOption(new Option("n", "noreturn", false, "Allow the process to complete without forcing it to exit with a return code"));
 
      o = new Option("ir", "includerouters", true, "A space separated list of router identifiers.  Only targets belonging to these routers will run");
      o.setArgs(Option.UNLIMITED_VALUES);
      TestSuite.instance().getOptions().addOption(o);

      o = new Option("iw", "includeintegrations", true, "A space separated list of integration identifiers to use");
      o.setArgs(Option.UNLIMITED_VALUES);
      TestSuite.instance().getOptions().addOption(o);

      o = new Option("ie", "includetargets", true, "A space separated list of execution target identifiers.  Only the names targets will run");
      o.setArgs(Option.UNLIMITED_VALUES);
      TestSuite.instance().getOptions().addOption(o);
      TestSuite.instance().getOptions().addOption(new Option("a", "name", true, "Override the default name of this test suite"));
      TestSuite.instance().getOptions().addOption(new Option("u", "user", true, "Override the name of the executing user"));
      TestSuite.instance().getOptions().addOption(new Option("d", "description", true, "Override the description of this test suite"));
      TestSuite.instance().getOptions().addOption(new Option("q", "queryids", false, "List the ID's of all elements that make up this suite"));
      TestSuite.instance().getOptions().addOption(new Option("rd", "rundevelopment", false, "Indicates that tests in the development state should run"));
      TestSuite.instance().getOptions().addOption(new Option("rq", "runquarantine", false, "Indicates that tests in the quarantine state should run"));
      TestSuite.instance().getOptions().addOption(new Option("f", "failurelevel", true, "What error level fails a test suite.  1: Infrastructure, 2: Automation Failure (default), 3: Application Failure, 4: Unknown Error"));

      TestSuite.instance().addOptions( new com.orasi.integration.html.HTMLSerializer().getOptions() );
      TestSuite.instance().addOptions( new com.orasi.integration.console.ExecutionConsole().getOptions() );
      

      CommandLineParser cP = new DefaultParser();
      try {
        cli = cP.parse(TestSuite.instance().getOptions(), args);
      } catch( ParseException pE ) {
        System.err.println("Failed to parse command line: " + pE.getMessage());
      }

      // Default Environment Properties 
      DataManager.instance().addDefaultEnvironmentProperty( "url", DataManager.instance().replaceValues( "" ) + "" );



      Map<String,String> envMap;
      //* A production configuration containing a Production URL */
      envMap = new HashMap<>( 10 );
      
      environmentMap.put( "Production", envMap );
//* A staging configuration containing a Staging URL */
      envMap = new HashMap<>( 10 );
      
      environmentMap.put( "Staging", envMap );

      

      if ( cli.hasOption( "e" ) ) {
        envMap = environmentMap.get( cli.getOptionValue( "e" ) );
        if ( envMap == null ) {
          System.err.println( "Specified Environment " + cli.getOptionValue( "e" ) + " does not exist" );
        } else {
          DataManager.instance().addEnvironmentProperties( envMap );
        }
      }

      



      if ( cli.hasOption( "h" ) ) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java -jar Git_Testing2", TestSuite.instance().getOptions() );
        System.exit( 0 );
      }

      if ( cli.hasOption( "q" ) ) {
        System.out.println( "Suite" );
        System.out.println( "Git Testing2 (Suite): 22681.1698" ); 
        System.out.println( "\r\nTests" );
        System.out.println( "T1 (Test): 22681.1702" );
        
        System.out.println( "\r\nFunctions" );
        
        
        System.out.println( "\r\nExecution Targets" );
	System.out.println( "Direct (Router): 22681.1924" );
	System.out.println( "chrome (Execution Target): 22681.1925" );
	
        System.out.println( "\r\nSites and Pages" );
        System.out.println( "www.google.com (Site): 22681.1704" );
        System.out.println( "Google (Page): 22681.1707" );
        System.out.println( "default (Page): 22681.1795" );
        System.out.println( "facebook - Google Search (Page): 22681.1797" );
        System.out.println( "www.facebook.com (Site): 22681.1824" );
        System.out.println( "Facebook  log in or sign up (Page): 22681.1826" );
        
        System.out.println( "\r\nData Sources" );
        
        System.out.println( "\r\nPlugins" );
        System.out.println( "HTML Generator (Plugin): 22681.1699" );
        System.out.println( "Alchemy Execution Console (Plugin): 22681.1700" );
        
        
        System.out.println( "\r\n\r\nImported Suites" ); 
	
        System.exit( 0 );
      }

      DataSource<String,DataTable> _dS = null;
      DataTable<String,DataField,DataRow> _dT = null;
      DataField<String> _dF = null; 
      

      

      if ( cli.hasOption( "a" ) ) {
        TestSuite.instance().setName(cli.getOptionValue( "a" ));
      } else {
        TestSuite.instance().setName("Git Testing2");
      }
      if ( cli.hasOption( "u" ) ) {
        TestSuite.instance().setUserName(cli.getOptionValue( "u" ));
      } else {
        TestSuite.instance().setUserName("");
      }
      if ( cli.hasOption( "d" ) ) {
        TestSuite.instance().setDescription(cli.getOptionValue( "d" ));
      } else {
        TestSuite.instance().setDescription("No description was added for Git Testing2");
      }

      //
      // Configure the test level information
      //
      List<String> testList = new ArrayList(5);
      if ( hasValue( "it", "22681.1702" ) ) {
        if ( 0 == 0 || ( 0 == 1 && cli.hasOption( "rd" ) ) || ( 0 == 2 && cli.hasOption( "rq" ) ) ) {
          TestManager.instance().registerTest( new org.org_1.git_testing2.t1() );
          testList.add("T1");
        }
      }
      
      

      
      



      
      //
      // Register the execution routers here
      //
      ExecutionRouter r;
      /*
      Routers from Direct
      Add a description of Direct
      */
      if ( hasValue( "ir", "22681.1924" ) ) { 
        r = new ExecutionRouter( 9, "Direct", "22681.1924" ,"{\"name\":\"Direct\",\"description\":\"Direct\",\"alchemyId\":1924,\"alchemySeed\":22681,\"organizationId\":0,\"changed\":false,\"routerId\":9,\"status\":0,\"userId\":0,\"propertyList\":[]}" );
      
        TestSuite.instance().routerList.add(r);
      }
      
 
      //
      // Configure the endpoint details here
      //
      List<ExecutionTarget> targetList = new ArrayList<>(10);
      ExecutionTarget eT;
      /*
      Targets from Direct
      Add a description of Direct
      */
      if ( hasValue( "ie", "22681.1925" ) ) {
        eT = new ExecutionTarget( "chrome", "22681.1925", "22681.1924", 1 ,"{\"name\":\"chrome\",\"description\":\"chrome\",\"alchemyId\":1925,\"alchemySeed\":22681,\"organizationId\":0,\"changed\":false,\"maximumAvailable\":1,\"executionRouterID\":{\"alchemyId\":1924,\"alchemySeed\":22681},\"propertyList\":[{\"name\":\"browserName\",\"value\":\"chrome\"},{\"name\":\"platformName\",\"value\":\"ANY\"}],\"status\":0,\"userId\":0,\"referenceSuiteID\":0}" );
        if ( eT.getMaximumAvailable() > 0 ) {
          eT.addProperty( "browserName", DataManager.instance().replaceValues( "chrome" ) + "" );
          eT.addProperty( "platformName", DataManager.instance().replaceValues( "ANY" ) + "" );
          targetList.add(eT);
        }
      }
      

      //
      // This will add all targets to the correct router
      //
      targetList.forEach((t) -> {
        TestSuite.instance().routerList.forEach((_t) -> {
          _t.addTarget(t);
        });
      });


      if ( cli.hasOption( "t" ) ) {
        TestManager.instance().setTags( cli.getOptionValues( "t" ));
      }

      if (testList.isEmpty() || targetList.isEmpty()) {
        if (testList.isEmpty()) {
          throw new IllegalArgumentException("No tests were added - nothing to do");
        }

        if (targetList.isEmpty()) {
          throw new IllegalArgumentException("No Execution Targets were defined - nowhere to run your tests");
        }
      } else {


      //
      // Configuration Integrations
      //
      Integration cI = null;
      if ( hasValue( "iw", "22681.1699" ) ) { 
        cI = new com.orasi.integration.html.HTMLSerializer();
        log.warn( "Enabling Integration: " + cI.getName() );
        cI.setProperty( "outputFolder", TestSuite.instance().getOption( cI.getKey(), "outputFolder", DataManager.instance().replaceValues( "c:/Reports" ) + "" ) );
        cI.setProperty( "launchUi", TestSuite.instance().getOption( cI.getKey(), "launchUi", DataManager.instance().replaceValues( "true" ) + "" ) );
        cI.setProperty( "suiteTemplate", TestSuite.instance().getOption( cI.getKey(), "suiteTemplate", DataManager.instance().replaceValues( "" ) + "" ) );
        cI.setProperty( "testTemplate", TestSuite.instance().getOption( cI.getKey(), "testTemplate", DataManager.instance().replaceValues( "" ) + "" ) );
        cI.setProperty( "sourceTemplate", TestSuite.instance().getOption( cI.getKey(), "sourceTemplate", DataManager.instance().replaceValues( "" ) + "" ) );
      
        cI.initialize();
        cI.getHandlers().forEach((t) -> {
          addEventHandler(t);
        });
      }if ( hasValue( "iw", "22681.1700" ) ) { 
        cI = new com.orasi.integration.console.ExecutionConsole();
        log.warn( "Enabling Integration: " + cI.getName() );
        cI.setProperty( "color", TestSuite.instance().getOption( cI.getKey(), "color", DataManager.instance().replaceValues( "true" ) + "" ) );
      
        cI.initialize();
        cI.getHandlers().forEach((t) -> {
          addEventHandler(t);
        });
      }

        //
      // Get all active targets
      //
      List<String> targetNames = new ArrayList<>(10);
      List<String> localTargetNames = new ArrayList<>(10);
      TestSuite.instance().routerList.forEach((_t) -> {
        _t.getTargetList().forEach((t) -> {
          
          String useName = t.getName() + " from " + _t.getName();
          useName = useName.toLowerCase();
          
          if ( localTargetNames.contains( useName ) ) {
            t.setName( t.getName() + "_" + generateCharacters( 5 ) );
            targetNames.add(t.getName() + " from " + _t.getName());
          } else {
            localTargetNames.add( useName );
            targetNames.add(t.getName() + " from " + _t.getName());
          }
        });
      });

      TestSuite.instance().targetList = targetNames;
      TestSuite.instance().testList = TestManager.instance().getTestNames();
      TestSuite.instance().start();
      }  
    }
    
    public int getExecutionId() {
      return executionId;
    }
  
    public static TestSuite instance() {
      return singleton;
    }
  
    private ExecutorService eS;
  
    public void start() {
      
      if ( cli.hasOption( "p" ) ) {
        try { threadCount = Integer.parseInt( cli.getOptionValue( "p" ) ); } catch( Exception e ) {}
      }

      if ( cli.hasOption( "f" ) ) {
        try { checkFailureLevel = Integer.parseInt( cli.getOptionValue( "f" ) ); } catch( Exception e ) {}
      }

      executionId = 1;

      int totalTargets = 0;
      for ( ExecutionRouter _t : TestSuite.instance().routerList ) {
        for ( ExecutionTarget t : _t.getTargetList() ){
          totalTargets++;
        }
      }

      Map<String, String> cliMap = new HashMap<>(5);
      for (Option o : cli.getOptions()) {
        if (o.getLongOpt() != null && !o.getLongOpt().trim().isEmpty()) {
          cliMap.put(o.getLongOpt() + " (-" + o.getOpt() + ")", String.join(",", o.getValuesList()));
        } else {
          cliMap.put("-" + o.getOpt(), String.join(",", o.getValuesList()));
        }
      }

      if ( totalTargets == 0 ) {
        throw new IllegalArgumentException( "No targets were defined therefore there was nowhere to run your tests" );
      }

      if ( TestManager.instance().getSize() == 0 ) {
        throw new IllegalArgumentException( "There were no tests to run" );
      }
      

      int totalTasks = TestManager.instance().getSize() * totalTargets;

      ExecutionQueue eQ = new ExecutionQueue(totalTasks > threadCount ? threadCount : totalTasks, 3, 3);
      if ( threadCount > totalTasks ) {
        threadCount = totalTasks;
      }

      SuitePayload suitePayload = new SuitePayload();
      suitePayload.setExecutionIdentifier( executionId );
      suitePayload.setName(name);
      suitePayload.setDescription(description);
      suitePayload.setUserName(userName);
      suitePayload.setSuiteDetail(  "{\"id\":5213,\"name\":\"Git Testing2\",\"description\":\"No description was added for Git Testing2\",\"userId\":15,\"userConfidence\":0,\"organizationId\":1,\"organizationConfidence\":0,\"status\":1,\"endpointId\":5,\"endpointStyleId\":127,\"targetId\":5378,\"targetConfigurationId\":0,\"targetVersionId\":0,\"reviewFlag\":0,\"importTests\":0,\"importFunctions\":0,\"importSites\":0,\"importTargets\":0,\"importData\":0,\"shareCount\":0,\"conductorList\":[{\"reviewFlag\":0,\"id\":4398,\"name\":\"Direct\",\"description\":\"Add a description of Direct\",\"alchemyId\":1923,\"alchemySeed\":22681,\"organizationId\":1,\"userId\":15,\"version\":0,\"targetDetail\":\"[{\\\"name\\\": \\\"chrome\\\", \\\"status\\\": 0, \\\"userId\\\": 0, \\\"changed\\\": false, \\\"alchemyId\\\": 1925, \\\"alchemySeed\\\": 22681, \\\"description\\\": \\\"chrome\\\", \\\"propertyList\\\": [{\\\"name\\\": \\\"browserName\\\", \\\"value\\\": \\\"chrome\\\"}, {\\\"name\\\": \\\"platformName\\\", \\\"value\\\": \\\"ANY\\\"}], \\\"organizationId\\\": 0, \\\"maximumAvailable\\\": 1, \\\"referenceSuiteID\\\": 0, \\\"executionRouterID\\\": {\\\"alchemyId\\\": 1924, \\\"alchemySeed\\\": 22681}}]\",\"routerDetail\":\"[{\\\"name\\\": \\\"Direct\\\", \\\"status\\\": 0, \\\"userId\\\": 0, \\\"changed\\\": false, \\\"routerId\\\": 9, \\\"alchemyId\\\": 1924, \\\"alchemySeed\\\": 22681, \\\"description\\\": \\\"Direct\\\", \\\"propertyList\\\": [], \\\"organizationId\\\": 0}]\",\"status\":1,\"lockUserId\":0,\"changed\":false,\"createDate\":\"Nov 25, 2024, 8:51:01 AM\",\"modifyDate\":\"Nov 25, 2024, 8:51:01 AM\",\"targetList\":[{\"name\":\"chrome\",\"description\":\"chrome\",\"alchemyId\":1925,\"alchemySeed\":22681,\"organizationId\":0,\"changed\":false,\"maximumAvailable\":1,\"executionRouterID\":{\"alchemyId\":1924,\"alchemySeed\":22681},\"propertyList\":[{\"name\":\"browserName\",\"value\":\"chrome\"},{\"name\":\"platformName\",\"value\":\"ANY\"}],\"status\":0,\"userId\":0,\"referenceSuiteID\":0}],\"routerList\":[{\"name\":\"Direct\",\"description\":\"Direct\",\"alchemyId\":1924,\"alchemySeed\":22681,\"organizationId\":0,\"changed\":false,\"routerId\":9,\"status\":0,\"userId\":0,\"propertyList\":[]}],\"acls\":[]}],\"version\":0,\"lockUserId\":0,\"testDisplay\":0,\"alchemyId\":1698,\"alchemySeed\":22681,\"referenceSuiteID\":0,\"changed\":false}" );
      suitePayload.setTestList(testList);
      suitePayload.setTargetList(targetList);
      suitePayload.setTotalTests(totalTasks);
      suitePayload.setOtherValue( "threadCount", threadCount );
      suitePayload.setOtherValue( "requestedThreadCount", totalTasks );
      suitePayload.setOtherValue( "cliMap", cliMap );
      suitePayload.setOtherValue( "routers", new Gson().toJson( TestSuite.instance().routerList ) );
      notifyListeners( new SuiteEvent( suitePayload, name, 1 ) );

      
      log.warn(TestManager.instance().getSize() + " Tests executing across " + totalTargets + " devices ");
      log.warn("Submitting " + totalTasks + " tasks for execution");
      addEventHandler(new TestFailureHandler());

      TestManager.instance().getTests().forEach((t) -> {
        TestSuite.instance().routerList.forEach((r) -> {
          r.getTargetList().forEach((_t) -> {
            eQ.addExecution(new EndpointDevice(r, _t), t);
          });
        });
      });

      eQ.run();

    boolean suiteFailed = (failureCount > 0 && failureLevel >= checkFailureLevel) || failureCount >= totalTasks;

    if (suiteFailed) {
      log.atWarn().log("Notifying Integration of Suite Failure");
      try {
        notifyListeners(new SuiteEvent(suitePayload, name, EventHook.FAILURE.getId()));
      } catch (Exception e) {
        log.atError().log("Failed to notify suites of failure");
      }
    } else {

      log.atWarn().log("Notifying Integration of Suite Success");
      try {
        notifyListeners(new SuiteEvent(suitePayload, name, EventHook.SUCCESS.getId()));
      } catch (Exception e) {
        log.atError().log("Failed to notify suites of success");
      }
    }

    log.atWarn().log("Notifying Integration of Suite Complete");
    try {
      notifyListeners(new SuiteEvent(suitePayload, name, EventHook.AFTER.getId()));
    } catch (Exception e) {
      log.atError().log("Failed to notify suites of success");
    }

    if (!cli.hasOption("n")) {
      if (suiteFailed) {
        System.exit(-1);
      } else {
        System.exit(0);
      }
    }
  }
  
  
    /**
     * @return the name
     */
    public String getName() {
      return name;
    }
  
    /**
     * @param name the name to set
     */
    private void setName(String name) {
      this.name = name;
    }
  
    /**
     * @return the description
     */
    public String getDescription() {
      return description;
    }
  
    /**
     * @param description the description to set
     */
    private void setDescription(String description) {
      this.description = description;
    }
  
    /**
     * @return the id
     */
    public int getId() {
      return id;
    }
  
    /**
     * @param id the id to set
     */
    private void setId(int id) {
      this.id = id;
    }
  
    /**
     * @return the userName
     */
    public String getUserName() {
      return userName;
    }
  
    /**
     * @param userName the userName to set
     */
    private void setUserName(String userName) {
      this.userName = userName;
    }
  
  }
  