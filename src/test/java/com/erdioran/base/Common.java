package com.erdioran.base;

import com.erdioran.utils.Helper;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

import static com.erdioran.objectRepository.CommonOR.*;
import static com.erdioran.objectRepository.LoginOR.*;
import static com.erdioran.objectRepository.SignUpOR.*;
import static com.erdioran.utils.DataManager.getData;

public class Common extends Page {

    private static final Logger LOGGER = LogManager.getLogger(Common.class);

    public static void login() {
        login(getData("signupLogin.mail"), getData("signupLogin.password"));
    }

    public static void login(String mail, String password) {
        LOGGER.info("Logging into Amazon.com");
        WebDriver driver = DriverManager.getDriver();
        try {
            driver.get(getData("signupLogin.loginUrl"));
            Helper.sleepInSeconds(5);
        } catch (Exception e) {
            LOGGER.info("Page failed to load. Trying again");
            driver.navigate().refresh();
        }

        enterCredentialsStepMail(mail);
        click(LOGIN_BUTTON_CONTINUE);

        enterCredentialsStepPassword(password);
        click(LOGIN_BUTTON_SUBMIT);


    }

    public static void signIn() {
        signIn(getData("signupLogin.name"), getData("signupLogin.mail"), getData("signupLogin.password"),getData("signupLogin.password"));
    }

    public static void signIn(String name, String mail, String password,String rePassword) {
        LOGGER.info("Sign up page");
        WebDriver driver = DriverManager.getDriver();
        try {
            driver.get(getData("signupLogin.registerUrl"));
            Helper.sleepInSeconds(5);
        } catch (Exception e) {
            LOGGER.info("Page failed to load. Trying again");
            driver.navigate().refresh();
        }

        signInCredentials(name, mail, password,rePassword);
        click(SIGN_UP_BUTTON_CONTINUE);


    }

    public static void signInCredentials(String name, String mail, String password,String rePassword) {
        enterText(SIGN_UP_NAME, name);
        enterText(SIGN_UP_MAIL, mail);
        enterText(SIGN_UP_PASSWORD, password);
        enterText(SIGN_UP_PASSWORD_CHECK, rePassword);
    }


    public static boolean findUserName() {
        boolean displayed = DriverManager.getDriver().findElement(By.xpath("//span[normalize-space()='" + getData("signupLogin.name") + " " + getData("signupLogin.surname") + "']")).isDisplayed();
        return displayed;
    }


    public static void openPageInAccountTab(String pagename) {
        hoverToElement(TOP_ACCOUNT_MENU);
        click(By.xpath("//span[normalize-space()='" + pagename + "']"));

        //or href
    }



    public static void enterCredentialsStepMail(String mail) {
        enterText(LOGIN_MAIL, mail);
    }

    public static void enterCredentialsStepPassword(String password) {
        enterText(LOGIN_PASSWORD, password);
    }

}
