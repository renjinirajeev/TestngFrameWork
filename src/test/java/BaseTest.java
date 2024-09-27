package com.automation.test;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.DriverManager;
import com.automation.utils.ConfigReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.naming.ldap.ExtendedRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;


public class BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    private static ExtentReports extentReports;
    public static ExtentTest test;
    private static ExtentSparkReporter sparkReporter;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
//    public void setUp(ITestContext context) throws MalformedURLException {
//        String reportPath=System.getProperty("user.dir")+"\\reports\\extentReport.html";
//        sparkReporter = new ExtentSparkReporter(reportPath);
////        sparkReporter.config().setTheme(Theme.DARK);
//
//        extentReports = new ExtentReports();
//        test=extentReports.createTest("verify user can login");
//        test.info("Navigate to another page");


        ConfigReader.initconfig();
        DriverManager.createDriver();
        homePage = new HomePage();
        loginPage = new LoginPage();

    }

    @AfterMethod
    public void cleanUp() {

//        extentReports.attachReporter((sparkReporter));
//        extentReports.flush();
        DriverManager.getDriver().quit();
    }

//    public String takeScreenShoot() throws IOException {
//        TakesScreenshot takesScreenshot=(TakesScreenshot) DriverManager.getDriver();
//        File file=takesScreenshot.getScreenshotAs(OutputType.FILE);
//        String filepath="src/test/resources"+"/ss.png";
//        FileUtils.copyFile(file, new File(filepath));
//        return System.getProperty("user.dir")+"/"+filepath;
//
//    }


}

