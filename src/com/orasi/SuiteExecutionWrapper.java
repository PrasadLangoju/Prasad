/**
 * @version 0
 */
  
package com.orasi;
  
import java.util.*;
import java.util.concurrent.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.orasi.event.spi.*;
import static com.orasi.shared_library.*;
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

  
  
public class SuiteExecutionWrapper {

  static {
    try ( InputStream iS = SuiteExecutionWrapper.class.getClassLoader().getResourceAsStream( "logging.properties") ) {
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
  private int threadCount = 10;
  private static final Logger log = LoggerFactory.getLogger(SuiteExecutionWrapper.class);
  private static final SuiteExecutionWrapper singleton = new SuiteExecutionWrapper();
  private int executionId;
  private int checkFailureLevel = 2;

  private String name;
  private String description;
  private int id;
  private String userName;
  private List<String> testList;
  private List<String> targetList;
  private List<Router> routerList = new ArrayList<>(5);

  private static final Map<String, Map<String, String>> environmentMap = new HashMap<>(10);
  
    private SuiteExecutionWrapper() {
  
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
        if ( SuiteExecutionWrapper.instance().getOptions().getOption(name).hasArg() ) {
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
        if ( SuiteExecutionWrapper.instance().getOptions().getOption(keyName).hasArg() ) {
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

      SuiteExecutionWrapper.instance().getOptions().addOption(new Option("h", "help", false, "Print this message"));
      Option o = new Option("t", "tags", true, "A space separated list of test tags.  Each test that contains any of the supplied tags will be executed.");
      o.setArgs(Option.UNLIMITED_VALUES);
      SuiteExecutionWrapper.instance().getOptions().addOption(o);

      o = new Option("it", "includetests", true, "A space separated list of test identifiers that will be executed");
      o.setArgs(Option.UNLIMITED_VALUES);
      SuiteExecutionWrapper.instance().getOptions().addOption(o);

      SuiteExecutionWrapper.instance().getOptions().addOption(new Option("e", "environment", true, "The environment variable set to use during execution"));
      SuiteExecutionWrapper.instance().getOptions().addOption(new Option("p", "threadcount", true, "The maximum amount of threads to run in parellel"));
      SuiteExecutionWrapper.instance().getOptions().addOption(new Option("n", "noreturn", false, "Allow the process to complete without forcing it to exit with a return code"));
 
      o = new Option("ir", "includerouters", true, "A space separated list of router identifiers.  Only targets belonging to these routers will run");
      o.setArgs(Option.UNLIMITED_VALUES);
      SuiteExecutionWrapper.instance().getOptions().addOption(o);

      o = new Option("iw", "includeintegrations", true, "A space separated list of integration identifiers to use");
      o.setArgs(Option.UNLIMITED_VALUES);
      SuiteExecutionWrapper.instance().getOptions().addOption(o);

      o = new Option("ie", "includetargets", true, "A space separated list of execution target identifiers.  Only the names targets will run");
      o.setArgs(Option.UNLIMITED_VALUES);
      SuiteExecutionWrapper.instance().getOptions().addOption(o);
      SuiteExecutionWrapper.instance().getOptions().addOption(new Option("a", "name", true, "Override the default name of this test suite"));
      SuiteExecutionWrapper.instance().getOptions().addOption(new Option("u", "user", true, "Override the name of the executing user"));
      SuiteExecutionWrapper.instance().getOptions().addOption(new Option("d", "description", true, "Override the description of this test suite"));
      SuiteExecutionWrapper.instance().getOptions().addOption(new Option("q", "queryids", false, "List the ID's of all elements that make up this suite"));
      SuiteExecutionWrapper.instance().getOptions().addOption(new Option("rd", "rundevelopment", false, "Indicates that tests in the development state should run"));
      SuiteExecutionWrapper.instance().getOptions().addOption(new Option("rq", "runquarantine", false, "Indicates that tests in the quarantine state should run"));
      SuiteExecutionWrapper.instance().getOptions().addOption(new Option("f", "failurelevel", true, "What error level fails a test suite.  1: Infrastructure, 2: Automation Failure (default), 3: Application Failure, 4: Unknown Error"));

      SuiteExecutionWrapper.instance().addOptions( new com.orasi.integration.html.HTMLSerializer().getOptions() );
      SuiteExecutionWrapper.instance().addOptions( new com.orasi.integration.console.ExecutionConsole().getOptions() );
      SuiteExecutionWrapper.instance().addOptions( new com.orasi.integration.embedded.selenium.SeleniumEmbedded().getOptions() );
      

      CommandLineParser cP = new DefaultParser();
      try {
        cli = cP.parse(SuiteExecutionWrapper.instance().getOptions(), args);
      } catch( ParseException pE ) {
        System.err.println("Failed to parse command line: " + pE.getMessage());
      }

      // Default Environment Properties 
      DataManager.instance().addDefaultEnvironmentProperty( "url", DataManager.instance().replaceValues( "https://www.google.com" ) + "" );



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
        formatter.printHelp("java -jar Git_Repo", SuiteExecutionWrapper.instance().getOptions() );
        System.exit( 0 );
      }

      if ( cli.hasOption( "q" ) ) {
        System.out.println( "Suite" );
        System.out.println( "Git Repo (Suite): 17503.1860" ); 
        System.out.println( "\r\nTests" );
        System.out.println( "FB (Test): 17503.1868" );
        
        System.out.println( "\r\nFunctions" );
        
        
        System.out.println( "\r\nExecution Targets" );
	System.out.println( "Git Repo local router (Router): 17503.1863" );
	System.out.println( "Chrome (Execution Target): 17503.1864" );
	
        System.out.println( "\r\nSites and Pages" );
        System.out.println( "www.google.com (Site): 17503.1870" );
        System.out.println( "Google (Page): 17503.1874" );
        System.out.println( "default (Page): 17503.1893" );
        System.out.println( "facebook - Google Search (Page): 17503.1895" );
        System.out.println( "www.facebook.com (Site): 17503.1912" );
        System.out.println( "Facebook  log in or sign up (Page): 17503.1914" );
        
        System.out.println( "\r\nData Sources" );
        
        System.out.println( "HTML Generator (Integration): 17503.1865" );
        
        System.out.println( "Alchemy Execution Console (Integration): 17503.1866" );
        System.out.println( "Integrated Selenium Server (Integration): 17503.1861" );
        
        System.out.println( "\r\n\r\nImported Suites" ); 
	
        System.exit( 0 );
      }

      DataSource<String,DataTable> _dS = null;
      DataTable<String,DataField,DataRow> _dT = null;
      DataField<String> _dF = null; 
      

      

      if ( cli.hasOption( "a" ) ) {
        SuiteExecutionWrapper.instance().setName(cli.getOptionValue( "a" ));
      } else {
        SuiteExecutionWrapper.instance().setName("Git Repo");
      }
      if ( cli.hasOption( "u" ) ) {
        SuiteExecutionWrapper.instance().setUserName(cli.getOptionValue( "u" ));
      } else {
        SuiteExecutionWrapper.instance().setUserName("");
      }
      if ( cli.hasOption( "d" ) ) {
        SuiteExecutionWrapper.instance().setDescription(cli.getOptionValue( "d" ));
      } else {
        SuiteExecutionWrapper.instance().setDescription("No description was added for Git Repo");
      }

      //
      // Configure the test level information
      //
      List<String> testList = new ArrayList(5);
      if ( hasValue( "it", "17503.1868" ) ) {
        if ( 0 == 0 || ( 0 == 1 && cli.hasOption( "rd" ) ) || ( 0 == 2 && cli.hasOption( "rq" ) ) ) {
          TestManager.instance().registerTest( new org.org_1.git_repo.fb() );
          testList.add("FB");
        }
      }
      
      

      
      



      
      //
      // Register the execution routers here
      //
      Router r;
      /*
      Routers from Git Repo local router Execution Package
      Add a description of Git Repo local router Execution Package
      */
      if ( hasValue( "ir", "17503.1863" ) ) { 
        r = new Router( 1, "Git Repo local router", "17503.1863" ,"{\"name\":\"Git Repo local router\",\"description\":\"Add a description of Git Repo local router\",\"alchemyId\":1863,\"alchemySeed\":17503,\"organizationId\":0,\"changed\":false,\"routerId\":1,\"status\":0,\"userId\":0,\"propertyList\":[{\"name\":\"URL\",\"value\":\"http://localhost:4444/wd/hub\"}]}" );
      
        r.addProperty( "URL", DataManager.instance().replaceValues( "http://localhost:4444/wd/hub" ) + "" );
        SuiteExecutionWrapper.instance().routerList.add(r);
      }
      
 
      //
      // Configure the endpoint details here
      //
      List<ExecutionTarget> targetList = new ArrayList<>(10);
      ExecutionTarget eT;
      /*
      Targets from Git Repo local router Execution Package
      Add a description of Git Repo local router Execution Package
      */
      if ( hasValue( "ie", "17503.1864" ) ) {
        eT = new ExecutionTarget( "Chrome", "17503.1864", "17503.1863", 2 ,"{\"name\":\"Chrome\",\"description\":\"Add a description of Chrome\",\"alchemyId\":1864,\"alchemySeed\":17503,\"organizationId\":0,\"changed\":false,\"maximumAvailable\":2,\"executionRouterID\":{\"alchemyId\":1863,\"alchemySeed\":17503},\"propertyList\":[{\"name\":\"browserName\",\"value\":\"chrome\"},{\"name\":\"platformName\",\"value\":\"ANY\"}],\"status\":0,\"userId\":0,\"referenceSuiteID\":0}" );
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
        SuiteExecutionWrapper.instance().routerList.forEach((_t) -> {
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
      
      if ( hasValue( "iw", "17503.1865" ) ) { 
        cI = new com.orasi.integration.html.HTMLSerializer();
        log.warn( "Enabling Integration: " + cI.getTitle() );
        cI.setProperty( "outputFolder", SuiteExecutionWrapper.instance().getOption( cI.getKey(), "outputFolder", DataManager.instance().replaceValues( "c:/Reports" ) + "" ) );
        cI.setProperty( "launchUi", SuiteExecutionWrapper.instance().getOption( cI.getKey(), "launchUi", DataManager.instance().replaceValues( "true" ) + "" ) );
        cI.setProperty( "suiteTemplate", SuiteExecutionWrapper.instance().getOption( cI.getKey(), "suiteTemplate", DataManager.instance().replaceValues( "" ) + "" ) );
        cI.setProperty( "testTemplate", SuiteExecutionWrapper.instance().getOption( cI.getKey(), "testTemplate", DataManager.instance().replaceValues( "" ) + "" ) );
        cI.setProperty( "sourceTemplate", SuiteExecutionWrapper.instance().getOption( cI.getKey(), "sourceTemplate", DataManager.instance().replaceValues( "" ) + "" ) );
      
        cI.initialize();
        cI.getHandlers().forEach((t) -> {
          addEventHandler(t);
        });
      }
      
      
      
      if ( hasValue( "iw", "17503.1866" ) ) { 
        cI = new com.orasi.integration.console.ExecutionConsole();
        log.warn( "Enabling Integration: " + cI.getTitle() );
        cI.setProperty( "color", SuiteExecutionWrapper.instance().getOption( cI.getKey(), "color", DataManager.instance().replaceValues( "true" ) + "" ) );
      
        cI.initialize();
        cI.getHandlers().forEach((t) -> {
          addEventHandler(t);
        });
      }
      
      if ( hasValue( "iw", "17503.1861" ) ) { 
        cI = new com.orasi.integration.embedded.selenium.SeleniumEmbedded();
        log.warn( "Enabling Integration: " + cI.getTitle() );
        cI.setProperty( "host", SuiteExecutionWrapper.instance().getOption( cI.getKey(), "host", DataManager.instance().replaceValues( "localhost" ) + "" ) );
        cI.setProperty( "port", SuiteExecutionWrapper.instance().getOption( cI.getKey(), "port", DataManager.instance().replaceValues( "4444" ) + "" ) );
        cI.setProperty( "managed", SuiteExecutionWrapper.instance().getOption( cI.getKey(), "managed", DataManager.instance().replaceValues( "true" ) + "" ) );
      
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
      SuiteExecutionWrapper.instance().routerList.forEach((_t) -> {
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

      SuiteExecutionWrapper.instance().targetList = targetNames;
      SuiteExecutionWrapper.instance().testList = TestManager.instance().getTestNames();
      SuiteExecutionWrapper.instance().start();
      }  
    }
    
    public int getExecutionId() {
      return executionId;
    }
  
    public static SuiteExecutionWrapper instance() {
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
      for ( Router _t : SuiteExecutionWrapper.instance().routerList ) {
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
      suitePayload.setSuiteDetail(  "{\"id\":4345,\"name\":\"Git Repo\",\"description\":\"No description was added for Git Repo\",\"userId\":15,\"userConfidence\":0,\"organizationId\":1,\"organizationConfidence\":0,\"status\":1,\"endpointId\":1,\"endpointStyleId\":1,\"targetId\":4507,\"targetConfigurationId\":0,\"targetVersionId\":0,\"reviewFlag\":0,\"importTests\":0,\"importFunctions\":0,\"importSites\":0,\"importTargets\":0,\"importData\":0,\"shareCount\":0,\"conductorList\":[{\"reviewFlag\":0,\"id\":3531,\"name\":\"Git Repo local router Execution Package\",\"description\":\"Add a description of Git Repo local router Execution Package\",\"alchemyId\":1862,\"alchemySeed\":17503,\"organizationId\":1,\"userId\":15,\"version\":0,\"targetDetail\":\"[{\\\"name\\\": \\\"Chrome\\\", \\\"status\\\": 0, \\\"userId\\\": 0, \\\"changed\\\": false, \\\"alchemyId\\\": 1864, \\\"alchemySeed\\\": 17503, \\\"description\\\": \\\"Add a description of Chrome\\\", \\\"propertyList\\\": [{\\\"name\\\": \\\"browserName\\\", \\\"value\\\": \\\"chrome\\\"}, {\\\"name\\\": \\\"platformName\\\", \\\"value\\\": \\\"ANY\\\"}], \\\"organizationId\\\": 0, \\\"maximumAvailable\\\": 2, \\\"referenceSuiteID\\\": 0, \\\"executionRouterID\\\": {\\\"alchemyId\\\": 1863, \\\"alchemySeed\\\": 17503}}]\",\"routerDetail\":\"[{\\\"name\\\": \\\"Git Repo local router\\\", \\\"status\\\": 0, \\\"userId\\\": 0, \\\"changed\\\": false, \\\"routerId\\\": 1, \\\"alchemyId\\\": 1863, \\\"alchemySeed\\\": 17503, \\\"description\\\": \\\"Add a description of Git Repo local router\\\", \\\"propertyList\\\": [{\\\"name\\\": \\\"URL\\\", \\\"value\\\": \\\"http://localhost:4444/wd/hub\\\"}], \\\"organizationId\\\": 0}]\",\"status\":1,\"lockUserId\":0,\"changed\":false,\"createDate\":\"Sep 16, 2024, 12:10:11 PM\",\"modifyDate\":\"Sep 16, 2024, 12:10:11 PM\",\"targetList\":[{\"name\":\"Chrome\",\"description\":\"Add a description of Chrome\",\"alchemyId\":1864,\"alchemySeed\":17503,\"organizationId\":0,\"changed\":false,\"maximumAvailable\":2,\"executionRouterID\":{\"alchemyId\":1863,\"alchemySeed\":17503},\"propertyList\":[{\"name\":\"browserName\",\"value\":\"chrome\"},{\"name\":\"platformName\",\"value\":\"ANY\"}],\"status\":0,\"userId\":0,\"referenceSuiteID\":0}],\"routerList\":[{\"name\":\"Git Repo local router\",\"description\":\"Add a description of Git Repo local router\",\"alchemyId\":1863,\"alchemySeed\":17503,\"organizationId\":0,\"changed\":false,\"routerId\":1,\"status\":0,\"userId\":0,\"propertyList\":[{\"name\":\"URL\",\"value\":\"http://localhost:4444/wd/hub\"}]}],\"acls\":[]}],\"version\":0,\"lockUserId\":0,\"testDisplay\":0,\"alchemyId\":1860,\"alchemySeed\":17503,\"referenceSuiteID\":0,\"changed\":false}" );
      suitePayload.setTestList(testList);
      suitePayload.setTargetList(targetList);
      suitePayload.setTotalTests(totalTasks);
      suitePayload.setOtherValue( "threadCount", threadCount );
      suitePayload.setOtherValue( "requestedThreadCount", totalTasks );
      suitePayload.setOtherValue( "cliMap", cliMap );
      suitePayload.setOtherValue( "routers", new Gson().toJson( SuiteExecutionWrapper.instance().routerList ) );
      notifyListeners( new SuiteEvent( suitePayload, name, 1 ) );

      
      log.warn(TestManager.instance().getSize() + " Tests executing across " + totalTargets + " devices ");
      log.warn("Submitting " + totalTasks + " tasks for execution");
      addEventHandler(new TestFailureHandler());

      TestManager.instance().getTests().forEach((t) -> {
        SuiteExecutionWrapper.instance().routerList.forEach((r) -> {
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
  