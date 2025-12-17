 OpenCart Hybrid Test Automation Framework 
•	[Java](https://img.shields.io/badge/Language-Java-orange)
•	[Selenium](https://img.shields.io/badge/Tool-Selenium_WebDriver-blue)
•	[TestNG](https://img.shields.io/badge/Framework-TestNG-red)
•	[Build](https://img.shields.io/badge/Build-Maven-green)

Project Overview
This is a robust Hybrid Test Automation Framework designed to automate the e-commerce flows of [OpenCart](https://demo.opencart.com/). It is built using Selenium WebDriver and Java, implementing the Page Object Model (POM) design pattern for maintainability and scalability. 
The framework supports Data-Driven Testing, Cross-Browser Execution, and generates detailed Extent Reports with logs and screenshots. 
 
 Tech Stack
Component	Tool / Library
Language	Java (JDK 11+)
Web Automation	Selenium WebDriver
Test Framework	TestNG
Build Tool	Apache Maven
Design Pattern	Page Object Model (POM)
Reporting	Extent Reports Spark Reporter
Logging	Log4j2
Data Source	Apache POI (Excel Integration)
CI/CD	Jenkins

 Framework Structure
The project follows a standard Maven directory structure: 
OpenCartTestNGFramework
├── src/test/java
│   ├── com.absoloop.pageObject     Page Classes (Locators & Actions)
│   ├── com.absoloop.testCases      Test Scripts (TestNG Classes)
│   ├── com.absoloop.testBase       Base Class (Driver Init, Common Methods)
│   └── com.absolooplab.Utility     Utilities (Excel, ExtentReports, DataProviders)
├── src/test/resources
│   ├── config.properties           Global Configuration (Browser, URL)
│   ├── log4j2.xml                  Logging Configuration
│   ├── testng.xml                  Test Suites (Master, Grouping, CrossBrowser)
│   └── testData                    Excel Data Sheets
├── reports                         HTML Execution Reports
├── logs                            Automation Execution Logs
└── pom.xml                         Project Dependencies
Key Features
•	Hybrid Approach: Combines Modular and Data-Driven frameworks.
•	Page Object Model: Keeps tests separate from object locators.
•	Data-Driven Testing: Reads test data dynamically from Excel (using ExcelUtility).
•	Detailed Reporting: Generates interactive HTML reports via ExtentReports, including screenshots for failed tests.
•	Logging: Implements Log4j2 to capture step-by-step execution details in logs/automation.log.
•	Cross-Browser Support: Run tests on Chrome, Edge, or Firefox by changing config.properties or using crossbrowsertests.xml.
•	Grouping: Supports Sanity, Regression, and Master suites via XML configuration.
How to Run Tests
1. Prerequisites
•	Java JDK 8 or higher
•	Maven installed and configured
•	Browser drivers (managed automatically via Selenium Manager)
2. Run via Command Line (Maven)
To execute the master suite (all tests): mvn clean test
To execute a specific suite (e.g., Grouping or CrossBrowser):
•	mvn test -DsuiteXmlFile=grouping.xml
•	mvn test -DsuiteXmlFile=crossbrowsertests.xml
3. Run via Jenkins (CI/CD)
This project is CI/CD ready.
1.	Create a Maven Project in Jenkins.
2.	Link this GitHub repository.
3.	Set the build goal to clean test.
4.	(Optional) Configure the HTML Publisher Plugin to archive reports from the reports/ folder.
Sample Report
The framework auto-generates a report at reports/Test-Report-YYYY.MM.DD.HH.mm.ss.html.
•	Pass/Fail Charts
•	Execution Time & Environment Details
•	Screenshots for Failures
Author
Tejas Zombade
