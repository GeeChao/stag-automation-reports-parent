package org.stag.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProfilePage extends NavPane {

    @FindBy(name = "address1")
    public WebElementFacade address1Field;

    @FindBy(name = "confirmpassword")
    public WebElementFacade confirmPasswordField;

    @FindBy(css = "div.alert.alert-success")
    public WebElementFacade updateSuccessMsg;

}
