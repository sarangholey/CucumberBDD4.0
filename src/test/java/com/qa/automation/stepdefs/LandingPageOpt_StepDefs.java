package com.qa.automation.stepdefs;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.context.TestContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LandingPageOpt_StepDefs {

	private static final Logger logger = LogManager.getLogger(LandingPageOpt_StepDefs.class);

	WebDriver driver;
	TestContext testContext;
	WebDriverWait wait;
	String base_url = "https://automationexercise.com/";
	Scenario scn;

	public LandingPageOpt_StepDefs(TestContext testContext) {
		this.testContext = testContext;
		driver = testContext.getDriver();
		wait = testContext.getWebDriverWait();
		scn = testContext.getScenario();
	}

	@Given("user navigated to landing pag of the application with current url as {string}")
	public void user_navigated_to_landing_pag_of_the_application_with_current_url_as(String currentUrlValue) {
		driver.get(base_url);
		Assert.assertEquals(currentUrlValue, driver.getCurrentUrl());
	}

	@When("the entire header section is visible")
	public void the_entire_header_section_is_visible() {
		WebElement headerSecNavBarEle = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']"));
		Assert.assertEquals(true, headerSecNavBarEle.isDisplayed());
	}

	@Then("following options are available under the header section")
	public void following_options_are_available_under_the_header_section(List<String> headerSecNamesList) {
		List<String> headerSecNamesListEle = headerSecNamesList;
		List<WebElement> actBrandCategoryListEle = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li/a"));
		for (int i = 0; i < headerSecNamesListEle.size(); i++) {
			Assert.assertEquals(true,
					actBrandCategoryListEle.get(i).getText().trim().contains(headerSecNamesListEle.get(i).trim()));
			// Assert.assertEquals(headerSecNamesList.get(i),
			// actBrandCategoryListEle.get(i).getText());
		}
	}

	@Then("following options are available under the header sections")
	public void following_options_are_available_under_the_header_sections(DataTable dataTable) {
		List<Map<String, String>> headerSecList = dataTable.asMaps(String.class, String.class);
		for (int i = 0; i < headerSecList.size(); i++) {
			System.out.println(headerSecList.get(i).get("HeaderLinkTxt"));
			System.out.println(headerSecList.get(i).get("HeaderLinkRedirectionPageTitle"));
		}
	}

	@Given("User Click on product button")
	public void user_click_on_product_button() {
		driver.get(base_url);
		;
		WebElement prodBtnEle = driver.findElement(By.xpath("//a[text()=' Products']"));
		wait.until(ExpectedConditions.visibilityOf(prodBtnEle));
		prodBtnEle.click();
	}

	@When("User redirected to product page with title as {string}")
	public void user_redirected_to_product_page_with_title_as(String prodPageTitle) {
		Assert.assertEquals(true, driver.getTitle().contains(prodPageTitle));
		scn.log("user verify product page title" + " - " + prodPageTitle);
		logger.info("user verify the product page title");
	}

	@When("User click on cart button")
	public void user_click_on_cart_button() {
		WebElement cartBtnEle = driver.findElement(By.xpath("//a[text()=' Cart']"));
		wait.until(ExpectedConditions.visibilityOf(cartBtnEle));
		cartBtnEle.click();
		logger.info("user click on cart button");
	}

	@When("User redirected to cart page with title as {string}")
	public void user_redirected_to_cart_page_with_title_as(String cartPageTitle) {
		Assert.assertEquals(true, driver.getTitle().contains(cartPageTitle));
		scn.log("user verify cart page title" + " - " + cartPageTitle);
		logger.info("user verify the cart page title");
	}

//	@When("User click on signup\\/login button")
//	public void user_click_on_signup_login_button() {
//		driver.get(base_url);
//		WebElement signupBtnEle = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
//		signupBtnEle.click();
//		logger.info("user click on signup/login button");
//	}

//	@When("User redirect to the signup\\/login page with title as {string}")
//	public void user_redirect_to_the_signup_login_page_with_title_as(String signUpPageTitle) {
//		Assert.assertEquals(true, driver.getTitle().contains(signUpPageTitle));
//		scn.log("user verify signup page title" + " - " + signUpPageTitle);
//		logger.info("user verify the signup page title");
//	}

	@When("User Click on test cases button")
	public void user_click_on_test_cases_button() {
		WebElement testCasesBtnEle = driver.findElement(By.xpath("//a[text()=' Test Cases']"));
		testCasesBtnEle.click();
		logger.info("user click on test cases button");
	}

	@Then("User verify Test page url {string}")
	public void user_verify_test_page_url(String testCasePageURL) {
		Assert.assertEquals(true, driver.getTitle().contains(testCasePageURL));
		scn.log("user verify the test case page url" + " - " + testCasePageURL);
		logger.info("user verify the test cases page url");
	}

	@When("User click on API Testing button")
	public void user_click_on_api_testing_button() {
		WebElement APITestingBtnEle = driver.findElement(By.xpath("//a[text()=' API Testing']"));
		APITestingBtnEle.click();
		logger.info("user click on API testing button");
	}

	@Then("User verify {string} text is visible")
	public void user_verify_text_is_visible(String apiTestingList) {
		WebElement apiListEle = driver.findElement(By.xpath("//b[text()='APIs List for practice']"));
		Assert.assertEquals(apiTestingList, apiListEle.getText());
		scn.log("user verify" + apiTestingList + "text is available");
		logger.info("user verify" + apiTestingList + "text is available");
	}

	@When("User cilck on Video Tutorials button")
	public void user_cilck_on_video_tutorials_button() {
		WebElement VideoTutorialBtnEle = driver.findElement(By.xpath("//a[text()=' Video Tutorials']"));
		VideoTutorialBtnEle.click();
		logger.info("user click on video tutorial button");

	}

	@When("User redirected to you tube video page with url as  {string}")
	public void user_redirected_to_you_tube_video_page_with_url_as(String videoTutorialPageUrl) {
		Assert.assertEquals(true, driver.getCurrentUrl().contains(videoTutorialPageUrl));
		logger.info("user verify you tube video page title");
	}

	@When("User click on contact us button of the header section")
	public void user_click_on_contact_us_button_of_the_header_section() {
		WebElement ContactUsBtnEle = driver.findElement(By.xpath(" //a[text()=' Contact us']"));
		ContactUsBtnEle.click();
		logger.info("user click on contact us button");
	}

	@Then("User verify the page title {string}")
	public void user_verify_the_page_title(String contactUsPageTitle) {
		Assert.assertEquals(true, driver.getTitle().contains(contactUsPageTitle));
		scn.log("user verify contact us page title" + " - " + contactUsPageTitle);
		logger.info("user verify contact us page title");
	}
	
	@When("user is able to see {string} header")
	public void user_is_able_to_see_header(String categoryStringValue) {
		WebElement categoryStringEle = driver.findElement(By.xpath("//h2[text()='Category']"));
		Assert.assertEquals(categoryStringValue, categoryStringEle.getText());
	}
	
	@Then("under Category below list is displayed")
	public void under_Category_below_list_is_displayed(List<String> brandCategoryNameList) {
	    List<String> expectedbrandCategoryList = brandCategoryNameList;
	    List<WebElement> actBrandCategoryListEle = driver.findElements(By.xpath("//div[@id='accordian']//div[@class='panel-heading']//a"));
	    for (int i = 0; i < expectedbrandCategoryList.size(); i++) {
	    	//System.out.println(actBrandCategoryListEle.get(i).getText());
	    	Assert.assertEquals(expectedbrandCategoryList.get(i), actBrandCategoryListEle.get(i).getText());
		}
	}

}
