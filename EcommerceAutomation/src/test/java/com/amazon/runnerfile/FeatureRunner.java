package com.amazon.runnerfile;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        features ={"src/test/resources/com.amazon.featurefile/AmazonSearch.feature"},
        glue = {"/com/amazon/stepdefinition"},
        monochrome = true,
        tags = "@SearchBar",
        plugin = {"pretty", "html:target/AmazonReport",
                "json:test-output/jsonReport.json",
                "junit:test-output/junitReport.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class FeatureRunner {

}
