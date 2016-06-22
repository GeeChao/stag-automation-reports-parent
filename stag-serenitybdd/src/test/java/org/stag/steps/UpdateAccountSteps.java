package org.stag.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.stag.serenitysteplib.UpdateAccountSerenitySteps;

public class UpdateAccountSteps {

    @Steps
    UpdateAccountSerenitySteps updateAccountSS;

    @When("^I update my address to (.*)$")
    public void updateAddress(String address){
        updateAccountSS.updateAddress(address);
        updateAccountSS.validateUpdateMessage();
    }

    @Then("^I should receive a message saying I updated my details correctly$")
    public void msgUpdateSuccessful(){
        updateAccountSS.validateUpdateMessage();
    }
}
