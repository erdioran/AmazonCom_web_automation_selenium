package com.erdioran.objectRepository;

import org.openqa.selenium.By;


public class SignUpOR {


    public static final By SIGN_UP_BUTTON_CONTINUE = By.id("continue");
    public static final By SIGN_UP_NAME = By.id("ap_customer_name");
    public static final By SIGN_UP_MAIL = By.id("ap_email");
    public static final By SIGN_UP_PASSWORD = By.id("ap_password");
    public static final By SIGN_UP_PASSWORD_CHECK = By.id("ap_password_check");

    // ERROR MESSAGES
    public static final By ERROR_MESSAGE_EMPTY_NAME = By.xpath("//div[contains(text(),'Enter your name')]");
    public static final By ERROR_MESSAGE_EMPTY_MAIL = By.xpath("//div[contains(text(),'Enter your email or mobile phone number')]");
    public static final By ERROR_MESSAGE_EMPTY_PASSWORD = By.xpath("//div[@id='auth-password-missing-alert']//div[@class='a-alert-content'][normalize-space()='Minimum 6 characters required']");


    //
    public static final By PUZZLE_CHECK= By.xpath("(//div[@class='a-row a-spacing-mini'])[1]");

    public static final By VERIFY_EMAIL= By.xpath("//h1[normalize-space()='Verify email address']");
}
