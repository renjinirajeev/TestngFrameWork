package com.automation.listener;

import com.automation.utils.ExtendReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentListener implements ITestListener {

    public void onFinish(ITestContext context){
        ExtendReportManager.flush();
    }
    public void onStart(ITestContext context){
        ExtendReportManager.initExtentReport();
    }
    public void onTestStart(ITestResult result){
        ExtendReportManager.createTest(result.getMethod().getMethodName());
    }
    public void onTestSuccess(ITestResult result){
        ExtendReportManager.getTest().pass("test passed");
        ExtendReportManager.attachScreenShot();
    }
    public void onTestFail(ITestResult result){
        ExtendReportManager.getTest().fail("test failed\n"+result.getThrowable().getMessage());
        ExtendReportManager.attachScreenShot();
    }
    public void onTestSkip(ITestResult result){
        ExtendReportManager.getTest().skip("test Skipped");
    }

}
