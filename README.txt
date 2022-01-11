This is a demo task prepared by Ugur Niyet for Invicti Security

It contains functional and non-functional test cases and their Selenium WebDriver automation code
OOP concepts, Page Object Model (POM), singleton driver and parallel running Maven project was coded in Java.
Cucumber BDD tool with Gherkin language was chosen to increase team collaboration.
Scenario outline was used to run the same test case with different set of data
Before After methods are stored in Hooks class
Url and browser information was kep in a centralized configuration properties file
All these methodologies was used to achieve an easy-to-maintain and dynamic code

A special driver class was created to allow running the tests in parallel.
Explanations was provide as clearly as possible before each method.
Cucumber HTML reports are used to create reports of execution
Screenshots for failed test cases are included automatically in the report.

2 test cases (colors of buttons and wromg title in wrong page) has failed. No bug report was created since this is a demo task.
Final step of scheduling demo session was not tested, because the app is in production environment, tester does not know (continue in line below)
whether the marketing team has information about testing activities.
It was aimed to avoid creating multiple unreal interviews and cause disturbance. 

Note: Implementation of Selenium 4 was considered at start. However changes in wait methods and driver design required more time than expected to implement.
In order to complete the task on a reasoble time and avoid unexpected shortcomings, project was re-modeled with Selenium 3.

Seleinum 4 would allow us to access ChromeDevTools and manipulate the browser even further with network tab as following
  - Loading of .jpg or .png files could be blocked to reduce page loading times,
  - Different screen resolutions and mobile devices could be eliminated,
  - Connection speed could be limited to test the behaviour of application in slow connections
 
  Stay Healthy & Stay Happy
  Ugur Niyet


