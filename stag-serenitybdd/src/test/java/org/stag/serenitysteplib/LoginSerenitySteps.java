package org.stag.serenitysteplib;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.stag.pageobjects.AccountPage;
import org.stag.pageobjects.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSerenitySteps extends BaseSerenitySteps {

    LoginPage loginPage;
    AccountPage accountPage;

    @Step
    public void getLoginDetails(String loginType){
        String username;
        String password;
        if (loginType.equalsIgnoreCase("valid")) {
            username = "user@phptravels.com";
            password = "demouser";
        } else {
            username = "invaliduser@phptravels.com";
            password = "invaliduser";
        }
        Serenity.setSessionVariable("username").to(username);
        Serenity.setSessionVariable("password").to(password);
    }

    @Step
    public void inputLoginDetails(){
        String username = Serenity.getCurrentSession().get("username").toString();
        String password = Serenity.getCurrentSession().get("password").toString();
        loginPage.usernameField.waitUntilClickable().type(username);
        loginPage.passwordField.type(password);
        loginPage.loginBtn.waitUntilClickable().click();
    }

    @Step
    public void validateLoggedIn(){
        assertThat(accountPage.welcomeHeader.withTimeoutOf(10, TimeUnit.SECONDS).isDisplayed()).as("Validate logged in").isTrue();
    }

    @Step
    public void validateInvalidLoginErrorMsg(){
        loginPage.invalidLoginErrorMsg.shouldBeVisible();
    }

}
