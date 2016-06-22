package org.stag.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class FlightsPage extends NavPane{

    @FindBy(css = "h3.RTL")
    public WebElementFacade welcomeHeader;

    @FindBy(id = "check_returndate")
    public WebElementFacade returnChkBox;

    @FindBy(id = "check_oneway")
    public WebElementFacade onewayChkBox;

    @FindBy(id = "arrivePlace")
    public WebElementFacade arriveDropBox;

    @FindBy(id = "departPlace")
    public WebElementFacade departDropBox;

    @FindBy(linkText = "Search")
    public WebElementFacade searchBtn;

    @FindBy(id = "results")
    public WebElementFacade resultsTable;

}
