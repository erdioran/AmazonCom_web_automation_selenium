package com.erdioran.testcases;


import com.aventstack.extentreports.ExtentTest;
import com.erdioran.base.BaseTest;
import com.erdioran.utils.ExtentTestManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class SearchBarTests extends BaseTest {

    public static final Logger LOGGER = LogManager.getLogger(SearchBarTests.class);

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext context) {
        ExtentTest test = ExtentTestManager.getNode();
        test.assignCategory("Search Bar");
    }




}
