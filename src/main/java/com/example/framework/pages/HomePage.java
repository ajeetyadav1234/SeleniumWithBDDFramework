package com.example.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final By searchBox = By.name("q");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void searchFor(String text) {
        driver.findElement(searchBox).sendKeys(text);
    }
}
