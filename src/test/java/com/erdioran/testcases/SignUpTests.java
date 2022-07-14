package com.erdioran.testcases;


import static com.erdioran.base.Common.signIn;
import static com.erdioran.base.Page.*;
import static com.erdioran.objectRepository.CommonOR.TOP_ACCOUNT_MENU;
import static com.erdioran.objectRepository.HomePageOR.*;
import static com.erdioran.objectRepository.SignUpOR.*;
import static com.erdioran.utils.DataManager.getData;

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


public class SignUpTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext context) {
        ExtentTest test = ExtentTestManager.getNode();
        test.assignCategory("SignUp Page");
    }


    @Test(description = "Name Empty", priority = 1)
    public void nameEmpty(ITestContext context) {


        signIn("", getData("signupLogin.mail"), getData("signupLogin.password"), getData("signupLogin.password"));

        Assert.assertTrue(DriverManager.getDriver().findElement(ERROR_MESSAGE_EMPTY_NAME).isDisplayed());
        Assert.assertEquals(getPageUrl(), getData("signupLogin.registerUrl"));
    }

    @Test(description = "Mail Empty", priority = 2)
    public void mailEmpty(ITestContext context) {


        signIn(getData("signupLogin.name"), getData(""), getData("signupLogin.password"), getData("signupLogin.password"));

        Assert.assertTrue(DriverManager.getDriver().findElement(ERROR_MESSAGE_EMPTY_MAIL).isDisplayed());
        Assert.assertEquals(getPageUrl(), getData("signupLogin.registerUrl"));
    }

    @Test(description = "Password Empty", priority = 3)
    public void passwordEmpty(ITestContext context) {


        signIn(getData("signupLogin.name"), getData("signupLogin.mail"), getData(""), getData(""));

        Assert.assertTrue(DriverManager.getDriver().findElement(ERROR_MESSAGE_EMPTY_PASSWORD).isDisplayed());
        Assert.assertEquals(getPageUrl(), getData("signupLogin.registerUrl"));
    }


    @Test(description = "Succes Create Account", priority = 4)
    public void successCreate(ITestContext context) {


        signIn("signupLogin.name", getData("signupLogin.mail"), getData("signupLogin.password"), getData("signupLogin.password"));


        if (DriverManager.getDriver().findElement(PUZZLE_CHECK).isDisplayed()) {

            // PUZZLE CHECK

            Assert.assertTrue(DriverManager.getDriver().findElement(SIGN_OUT_BUTTON).isDisplayed());
        } else if (DriverManager.getDriver().findElement(VERIFY_EMAIL).isDisplayed()) {

            // EMAUL VERIFICATION

            Assert.assertTrue(DriverManager.getDriver().findElement(SIGN_OUT_BUTTON).isDisplayed());
        } else {
            hoverToElement(TOP_ACCOUNT_MENU);
            Assert.assertTrue(DriverManager.getDriver().findElement(SIGN_OUT_BUTTON).isDisplayed());


        }

    }


}
