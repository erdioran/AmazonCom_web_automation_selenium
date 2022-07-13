package com.erdioran.base;


import com.aventstack.extentreports.ExtentTest;
import com.erdioran.listener.SeleniumListener;
import com.erdioran.utils.ConfigManager;
import com.erdioran.utils.DataManager;
import com.erdioran.utils.ExtentTestManager;
import com.erdioran.utils.Helper;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public abstract class BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);



    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method, ITestResult result, ITestContext context) {
        ThreadContext.put("testName", method.getName());
        LOGGER.info("Executing test method : [{}] in class [{}]", result.getMethod().getMethodName(),
                result.getTestClass().getName());
        String nodeName =
                StringUtils.isNotBlank(result.getMethod().getDescription()) ? result.getMethod().getDescription() : method.getName();
        ExtentTest node = ExtentTestManager.getTest().createNode(nodeName);
        ExtentTestManager.setNode(node);
        ExtentTestManager.info("Test Started");
        String status = (String) context.getAttribute("previousTestStatus");
        boolean isNewBrowserPerTest = Boolean.parseBoolean(ConfigManager.getConfigProperty("new.browser.per.test"));
        boolean isCleanUpTest = context.getName().contains("Clean");
        if (!isNewBrowserPerTest) {
            if (status == null || status.equalsIgnoreCase("failed")) {
                LOGGER.info("Launching fresh browser");
                DriverManager.launchBrowser(ConfigManager.getBrowser());
            } else {
                LOGGER.info("Skip log in");
            }
        } else if (isCleanUpTest) {
            LOGGER.info("Clean up test. Skip log in");
        } else {
            DriverManager.launchBrowser(ConfigManager.getBrowser());
        }
    }


    @AfterMethod(alwaysRun = true)
    public void CloseBrowser(ITestResult result, ITestContext context) {
        if (!result.isSuccess()) {
            context.setAttribute("previousTestStatus", "failed");
        } else {
            context.setAttribute("previousTestStatus", "passed");
        }
        //   boolean isNewBrowserPerTest = Boolean.parseBoolean(ConfigManager.getConfigProperty("new.browser.per.test"));
        //   boolean isCleanUpTest = context.getName().contains("Clean");

        DriverManager.quitDriver();

    }


    @AfterTest(alwaysRun = true)
    public void afterTest() {
        DriverManager.quitDriver();
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        Helper.deleteAllFiles(".json", Constant.TARGET_DIR, "eventsExport");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        DriverManager.quitDriver();
        Helper.deleteAllFiles(".json", Constant.TARGET_DIR, "eventsExport");
    }


}

