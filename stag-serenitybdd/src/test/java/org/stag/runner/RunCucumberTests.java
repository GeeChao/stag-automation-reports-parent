package org.stag.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Exactly the same as the cucumber runner class in a traditional cucumber test framework
 * However the Runner has been changed to @RunWith(CucumberWithSerenity.class) as oppoosed to Cucumber.class
 * This is required to generate report, context management, DI, webdriver API etc.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources",
        plugin = {"pretty", "html:target/cucumber", "rerun:target/rerun.txt"},
        glue = "org.stag.steps"
)

public class RunCucumberTests {
    @BeforeClass
    public static void beforeCucumberSuite() {
        System.out.println(">> Starting run all cucumber test suite");
    }

    @AfterClass
    public static void afterCucumberSuite() {
        System.out.println(">> Finished run all cucumber test suite");
    }
}
