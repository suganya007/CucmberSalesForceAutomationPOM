package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty", "html:target/cucmber-reports/cucumber.html",
							"json:target/cucmber-reports/cucumber.json"},
				features = {"src/test/resources/features/SalesForceFeature.feature"},
				glue = {"com.steps"})

public class Runner extends AbstractTestNGCucumberTests{

}
