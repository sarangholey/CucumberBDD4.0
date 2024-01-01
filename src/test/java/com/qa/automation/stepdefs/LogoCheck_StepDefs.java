package com.qa.automation.stepdefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.context.TestContext;

import io.cucumber.java.en.Then;

public class LogoCheck_StepDefs {
	
	private static final Logger logger = LogManager.getLogger(LogoCheck_StepDefs.class);

	WebDriver driver;
	WebDriverWait wait;
	TestContext testContext;


	public LogoCheck_StepDefs(TestContext testContext){
		this.testContext = testContext;
		driver = testContext.getDriver();
		wait = testContext.getWebDriverWait();
	}
	
	@Then("Application logo is displayed")
	public void application_logo_is_displayed() {
	    Assert.assertEquals(true, driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
	}

}
