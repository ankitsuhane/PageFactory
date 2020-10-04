package com.orgname.test.web.testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber-reports/Cucumber2.json"}, 
		features = "src/test/java/com/orgname/test/web/features",
		glue = "com.orgname.test.web.stepdefinitions",
		//dryRun=true,
				//tags = {"@SmokeTest or @RegressionTest"})
		monochrome=true)

public class TestRunner {
}
