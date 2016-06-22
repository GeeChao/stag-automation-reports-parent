package org.stag.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.stag.serenitysteplib.LogoutSerenitySteps;
import org.stag.serenitysteplib.NavigationSerenitySteps;

public class LogoutSteps {

    @Steps
    LogoutSerenitySteps logoutSS;
    @Steps
    NavigationSerenitySteps navSS;

    @When("^(?i)I navigate to log out$")
    public void navigateToLogOut(){
        navSS.navigateToLogOut();
    }

    @Then("^(?i)I should be logged out successfully$")
    public void loggedOutSuccessfully() {
        navSS.validateAtLoginPage();
    }
}
