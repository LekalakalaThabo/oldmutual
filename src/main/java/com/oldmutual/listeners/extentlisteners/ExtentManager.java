package com.oldmutual.listeners.extentlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.oldmutual.base.Page;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

//import static com.oldmutual.base.Page.driver;


public class ExtentManager extends Page {

    private static ExtentReports extent;

    public static ExtentReports createInstance(String fileName) {


        ExtentSparkReporter spark = new ExtentSparkReporter(fileName);


        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle(fileName);
        spark.config().setEncoding("utf-8");
        spark.config().setReportName(fileName);

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Automation Tester", "Thabo L");
        extent.setSystemInfo("Organization", "OldMutual");
        return extent;
    }


    public static String screenshotPath;
    public static String screenshotName;

    public static void captureScreenshot() {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Date d = new Date();
        screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/target/extentReports/screenshots/" + screenshotName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


}
