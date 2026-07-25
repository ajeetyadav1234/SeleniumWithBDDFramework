package com.example.tests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = {"com.example.tests.steps", "com.example.tests.hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-report.json",
                "rerun:target/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true)
    public void setupFeaturePath(ITestContext context) {
        String configuredFeature = context.getCurrentXmlTest().getParameter("cucumber.features");
        if (configuredFeature != null && !configuredFeature.isBlank()) {
            System.setProperty("cucumber.features", configuredFeature);
        }
    }
}
