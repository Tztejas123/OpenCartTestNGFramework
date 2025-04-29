The GitHub repository Tztejas123/OpenCartTestNGFramework is designed for automated testing of the OpenCart e-commerce platform. It utilizes Java, Selenium WebDriver, and TestNG, following the Page Object Model (POM) design pattern to enhance code maintainability and reusability. (GitHub - saireddy17/opencart_aug10: Hybrid Driven Framework for automated testing of the Open Cart application. The framework is implemented using Java, Selenium, TestNG, and Maven, following the Page Object Model for enhanced reusability.)
________________________________________
Project Structure
•	src/test: Contains test classes and page object models.
•	testData: Holds test data files, such as Excel sheets for data-driven testing.
•	test-output: Stores TestNG reports and logs generated after test execution.
•	logs: Captures logging information during test runs.
•	screenshots: Saves screenshots taken during test execution, especially on failures.
•	reports: May contain custom test reports like ExtentReports.
•	pom.xml: Maven configuration file managing project dependencies and build configurations.
•	crossbrowsertests.xml, grouping.xml, master.xml: TestNG suite XML files for organizing and executing tests in different configurations. (GitHub - saireddy17/opencart_aug10: Hybrid Driven Framework for automated testing of the Open Cart application. The framework is implemented using Java, Selenium, TestNG, and Maven, following the Page Object Model for enhanced reusability.)
________________________________________
Key Features
•	Page Object Model (POM): Encapsulates page elements and actions in separate classes, promoting code reusability and readability.
•	TestNG Framework: Facilitates test configuration, grouping, and parallel execution.
•	Data-Driven Testing: Supports reading test data from external sources like Excel files for varied input scenarios.
•	Cross-Browser Testing: Enables running tests across different browsers using TestNG configurations.
•	Logging and Reporting: Implements logging mechanisms and generates detailed test execution reports, possibly using tools like ExtentReports.
•	Screenshot Capture: Automatically captures screenshots on test failures for easier debugging. (GitHub - saireddy17/opencart_aug10: Hybrid Driven Framework for automated testing of the Open Cart application. The framework is implemented using Java, Selenium, TestNG, and Maven, following the Page Object Model for enhanced reusability.)
________________________________________
Getting Started
1.	Clone the Repository:
2.	git clone https://github.com/Tztejas123/OpenCartTestNGFramework.git
3.	Import Project:
o	Open your preferred IDE (e.g., Eclipse, IntelliJ IDEA).
o	Import the project as a Maven project. (GitHub - vessela349/OpenCart: A test automation project for OpenCart)
4.	Configure TestNG Suite:
o	Modify the TestNG XML files (crossbrowsertests.xml, grouping.xml, master.xml) as per your testing requirements. (GitHub - saireddy17/opencart_aug10: Hybrid Driven Framework for automated testing of the Open Cart application. The framework is implemented using Java, Selenium, TestNG, and Maven, following the Page Object Model for enhanced reusability.)
5.	Run Tests:
o	Execute tests using the TestNG XML files through your IDE or command line:
o	mvn test -DsuiteXmlFile=master.xml
________________________________________
Prerequisites
•	Java Development Kit (JDK): Ensure JDK 8 or higher is installed.
•	Maven: Install Maven for project build and dependency management.
•	Selenium WebDriver: Included as a dependency in pom.xml.
•	TestNG: Included as a dependency in pom.xml.
•	ChromeDriver/GeckoDriver: Required for running tests on Chrome/Firefox browsers. (GitHub - saireddy17/opencart_aug10: Hybrid Driven Framework for automated testing of the Open Cart application. The framework is implemented using Java, Selenium, TestNG, and Maven, following the Page Object Model for enhanced reusability.)
________________________________________
Notes
•	Ensure that the paths to drivers and test data files are correctly set in the configuration.
•	Customize the logging and reporting configurations as needed for your testing environment.
•	Regularly update browser drivers to maintain compatibility with browser versions.
________________________________________
This framework serves as a foundational setup for automating OpenCart application testing. It can be extended and customized further to accommodate additional testing scenarios and integrations. 
