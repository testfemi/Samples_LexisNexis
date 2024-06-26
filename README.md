Automation Framework

Automation framework created LexisNexis
                   === Third Party Libraries/Frameworks  ===
This framework utilises a variety of different plugins and dependencies in order to enable functionality
and support a variety of features such as report generation, load browser and parallel running.
These can be found in the pom.xml file.

It also generate screen shots for your tests if you enable it and also generate error shots for your failed test cases as well.

                    === Item |Description |URL/Docs  ===

 === Cucumber BDD
Software tool that supports behavior-driven development, and the usage of feature files written using Gherkin
https://cucumber.io/

 === Selenium WebDriver
Web framework that permits the driving of a browser to execute and perform the actions required during a scenario
https://www.selenium.dev/

 === Extent Report and Extent Spark Report
Reporting plugin that uses the cucumber.json generated by cucumber to produce a formatted HTML report

Extent Spark Reports The Framework uses Spark Reports Framework to generate the HTML Test Reports

 === WebDriverManager
|Library which allows management of WebDrivers to be automated
|https://github.com/bonigarcia/webdrivermanager/

 === TestNG
|Testing framework inspired from JUnit and NUnit which provides various annotations and methods to enable testing function
|https://testng.org/doc/

                === Project Structure  ===
Tests are composed in the Gherkin syntax for usage in the Cucumber BDD framework, this makes tests accessible and easy to compose for non-technical stakeholders.
Tests are in the form of feature files which can be found within the feature folder located at `src/test/java/resources/features`

Feature files utilise stepdefinitions (underlying code for each scenario step) which are written in Java. Step class files can be found at `src/test/java/stepdefinitions`

Steps use page objects to allow interaction with page elements. The page classes which said objects are created from, 
house all the methods for checking visibility, clicking and sending keys or actions to elements. Page class files can be found at  `src/test/java/pages`

The entire suite is executed by the runner located at `src/test/java/runner/testNg.java`, the various parameters used when executing the suite are specified here. 
Examples include, the plugins used, the reference to both stepdefinitions and features, and the tags used to specify which scenarios to execute.

The Hook is located within the stepdefinitions folder at `src/test/java/stepdefinitions/Hooks.java`, the Hook class specifics methods to be executed with each scenario, 
the various annotations used within the Hook specify when each method is executed.

              === Pre-requisite Requirements ===


Automation Framework requires:

Installation JDK 1.8+ (make sure Java class path is set) 

Maven (make sure .m2 class path is set or use the dependency)

IntelliJ Plugins (Make sure Test Ng / Gerkin / Cucumber Java is installed) 

Browser driver (make sure you have your desired browser installed - Edge, FireFox, Chrome) 

Framework set up Fork / Clone repository from here or download zip and set it up in your local workspace.

- Java 8 and above
- Maven (or an IDE which has inbuilt Maven/allows Cucumber execution)
- Web Browser (any browser works, as long as the config is set to the installed browser)

The following operating systems can currently run the framework (with the possibility to include additions where necessary):

- Windows
- MacOS
- Linux
           
          === Hardware Requirements ===

Due to the fact that this is a Java based project, the hardware requirements will be the same as Java.
A list of these requirements can be found at: https://www.java.com/en/download/help/sysreq.html

If running via an IDE then you will need the minimum hardware requirements of the chosen IDE, 
for IntelliJ IDEA these requirements can be found at: https://www.jetbrains.com/help/idea/installation-guide.html

 === Running via Maven
Execute `mvn clean install` in a terminal from the root directory of the project. By running `mvn install` it ensure the full suite is ran including test report generation.

 === Running via an IDE
Using a suitable IDE, it is possible that Maven is inbuilt in the form of a plugin; below you can see how IntelliJ IDEA executes the suite.

=== Viewing Test Output
Once the test suite has been run, Cucumber generates a simple JSON output which can be found in `target/jason/file.json`. 
In addition, a full test suite run causes Extent Report and Extent Spark Report reporting plugin to be triggered 
which generates a html report at 

=Extent Report
==test-out/ExtentHtml.html or 
=Extent Spark Report
==test-output/SparkReport/Spark/Spark.htmll`
