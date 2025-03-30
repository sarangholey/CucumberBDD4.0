# Web UI Test Automation - Incorporating BDD (Cucumber) 
---
This Test Automation Framework has been created for the demonstration of Test Automation of a Web Baised application using Selenium WebDriver API's with BDD apprach. 
Please stay tuned for more enhancements.

### Tool Used Stack Used
* Test Automation - Selenium WebDriver
* Test Cases Writing - BDD (Cucumber) 
* Project Build - Maven
* Unit Testing - Junit
* Logs - Log4J2
* Test Reports - Extent Report, Cucumber HTML Report

### How to Execute Test Cases
* Clone the Repository
* Open Command Prompt/Git Bash window
* Type mvn command: ```mvn clean verify``` : this will run on chrome, since no browser is mentioned.
* To Run on specific browser - e.g. Edge, Firefox, Opera, type mvn command: ```mvn clean verify -Dbrowser=firefox``` :  this will run on firefox
* For Headless browser mode execution, type mvn command: ```mvn clean verify -Dbrowser=headless``` : this will run on headless browser, i.e. no browser will be opened and tests will be executed on a head less browser
* After execution completion for results refresh the project and checkout - Reports folder with relevent date and time
* To Retun failed Testcases - run as JUnit Test to the TestRunnerRerun file under - com.qa.automation.runners folder path

