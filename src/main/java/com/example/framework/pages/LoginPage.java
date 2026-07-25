package com.example.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void enterUsername(String username) {
        typeIfPresent(By.id("username"), username);
        typeIfPresent(By.name("username"), username);
        typeIfPresent(By.id("email"), username);
    }

    public void enterPassword(String password) {
        typeIfPresent(By.id("password"), password);
        typeIfPresent(By.name("password"), password);
    }

    public void clickLogin() {
        clickIfPresent(By.id("login"));
        clickIfPresent(By.name("login"));
        clickIfPresent(By.cssSelector("button[type='submit']"));
    }

    private void typeIfPresent(By locator, String value) {
        List<WebElement> elements = driver.findElements(locator);
        if (!elements.isEmpty()) {
            elements.get(0).sendKeys(value);
        }
    }

    private void clickIfPresent(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        if (!elements.isEmpty()) {
            elements.get(0).click();
        }
    }
}
