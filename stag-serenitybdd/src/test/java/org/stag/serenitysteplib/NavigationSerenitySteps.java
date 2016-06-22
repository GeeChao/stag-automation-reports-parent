package org.stag.serenitysteplib;

import net.thucydides.core.annotations.Step;
import org.stag.pageobjects.AccountPage;
import org.stag.pageobjects.FlightsPage;
import org.stag.pageobjects.HomePage;
import org.stag.pageobjects.LoginPage;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class NavigationSerenitySteps extends BaseSerenitySteps {

    HomePage homePage;
    LoginPage loginPage;
    FlightsPage flightsPage;
    AccountPage accountPage;

    @Step
    public void navigateToLoginPage() {
        homePage.myAccountBtn.waitUntilClickable().click();
        homePage.loginBtn.waitUntilClickable().click();
        assertThat(homePage.getTitle()).as("Validate at login page").isEqualTo("Login");
    }

    @Step
    public void openHomePage(){
        homePage.open();
    }

    @Step
    public void navigateToMyProfilePage(){
        accountPage.myProfileBtn.waitUntilClickable().click();
    }

    @Step
    public void navigateToLogOut() {
        homePage.myAccountBtn.waitUntilClickable().click();
        homePage.logoutBtn.waitUntilClickable().click();
    }

    @Step
    public void navigateToSearchFlights() {
        homePage.flightsBtn.waitUntilClickable().click();
        assertThat(flightsPage.getTitle()).as("Validate at flights page").isEqualTo("Flights");
        getDriver().switchTo().frame("tree");
    }

    @Step
    public void validateAtMyAccountPage() {
        assertThat(accountPage.getTitle()).isEqualTo("My Account");
        assertThat(getDriver().getCurrentUrl()).as("Validate at account page").isEqualTo("http://phptravels.net/account/");
    }

    @Step
    public void validateAtLoginPage() {
        assertThat(loginPage.getTitle()).isEqualTo("Login");
        assertThat(getDriver().getCurrentUrl()).isEqualTo("http://phptravels.net/login");
    }

}
