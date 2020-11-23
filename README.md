# WebApplicationTesting
This is a end to end framework for testing the web application which is designed using react. Few business logic edge test cases are covered .
# Automation Setup guidelines :
1) Make sure that Maven, Java (v1.8), Selenium server are installed in the system
2) Check out GitHub repo into any IDE (preferred Eclipse)
3) Basic commands to run tests - open terminal and go to project directory and run command : "mvn clean install"
4) After test build, run following command in terminal for allure report generation : allure serve allure-results
5) Above command will generate allure report and launch these reports in system's default browser

## Key features of framework used :
1.	Page Object Model: It's a design pattern, popularly used in test automation that creates Object Repository for each page and stores all web UI elements
2.	Java : Most convenient programming language for me.
3.	Maven: For build management purpose, a common structure can be maintained very easily .
4.	Selenium: Open source, most convenient browser UI automation tool .
5.	TESTNG  : TestNG  is the testing framework. Advantages that makes this framework more powerful and easier.
6.	Allure Reports : As it is most clean automation reports and provides lots of useful annotations as well. 
7.	Log4J  : Logging framework for the logging the status.


# Reasons for choosing the framework : Page Object Model :
1.	According to Page Object Model, we should keep our tests and element locators separately, this will keep code clean and easy to understand and maintain.
2.	The Page Object approach makes test automation framework programmer friendly, more durable and comprehensive.
3.	Another important advantage is our Page Object Repository is Independent of Automation Tests. Keeping separate repository for page objects helps us to use this repository for different purposes with different frameworks like, we are able to integrate this repository with other tools like TestNG/Cucumber/etc.
4.	Test cases become short and optimized as we are able to reuse page object methods in the POM classes.
5.	Any change in UI can easily be implemented, updated and maintained into the Page Objects and Classes.
6.	Easily Scalable approach .

# PreRequisities :
1.	Download Eclipse .
2.	Download Jdk and latest maven files .
3.	Set Java path and maven path in system environment variables.
4.	Import the files into your workspace and set build path .
5.	Run As Maven clean and maven install .
6.	Code is ready for testing .

# Project Structure :
Below are the list of package and folders which are part of WebApplicationTesting project.

# src/main/java : 
1.	Packages -> base : Have all the Common Class files like Browser Init , Prop Reader etc .
2.	Packages -> Config : Have all the Configuration properties files and the Log4j properties files .
3.	Packages -> PageObjectModel : All the Web elements and methods are driven from this package (Page Object Model ) .
4.	Packages -> Listerns : The Listerner class files for the report generation .
5.	Packages -> Constants : All the Constants which are used in the different class files are driven from this .
6.	Packages -> Utils : All the Utility like browser interactions,Locator types and all common methods are reused from this package.

# src/test/java : 
1.	Packages -> baseTest : This package has all the set up and tear down methods.
2.	Packages -> TestScripts : This package has all the test scripts PostArticle,editArticle etc

# Reporting :
1.	The Reports will be generated and stored in the Allure-results folder .
2.	The Logging framework messages will be stored in the {{ProjectDirecory}}->Log->LogMessages.log file .

# Task Requirements :
Task 1 - Web testing
1.	All the points have been carefully followed and implemented as per the task requirements.
2.	Manual test cases step by step for each script are documented and stored in {{ProjectDirecory}}->TestCases.xlsx.

Task 2 - SQL Task 
1.	The Queries are documented and stored in  {{ProjectDirecory}}->SQL_Queries.txt.

Task 3 - Jenkins Task 
1.	The Jenkins configuration file with step by step description and screenshots and stored in {{ProjectDirecory}}->JenkinsConfiguration.pdf.


# How to Run the Test from Eclipse IDE &  CMD Terminal :
1. Select project and right click on src/test/java and Run As->Java Application/ TestNG Test.
2. Right click on {{src/test/resources/testrunner}} ->TestSuite.xml file and click on Run .
3. Get to the project directary from the CMD .
4. Use Maven Coammands to run ( mvn clean install) .
5. To generate the report (mvn allure serve) .

# How to Clone project from git repo to local for testing :
$ git clone https://github.com/bharathreddy0201/WebApplicationTesting.git
