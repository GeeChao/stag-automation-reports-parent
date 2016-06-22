package org.stag.serenitysteplib;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class BaseSerenitySteps extends ScenarioSteps {

    @Step
    public void description(String htmlString) {
        System.out.println("\n");
    }

    public void log(String description, String... remarks) {
        System.out.println("\n+Description: " + description + " | Remarks: " + remarks.toString());
        String html =
                "<h4 style=\"font-style:italic;color:black\">" + description + "</h4>" +
                        "<div><p>Remarks:</p>" +
                        "<ul style=\"margin-left:5%; font-weight:200; color:#434343; font-size:10px;\">";

        for (String li : remarks) html += "<li>" + li + "</li>";

        html += "<ul></div>";

        description(html);
    }

    public void log(String description) {
        System.out.println("\n+Description: " + description);
        String html =
                "<h4 style=\"font-style:italic;color:black\">" + description + "</h4>";
        description(html);
    }
}
