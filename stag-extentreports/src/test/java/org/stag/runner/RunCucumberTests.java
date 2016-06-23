package org.stag.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.stag.utils.ExtentManager;

@RunWith(Cucumber.class)
/**
 * Because we are implementing the Cuke interfaces Reporter/Formatter
 * For it to be automatically invoked, I have appended the Hooks class
 * To the Cucumber Options plugin config e.g. plugin = org.stag.steps.Hooks
 */
@CucumberOptions(
        features = "src/test/resources",
        plugin = {"pretty", "html:target/cucumber", "rerun:target/rerun.txt", "org.stag.steps.Hooks"},
        glue = {"org.stag.steps", "org.stag.runner"}
)

public class RunCucumberTests {
    /**
     * JUnit hooks to automatically invoke methods before and after entire cucumber test suite run
     * I initialize the extent report and create the HTML report in the @BeforeClass
     * And I flush/close the reporter after everything is run in the @AfterClass
     */
    @BeforeClass
    public static void startDebugCukesTest() {
        System.out.println(">> Starting run all cucumber test suite");
        ExtentManager.getReporter(System.getProperty("user.dir") + "\\target\\extentreportcucumber.html");
    }

    @AfterClass
    public static void endDebugCukesTest() {
        System.out.println(">> Finished run all cucumber test suite");
        ExtentManager.closeReporter();
    }
}
