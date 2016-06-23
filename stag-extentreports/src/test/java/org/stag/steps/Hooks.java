package org.stag.steps;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.*;
import org.stag.utils.ExtentManager;
import org.stag.utils.ExtentTestManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hooks implements Formatter, Reporter {

    private ExtentReports report;
    private ExtentTest logger;
    private String scenarioName;
    private String scenarioDesc;
    private String errorMessage;

    /**
     * These are static members required for keeping the same tate when used in the Formatter/Reporter methods
     * This is because when these methods are invoked, it's actually a different instance of the Hooks class
     */
    private static List<String> steps;
    private static List<String> scenarioOutlineExamples;
    private static int stepi;
    private static int examplei;
    private static String featureName;
    private static boolean isScenarioOutline;

    public Hooks() {
        System.out.println("_____________ INITIALIZE HOOKS _____________");
    }

    /**
     * Invoked before every cucumber scenario or scenario outline example run
     * Gets feature name followed by scenario name and creates a new test in extent reports
     * If it is a scenario outline, it will also append the Example key
     * It will also assign it to a category which is the feature name
     * Another improvement is to use the ExtentReports assignChild for scenario outline example runs (not yet implemented)
     * @param scenario
     * @throws IOException
     * @throws InterruptedException
     */
    @Before
    public void initiate(Scenario scenario) throws IOException, InterruptedException {
        steps = new ArrayList<>();
        System.out.println("SCENARIO ID AND NAME:" + scenario.getName());

        if (isScenarioOutline) {
            System.out.println(examplei);
            scenarioName = featureName + " : " + scenario.getName().toString() + " : Example #" + examplei;
            scenarioDesc = "Tags: " + scenario.getSourceTagNames() + "\n Example Data: " + scenarioOutlineExamples.get(examplei - 1);
            examplei++;
            if (examplei == scenarioOutlineExamples.size() + 1) {
                isScenarioOutline = false;
            }
        } else {
            scenarioName = featureName + " : " + scenario.getName().toString();
            scenarioDesc = "Tags: " + scenario.getSourceTagNames().toString();
        }

        logger = ExtentTestManager.startTest(scenarioName, scenarioDesc);
        logger.assignCategory("Feature: " + featureName);
    }

    /**
     * Invoked after the completion of a Cucumber scenario
     * Resets static members where required
     * Also ends the test in the report
     * @param scenario
     * @throws Throwable
     */
    @After
    public void terminate(Scenario scenario) throws Throwable {
        String status = scenario.getStatus();
        System.out.println("SCENARIO STATUS: " + status);

        //Reset step count and clear org.stag.runner.steps list
        steps.clear();
        stepi = 0;

        //End the logger test for each scenario
        ExtentTestManager.endTest();
    }

    /**
     * This is the method that is automatically invoked after EVERY step in a scenario, not the step method
     * Because of this, and we only have access to the result parameter
     * 
     * @param result
     */
    @Override
    public void result(Result result) {
        String currentStep = steps.get(stepi);
        System.out.println("AFTER EVERY STEP RESULT: " + result.getStatus() + "||" + currentStep + "||" + stepi);
        stepi++; //Increase step count
        errorMessage = "<b>Error message: </b>" + result.getError() + " <b> | Stack Trace: </b>" + result.getErrorMessage(); //Get failed step error message
        logger = ExtentTestManager.getTest();

        if (result.getStatus().equalsIgnoreCase("failed")) {
            logger.log(LogStatus.FAIL, currentStep, result.getError());
        } else if (result.getStatus().equalsIgnoreCase("skipped")) {
            logger.log(LogStatus.SKIP, currentStep, "Step skipped due to previous step failing");
        } else { //Step passed at this point
            logger.log(LogStatus.PASS, currentStep, "Description");
        }
    }

    public void feature(Feature feature) {
        featureName = feature.getName();
    }

    /**
     * Invoked if the scenario is a scenario outline
     * sets the scenario outline boolean member to true and the index to start at 1 to ignore the row title
     * @param scenarioOutline
     */
    @Override
    public void scenarioOutline(ScenarioOutline scenarioOutline) {
        System.out.println("SCENARIO OUTLINE: " + scenarioOutline.toString());
        isScenarioOutline = true;
        examplei = 1;
    }

    /**
     * Create new examples array and assigns the scenario outline examples to it
     * This is then iterated through based on how many times the scenario is run
     * @param examples
     */
    @Override
    public void examples(Examples examples) {
        scenarioOutlineExamples = new ArrayList<>();
        System.out.println("EXAMPLES: " + examples.getName());
        List<ExamplesTableRow> er = examples.getRows();
        Iterator<ExamplesTableRow> examplesIterator = er.iterator();
        examplesIterator.next();
        while (examplesIterator.hasNext()) {
            String examplesDataTableLine = examplesIterator.next().getCells().toString();
            System.out.println(examplesDataTableLine);
            scenarioOutlineExamples.add(examplesDataTableLine);
        }
    }

    /**
     * Unfortunately, this step is actually invoked at the start of the scenario by the gherkin parser
     * It lists all the steps out in 1 go before the scenario is actually executed
     * Therefore we store it into a static step member and iterate through it every time the result method is invoked
     * @param step
     */
    @Override
    public void step(Step step) {
        System.out.println("STEPS IN SCENARIO: " + step.getKeyword() + step.getName());
        String stepParams = "";
        List<DataTableRow> rows = step.getRows();
        if (rows != null) {
            Iterator<DataTableRow> rowsIterator = rows.iterator();
            while (rowsIterator.hasNext()) {
                String stepDataTableLine = rowsIterator.next().getCells().toString();
                System.out.println(stepDataTableLine);
                stepParams = stepParams + stepDataTableLine;
            }
        }
        System.out.println(step.getKeyword() + step.getName() + " " + stepParams);
        steps.add(step.getKeyword() + step.getName() + " " + stepParams);
    }


    @Override
    public void before(Match match, Result result) {

    }

    @Override
    public void after(Match match, Result result) {

    }

    @Override
    public void match(Match match) {

    }

    @Override
    public void embedding(String mimeType, byte[] data) {

    }

    @Override
    public void write(String text) {

    }

    @Override
    public void syntaxError(String state, String event, List<String> legalEvents, String uri, Integer line) {

    }

    @Override
    public void uri(String uri) {

    }

    @Override
    public void startOfScenarioLifeCycle(gherkin.formatter.model.Scenario scenario) {
    }

    @Override
    public void background(Background background) {
    }

    @Override
    public void scenario(gherkin.formatter.model.Scenario scenario) {
    }

    @Override
    public void endOfScenarioLifeCycle(gherkin.formatter.model.Scenario scenario) {
    }

    @Override
    public void done() {
    }

    @Override
    public void close() {
    }

    @Override
    public void eof() {
    }
}
