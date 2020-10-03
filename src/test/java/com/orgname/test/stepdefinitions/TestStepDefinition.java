package com.orgname.test.stepdefinitions;

import com.orgname.test.web.pagesactions.actions.HomePageAction;
import com.orgname.test.web.pagesactions.pages.HomePage;
import com.orgname.test.web.pagesactions.pages.TestOnly;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import static org.junit.Assert.assertEquals;

public class TestStepDefinition implements En {

	@Lazy
	@Autowired
	HomePageAction homePageAction;

	@Lazy
	@Autowired
	HomePage homePage;

	@Lazy
	@Autowired
	TestOnly testOnly;

	public TestStepDefinition() {
		
		Given("I want to click onlinesbi link", () -> {
			homePageAction.login();
		});

		When("do nothing", () -> {
			System.out.println("do nothing:" );
			testOnly.loginClick();
		});

		Then("do nothings", () -> {
			assertEquals(0, 0);
		});
	}
}
