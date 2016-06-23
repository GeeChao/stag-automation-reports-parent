package org.stag.serenitysteplib;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import org.stag.pageobjects.FlightsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchFlightSerenitySteps extends BaseSerenitySteps {

    FlightsPage flightsPage;

    @Step
    public void selectOneWayFlight() {
        flightsPage.onewayChkBox.waitUntilClickable().click();
    }

    @Step
    public void selectReturnFlight() {
        flightsPage.returnChkBox.waitUntilClickable().click();
    }

    /**
     * Lazy approach for website's auto-fill field
     * @param origin
     */
    @Step
    public void selectFlightOrigin(String origin) {
        flightsPage.departDropBox.type(origin);
        waitABit(3000);
        flightsPage.departDropBox.sendKeys(Keys.TAB);
    }

    /**
     * Lazy approach for website's auto-fill field
     * @param destination
     */
    @Step
    public void selectFlightDestination(String destination) {
        flightsPage.arriveDropBox.type(destination);
        waitABit(3000);
        flightsPage.arriveDropBox.sendKeys(Keys.TAB);
    }

    @Step
    public void submitSearch() {
        flightsPage.searchBtn.waitUntilClickable().click();
    }

    @Step
    public void validateSearchResultsFound() {
        flightsPage.resultsTable.waitUntilVisible();
        assertThat(flightsPage.resultsTable.waitUntilPresent().isVisible()).isTrue();
//        List<WebElement> elements = flightsPage.resultsTable.findElements(By.xpath("//div[@id='resultlist']"));
//        for(WebElement e: elements){
//            System.out.println(e.getText());
//        }

    }


}
