package com.erdioran.testcases;


import com.aventstack.extentreports.ExtentTest;
import com.erdioran.base.BaseTest;
import com.erdioran.base.DriverManager;
import com.erdioran.utils.ExtentTestManager;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.erdioran.base.Common.login;
import static com.erdioran.base.Page.getPageUrl;
import static com.erdioran.base.Page.hoverToElement;
import static com.erdioran.objectRepository.CommonOR.*;
import static com.erdioran.objectRepository.HomePageOR.*;
import static com.erdioran.objectRepository.LoginOR.*;
import static com.erdioran.objectRepository.SignUpOR.*;
import static com.erdioran.utils.DataManager.getData;


public class LoginTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext context) {
        ExtentTest test = ExtentTestManager.getNode();
        test.assignCategory("Login Page");
    }


    @Test(description = "Wrong Mail", priority = 1)
    public void wrongMail(ITestContext context) {


        try {
            login("testest111seewtewtw@gmail.com", getData("signupLogin.password"));
        } catch (Exception ignored) {}

        Assert.assertTrue(DriverManager.getDriver().findElement(ERROR_MESSAGE_MAIL_WRONG).isDisplayed());
    }

    @Test(description = "Empty Mail", priority = 2)
    public void emptyMail(ITestContext context) {

        try {
            login("", getData("signupLogin.password"));
        } catch (Exception ignored) {}
        Assert.assertTrue(DriverManager.getDriver().findElement(ERROR_MESSAGE_EMPTY_MAIL_LOGIN).isDisplayed());
    }

    @Test(description = "Wrong Password", priority = 3)
    public void wrongPassword(ITestContext context) {

        try {
            login(getData("signupLogin.mail"), "abc124aa");
        } catch (Exception ignored) {}
        Assert.assertTrue(DriverManager.getDriver().findElement(ERROR_MESSAGE_WRONG_PASSWORD).isDisplayed());
    }


    @Test(description = "Success Login", priority = 4)
    public void successLogin(ITestContext context) {


        login(getData("signupLogin.mail"), getData("signupLogin.password"));

        hoverToElement(TOP_ACCOUNT_MENU);
        Assert.assertTrue(DriverManager.getDriver().findElement(SIGN_OUT_BUTTON).isDisplayed());

    }


}
