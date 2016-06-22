package org.stag.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class NavPane extends PageObject {

    @FindBy(css = "a.show-submenu")
    public WebElementFacade myAccountBtn;

    @FindBy(linkText = "Login")
    public WebElementFacade loginBtn;

    @FindBy(linkText = "Logout")
    public WebElementFacade logoutBtn;

    @FindBy(linkText = "Flights")
    public WebElementFacade flightsBtn;

    @FindBy(linkText = "Account")
    public WebElementFacade accountBtn;

    @FindBy(linkText = "My Profile")
    public WebElementFacade myProfileBtn;

}
