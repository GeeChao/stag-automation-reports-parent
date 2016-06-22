package org.stag.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.stag.serenitysteplib.LoginSerenitySteps;
import org.stag.serenitysteplib.NavigationSerenitySteps;

public class LoginSteps {

    @Steps
    LoginSerenitySteps loginSS;
    @Steps
    NavigationSerenitySteps navSS;

    @When("^(?i)I log in with (valid|invalid) user credentials$")
    public void loginWithValidUserCredentials(String loginType) {
        loginSS.getLoginDetails(loginType);
        loginSS.inputLoginDetails();
    }

    @Then("^(?i)I should be logged in successfully")
    public void shouldBeLoggedInSuccessfully(){
        loginSS.validateLoggedIn();
        navSS.validateAtMyAccountPage();
    }

    @Then("^(?i)I receive an invalid login error message$")
    public void receiveInvalidLoginErrorMsg(){
        loginSS.validateInvalidLoginErrorMsg();
    }

    @Then("^(?i)I am still on the login page$")
    public void stillAtLoginPage(){
        navSS.validateAtLoginPage();
    }
}
