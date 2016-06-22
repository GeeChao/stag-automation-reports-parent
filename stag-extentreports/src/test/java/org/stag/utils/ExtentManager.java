package org.stag.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

import java.io.File;

/**
 * Created by AADM107 on 18/04/2016.
 */
public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(String filePath) {
        if (extent == null) {
            extent = new ExtentReports(filePath, true, NetworkMode.ONLINE);
            extent.loadConfig(new File(System.getProperty("user.dir")+"/src/test/resources/ExtentConfig.xml"));
        }
        return extent;
    }

    public synchronized static ExtentReports getReporter() {
        return extent;
    }

    public synchronized static void closeReporter() {
        if(extent!=null){
            extent.flush();
            extent.close();
        }
    }
}
