package org.stag.runner;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.stag.serenitysteplib.LoginSerenitySteps;
import org.stag.serenitysteplib.NavigationSerenitySteps;

/**
 * Created by Matthew Chan on 15-Jun-16.
 */
@RunWith(SerenityRunner.class)
public class JUnitTests {

    @Managed
    WebDriver driver;

    @Steps
    LoginSerenitySteps loginSS;
    @Steps
    NavigationSerenitySteps navSS;

    @Test
    @Title("JUnit valid login test")
    public void validLoginTest(){
        //Given
        navSS.openHomePage();
        navSS.navigateToLoginPage();

        //When
        loginSS.getLoginDetails("valid");
        loginSS.inputLoginDetails();

        //Then
        loginSS.validateLoggedIn();
        navSS.validateAtMyAccountPage();

    }

}
