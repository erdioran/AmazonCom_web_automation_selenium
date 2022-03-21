package com.erdioran.listener;


import com.aventstack.extentreports.ExtentTest;
import com.erdioran.base.DriverManager;
import com.erdioran.utils.ExtentManager;
import com.erdioran.utils.ExtentTestManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.List;
import java.util.stream.Collectors;

public class TestListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Passed test method : [{}] in class [{}]", result.getMethod().getMethodName(), result.getTestClass().getName());
        ExtentTestManager.getNode().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.error("Test method failed : [{}] in class [{}]", result.getMethod().getMethodName(),
                result.getTestClass().getName());
        LOGGER.error(result.getThrowable());
        if (!result.wasRetried()) {
            if (DriverManager.getDriver() != null) {
                ExtentTestManager.getNode().fail("Url in address bar at the time of failure : " + DriverManager.getDriver().getCurrentUrl());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        List<String> dependingTestList = result.getSkipCausedBy().stream().map(ITestNGMethod::getMethodName)
                .collect(Collectors.toList());
        LOGGER.info("Skipped test method : [{}] in class [{}]. Depending on test method {}", result.getMethod().getMethodName(),
                result.getTestClass().getName(), dependingTestList);
        if (!result.wasRetried()) {
            ExtentTest node = ExtentTestManager.getTest().createNode(result.getMethod().getMethodName());
            node.skip(String.format("Skipped. Depending test %s failed", dependingTestList));
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
        LOGGER.info("Executing test : [{}] from class [{}]", context.getCurrentXmlTest().getName(),
                context.getCurrentXmlTest().getXmlClasses().get(0).getName());
        ExtentTestManager.startTest(context.getName(), "");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getExtentReports().flush();
    }
}
