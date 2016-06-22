package org.stag.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.stag.serenitysteplib.NavigationSerenitySteps;

public class CommonSteps {

    @Steps
    NavigationSerenitySteps navSS;

    @Given("^(?i)I am on the login page$")
    public void navigateToLoginPage() {
        navSS.openHomePage();
        navSS.navigateToLoginPage();
    }

    @Given("^(?i)I browse the site as a guest$")
    public void browseSiteAsAGuest() {
        navSS.openHomePage();
        Serenity.setSessionVariable("username").to("guest");
    }

    @When("^(?i)I navigate to search for flights$")
    public void navigateToSearchForFlights() {
        navSS.navigateToSearchFlights();
    }

    @When("^I navigate to my profile page$")
    public void navigateToMyProfilePage(){
        navSS.navigateToMyProfilePage();
    }

}
