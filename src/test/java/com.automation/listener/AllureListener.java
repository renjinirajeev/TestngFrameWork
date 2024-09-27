package com.automation.listener;

import io.qameta.allure.testng.AllureTestNg;
import org.testng.ITestResult;
import com.automation.utils.AllureReportManager;

public class AllureListener extends AllureTestNg {

    @Override
    public void onTestFailure(ITestResult result) {
        AllureReportManager.takeScreenShot();
        super.onTestFailure(result);
    }
}
