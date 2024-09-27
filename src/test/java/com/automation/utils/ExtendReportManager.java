package com.automation.utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ExtendReportManager {
    private static ExtentReports extentReports;
    public static ExtentTest test;

    public static void initExtentReport(){
        String path = System.getProperty("user.dir")+"//extendReport/report.html";
        extentReports=new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentReports.attachReporter(extentSparkReporter);

    }

    public static void flush(){
        extentReports.flush();
    }

    public static void createTest(String name){
        test= extentReports.createTest(name);
    }

    public static ExtentTest getTest(){
        return test;
    }

    public static void attachScreenShot() {

        try {
            test.addScreenCaptureFromPath(takeScreenShot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static String takeScreenShot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File file=ts.getScreenshotAs(OutputType.FILE);
        String path ="src/test/resources/screenshot"+"/screenshot.png";
        FileUtils.copyFile(file,new File(path));
        return System.getProperty("user.dir")+"/"+path;
    }
}
