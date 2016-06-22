package org.stag.tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RunMainTests {

    private static ExtentReports extent;

    public static void main(String[] args){

        String projectDir = System.getProperty("user.dir");
        String htmlFile = projectDir+"\\stag-extentreports\\target\\extentreport.html";
        String picFile = projectDir+"\\stag-extentreports\\src\\test\\resources\\staglogo.png";
        String vidFile = projectDir+"\\stag-extentreports\\src\\test\\resources\\samplevid.mp4";

        System.out.println(htmlFile);
        extent = new ExtentReports(htmlFile, true);

        // creates a toggle for the given test, adds all log events under it
        ExtentTest test = extent.startTest("My First Test", "Sample description");
        test.assignCategory("1st");
        test.assignAuthor("STAG");
        // log(LogStatus, details)
        test.log(LogStatus.INFO, "This step shows usage of log(logStatus, details)", "details");

        // report with snapshot
        test.log(LogStatus.INFO, "Image", "details" + test.addScreenCapture(picFile));

        //report with screencast
        test.log(LogStatus.INFO, "video", "details" + test.addScreencast(vidFile));

        // end test
        extent.endTest(test);


        // creates a toggle for the given test, adds all log events under it
        ExtentTest test2 = extent.startTest("My Second Test", "Sample description");
        test2.assignAuthor("STAG");
        test2.assignCategory("2nd");
        // log(LogStatus, details)
        test2.log(LogStatus.INFO, "First step", "details 1");
        test2.log(LogStatus.INFO, "Second step", "details 2");
        test2.log(LogStatus.INFO, "Third step", "details 3");


        // end test
        extent.endTest(test2);


        // calling flush writes everything to the log file
        extent.flush();
    }

}
