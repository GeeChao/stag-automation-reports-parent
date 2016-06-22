package org.stag.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.stag.serenitysteplib.SearchFlightSerenitySteps;

public class SearchSteps {

    @Steps
    SearchFlightSerenitySteps searchFlightsSS;

    @When("^I want a (one way|return) flight$")
    public void wantAFlightType(String flightType){
        if(flightType.equalsIgnoreCase("one way")){
            searchFlightsSS.selectOneWayFlight();
        } else {
            searchFlightsSS.selectReturnFlight();
        }
    }

    @When("^I want to fly from (.*) to (.*)$")
    public void selectFlightDestinations(String origin, String destination){
        searchFlightsSS.selectFlightOrigin(origin);
        searchFlightsSS.selectFlightDestination(destination);
    }

    @When("^I submit my search$")
    public void submitSearch(){
        searchFlightsSS.submitSearch();
    }

    @Then("^I should see a list of search results$")
    public void seeListOfSearchResults(){
        searchFlightsSS.validateSearchResultsFound();
    }

}
