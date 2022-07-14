package com.erdioran.objectRepository;

import org.openqa.selenium.By;

public class LoginOR {

    public static final By LOGIN_BUTTON_CONTINUE = By.xpath("//input[@id='continue']");
    public static final By LOGIN_MAIL = By.id("ap_email");
    public static final By LOGIN_BUTTON_SUBMIT = By.id("signInSubmit");
    public static final By LOGIN_PASSWORD = By.id("ap_password");


    // ERROR MESSAGES
    public static final By ERROR_MESSAGE_MAIL_WRONG = By.xpath("//h4[normalize-space()='There was a problem']");
    public static final By ERROR_MESSAGE_EMPTY_MAIL_LOGIN = By.xpath("//div[contains(text(),'Enter your email or mobile phone number')]");
    public static final By ERROR_MESSAGE_WRONG_PASSWORD = By.xpath("//h4[normalize-space()='There was a problem']");




}
