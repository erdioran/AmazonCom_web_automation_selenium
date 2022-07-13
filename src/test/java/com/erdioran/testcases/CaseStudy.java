package com.erdioran.testcases;


import static com.erdioran.base.Page.*;
import static com.erdioran.objectRepository.HomePageOR.*;

import com.aventstack.extentreports.ExtentTest;
import com.erdioran.base.BaseTest;
import com.erdioran.base.DriverManager;
import com.erdioran.utils.DataManager;
import com.erdioran.utils.ExtentTestManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CaseStudy extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext context) {
        ExtentTest test = ExtentTestManager.getNode();
        test.assignCategory("Login Page");
    }


    @Test(description = "case1", priority = 1)
    public void case1(ITestContext context) {


    }


}
