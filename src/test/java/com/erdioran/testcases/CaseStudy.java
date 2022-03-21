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

        ExtentTest test = ExtentTestManager.getNode();
        test.info("case1: Searh product -> order of insertion  -> ....");

        // Verify home page
        Assert.assertEquals(HOME_URL, getPageUrl());

        //WAİT KOY BURAYA
        click(ACCEPT_COOKIES);

        click(SEARCH_BAR);
        enterText(SEARCH_BAR, DataManager.getData("data.product_search"));
        click(SEARCH_BAR_SUBMIT_BUTTON);

        click(SORT_BY_BUTTON);
        click(NEWEST_ARRIVALS_BUTTON);

        System.out.println("The price of the last product whose price is displayed: " + getText(PRICE_OF_THE_FIRST_PRODUCT_ON_THE_PAGE));

        // Verify displayed
        Assert.assertNotEquals(null, getText(PRICE_OF_THE_FIRST_PRODUCT_ON_THE_PAGE),"There is at least one list price on the page.");


    }


}
