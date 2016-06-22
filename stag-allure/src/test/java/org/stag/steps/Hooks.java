package org.stag.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    public Hooks() throws Throwable {
        System.out.println(">> Initialize Hooks");
    }

    @Before
    public void beforeScenario(Scenario scenario) throws Throwable {
        System.out.println(">> Before scenario");
        System.out.println("Scenario: " + scenario.getId() + " : " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) throws Throwable {
        System.out.println(">> After scenario");
        System.out.println("Status: " + scenario.getStatus());
    }

}
