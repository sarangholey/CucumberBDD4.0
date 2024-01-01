package com.qa.automation.stepdefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.context.TestContext;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HealthCheck_StepDefs {
	
	private static final Logger logger = LogManager.getLogger(HealthCheck_StepDefs.class);

	WebDriver driver;
	TestContext testContext;
	WebDriverWait wait;
	String base_url = "https://automationexercise.com/";
	Scenario scn;

	public HealthCheck_StepDefs(TestContext testContext){
		this.testContext = testContext;
		driver = testContext.getDriver();
		wait = testContext.getWebDriverWait();
		scn = testContext.getScenario();
	}
	
	@Given("User navigated to the home application url")
	public void user_navigated_to_the_home_application_url() {
		driver.get(base_url);
		scn.log("Browser navigated to url :- " + base_url);
		logger.info("Browser navigated to url :- " + base_url);
	}

	@When("User is on application landing page")
	public void user_is_on_application_landing_page() {
		Assert.assertEquals(true, driver.getCurrentUrl().contains("automationexercise"));
		scn.log("Application url contains :- \"automationpractice\"");
		logger.info("Application url contains :- \"automationpractice\"");
	}
	@Then("Application url is redirected to {string}")
	public void application_url_is_redirected_to(String applicationExpectedUrl) {
		// Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(applicationExpectedUrl, driver.getCurrentUrl());
		scn.log("Application url is successfully redirected to :- " + driver.getCurrentUrl());
		logger.info("Application url is successfully redirected to :- " + driver.getCurrentUrl());
	}
	
	@Then("Application title is {string}")
	public void application_title_is(String applicationLandingPageTitle) {
		Assert.assertEquals(applicationLandingPageTitle, driver.getTitle());
		scn.log("Application title is found as :- " + driver.getTitle());
		logger.info("Application title is found as :- " + driver.getTitle());
	}

}
