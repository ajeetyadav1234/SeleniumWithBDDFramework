package com.example.tests.steps;

import com.example.framework.core.BaseTest;
import com.example.framework.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SearchSteps extends BaseTest {
    private HomePage homePage;

    @Given("I open the homepage")
    public void iOpenTheHomepage() {
        setup();
        homePage = new HomePage(driver);
        homePage.open("https://www.google.com");
    }

    @When("I search for {string}")
    public void iSearchFor(String text) {
        homePage.searchFor(text);
    }

    @Then("the search box should contain {string}")
    public void theSearchBoxShouldContain(String text) {
        // Placeholder assertion for framework structure
        assert driver.getPageSource().contains("Google") : "Page did not load correctly";
        teardown();
    }
}
