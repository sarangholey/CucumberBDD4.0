package com.qa.automation.stepdefs;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.context.TestContext;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoCheck_StepDefs {

	private static final Logger logger = LogManager.getLogger(LogoCheck_StepDefs.class);

	WebDriver driver;
	WebDriverWait wait;
	TestContext testContext;
	String base_url = "https://automationexercise.com/";
	Scenario scn;

	public LogoCheck_StepDefs(TestContext testContext) {
		this.testContext = testContext;
		driver = testContext.getDriver();
		wait = testContext.getWebDriverWait();
		scn = testContext.getScenario();
	}

	@Then("Application logo is displayed")
	public void application_logo_is_displayed() {
		Assert.assertEquals(true,
				driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
	}

	@When("all images on landing page loaded with {string} status code")
	public void all_images_on_landing_page_loaded_with_status_code(String imagesStatusCode) {
		
		int imgStatusCode = Integer.parseInt(imagesStatusCode);

		List<WebElement> linkListWithImgTag = driver.findElements(By.tagName("img"));

		System.out.println("Total image tag found on landing page with in the webpage URL as -> " + base_url + " is "
				+ linkListWithImgTag.size());
		scn.log("Total image tag found on landing page with in the webpage URL as -> " + base_url + " is "
				+ linkListWithImgTag.size());
		logger.info("Total image tag found on landing page with in the webpage URL as -> " + base_url + " is "
				+ linkListWithImgTag.size());

		for (int i = 0; i < linkListWithImgTag.size(); i++) {
			String imageSourceLink = linkListWithImgTag.get(i).getAttribute("src");

			try {
				// Creating a URL
				URL url = new URL(imageSourceLink);
				// Creating a connection with URL
				URLConnection urlConnection = url.openConnection();
				// Setting up the connection protocol as HTTP or HTTPS
				// ex -> HttpsURLConnection httpURLConnection = (HttpsURLConnection)
				// urlConnection;
				HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
				// Setting up connection timeout
				httpURLConnection.setConnectTimeout(4000);
				// Connecting with the url with HTTP protocol
				httpURLConnection.connect();
				// Validating the response from the URL in the form of HTTP response code
				if (httpURLConnection.getResponseCode() == imgStatusCode) {
					System.out.println("The Image Source Link " + imageSourceLink + " -> is "
							+ httpURLConnection.getResponseCode());
				} else {
					System.err.println("The Image Source Link " + imageSourceLink + " -> is "
							+ httpURLConnection.getResponseCode());
				}
				// disconnecting the connection with URL
				httpURLConnection.disconnect();
			} catch (Exception e) {
				System.out.println("Some issue with image source link ->" + imageSourceLink);
				scn.log("Some issue with image source link ->" + imageSourceLink);
				logger.info("Some issue with image source link ->" + imageSourceLink);
				e.printStackTrace();
			}
		}
	}

}
