package org.stag.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class DemoSteps {

    @Given("^I have created a scenario$")
    public void createdAScenario(){
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I run this test$")
    public void iRunThisTest() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^it should write the results to the HTML file$")
    public void itShouldWriteTheResultsToTheHTMLFile() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^it should pass$")
    public void itShouldPass() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^it should fail$")
    public void itShouldFail() throws Throwable {
        Assert.fail();
        // Write code here that turns the phrase above into concrete actions
    }
}
