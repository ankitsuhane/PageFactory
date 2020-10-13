package com.orgname.test.web.stepdefinitions;

import com.orgname.framework.web.BasePage;
import com.orgname.test.web.pagesactions.pages.ContinueToLoginPage;
import com.orgname.test.web.pagesactions.pages.HomePage;
import cucumber.api.java8.En;

import static org.junit.Assert.assertEquals;

public class TestStepDefinition extends BasePage implements En {

	public TestStepDefinition() {
		
		Given("I want to click onlinesbi link", () -> {
			CurrentPage = getInstance(HomePage.class);
			CurrentPage = CurrentPage.As(HomePage.class).login();
		});

		When("do nothing", () -> {
			CurrentPage.As(ContinueToLoginPage.class).clickLoginButton();
		});

		Then("do nothings", () -> {
			assertEquals(0, 0);
		});
	}
}