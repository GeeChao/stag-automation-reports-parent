package org.stag.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class AccountPage extends NavPane {

    @FindBy(css = "h3.RTL")
    public WebElementFacade welcomeHeader;

}
