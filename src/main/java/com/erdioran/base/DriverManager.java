package com.erdioran.base;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final InheritableThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new InheritableThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return WEB_DRIVER_THREAD_LOCAL.get();
    }

    public static void setDriver(WebDriver driver) {
        WEB_DRIVER_THREAD_LOCAL.set(driver);
    }

    public static void quitDriver() {
        if (WEB_DRIVER_THREAD_LOCAL.get() != null) {
            WEB_DRIVER_THREAD_LOCAL.get().quit();
        }
    }
}

