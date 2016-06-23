# stag-automation-reports-parent
Demo project of some Java open source reporting frameworks &amp; libraries > 

The parent project contains 3 sub modules, one demonstrating each of the reports whilst integrating it 
with existing test frameworks such as JUnit, TestNG, Cucumber-JVM etc. 

Serenity-BDD is a bit different to both ExtentReports and Allure as it is much more than a basic reporting
library, it is basically a full-fledged test automation framework built for testing web-apps and webservices
as it contains a wrapper on top of Selenium WebDriver and the REST-Assured API. It also contains other 
highly useful features such as dependency injection, context management and a fluent API for page objects
and element manipulation. 

Extent Reports is a basic library to create an HTML report that you can integrate into existing Java and/or
.NET projects without much effort. Furthermore, the creator has also provided a reporting server based on 
MongoDB and NodeJS platform for you to write your HTML reports to with high level detailed graphs and tables
on the aggregation of all your past automated suite runs. 

AllureFramework is also a basic reporting library to create a living documentation in the form of an web-page,
however where it differs is it requires an existing adapter to initially write results to an expected XML file.
There are then multiple different tools to convert the XML into an Allure html report, which is then deployed
onto a specified Jetty server. 




