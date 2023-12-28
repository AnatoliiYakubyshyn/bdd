package com.yakubt.carina.demo;

import io.cucumber.testng.CucumberOptions;

import com.zebrunner.carina.cucumber.CucumberBaseTest;

@CucumberOptions(features = "src/test/resources/features/sauceDemo.feature",
        glue = "com.yakubt.carina.demo.cucumber.steps",
        plugin = {"pretty",
                "html:target/cucumber-core-test-report",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"}
)
public class BddTest extends CucumberBaseTest {


}
