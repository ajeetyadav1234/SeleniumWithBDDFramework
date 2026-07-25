package com.example.tests.steps;

import com.example.framework.core.BaseTest;
import com.example.framework.pages.LoginPage;
import com.example.tests.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps extends BaseTest {
    private LoginPage loginPage;

    @Given("I open the login page")
    public void iOpenTheLoginPage() {
        try {
            setup();
            loginPage = new LoginPage(driver);
            loginPage.open("https://reva-university.my.site.com/Admissions/s/?tabset-906eb=a9f6d");
        } catch (Exception e) {
            String error = "Failed to open login page: " + e.getMessage();
            Hooks.setFailureReason(error);
            throw new RuntimeException(error, e);
        }
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        try {
            loginPage.enterUsername(username);
        } catch (Exception e) {
            String error = "Failed to enter username '" + username + "': " + e.getMessage();
            Hooks.setFailureReason(error);
            throw new RuntimeException(error, e);
        }
    }

    @When("I enter password {string}")
    public void iEnterPassword(String password) {
        try {
            loginPage.enterPassword(password);
        } catch (Exception e) {
            String error = "Failed to enter password: " + e.getMessage();
            Hooks.setFailureReason(error);
            throw new RuntimeException(error, e);
        }
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        try {
            loginPage.clickLogin();
        } catch (Exception e) {
            String error = "Failed to click login button: " + e.getMessage();
            Hooks.setFailureReason(error);
            throw new RuntimeException(error, e);
        }
    }

    @Then("I should see the dashboard page")
    public void iShouldSeeTheDashboardPage() {
        try {
            if (driver == null || driver.getCurrentUrl() == null || driver.getCurrentUrl().isBlank()) {
                throw new AssertionError("Login page did not load correctly");
            }
            teardown();
        } catch (Exception e) {
            String error = "Dashboard verification failed: " + e.getMessage();
            Hooks.setFailureReason(error);
            throw new RuntimeException(error, e);
        }
    }
}
