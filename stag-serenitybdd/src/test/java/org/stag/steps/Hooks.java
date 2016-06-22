package org.stag.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.stag.pageobjects.HomePage;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Managed
    WebDriver driver;
    HomePage homePage;

    public Hooks() throws Throwable {
        System.out.println(">> Initialize Hooks");
    }

    @Before
    public void beforeScenario(Scenario scenario) throws Throwable {
        System.out.println(">> Before scenario");
        System.out.println("Scenario: " + scenario.getId() + " : " + scenario.getName());
                driver.manage().window().maximize();
    }

    @After
    public void afterScenario(Scenario scenario) throws Throwable {
        System.out.println(">> After scenario");
        System.out.println("Status: " + scenario.getStatus());
        if(driver!=null){
            driver.close();
            driver.quit();
        }
        Serenity.getCurrentSession().clear();
    }

}
