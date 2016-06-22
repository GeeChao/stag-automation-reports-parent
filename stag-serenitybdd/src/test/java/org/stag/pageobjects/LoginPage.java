package org.stag.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends NavPane {

    @FindBy(name = "username")
    public WebElementFacade usernameField;

    @FindBy(name = "password")
    public WebElementFacade passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElementFacade loginBtn;

    @FindBy(css = "div.alert.alert-danger")
    public WebElementFacade invalidLoginErrorMsg;


}
