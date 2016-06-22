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

    private static List<String> steps;
    private static List<String> scenarioOutlineExamples;
    private static int stepi;
    private static int examplei;
    private static String featureName;
    private static boolean isScenarioOutline;

    private String scenarioName;
    private String scenarioDesc;
    private String errorMessage;

    public Hooks() {
        System.out.println("_____________ INITIALIZE HOOKS _____________");
        this.report = ExtentManager.getReporter(System.getProperty("user.dir") + "\\target\\extentreports\\extentreport.html");
    }

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

    @Override
    public void scenarioOutline(ScenarioOutline scenarioOutline) {
        System.out.println("SCENARIO OUTLINE: " + scenarioOutline.toString());
        isScenarioOutline = true;
        examplei = 1;
    }

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
