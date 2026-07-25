package com.example.framework.core;

import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    public void setup() {
        DriverManager.initDriver();
        this.driver = DriverManager.getDriver();
    }

    public void teardown() {
        DriverManager.quitDriver();
    }
}
