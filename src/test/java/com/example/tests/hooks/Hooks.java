package com.example.tests.hooks;

import com.example.framework.core.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private static String failureReason = "";

    @Before
    public void beforeScenario(Scenario scenario) {
        failureReason = "";
        System.out.println("Starting scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String reason = failureReason.isBlank() ? "Unknown failure" : failureReason;
            System.out.println("FAILED STEP: " + scenario.getName());
            System.out.println("Failure reason: " + reason);
        }
        DriverManager.quitDriver();
    }

    public static void setFailureReason(String reason) {
        failureReason = reason;
    }
}
