package com.qa.automation.stepdefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.context.TestContext;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSignInRegister_StepDefs {

	private static final Logger logger = LogManager.getLogger(UserSignInRegister_StepDefs.class);

	WebDriver driver;
	TestContext testContext;
	WebDriverWait wait;
	String base_url = "https://automationexercise.com/";
	Scenario scn;

	public UserSignInRegister_StepDefs(TestContext testContext) {
		this.testContext = testContext;
		driver = testContext.getDriver();
		wait = testContext.getWebDriverWait();
		scn = testContext.getScenario();
	}

	@When("User click on signup\\/login button")
	public void user_click_on_signup_login_button() {
		driver.get(base_url);
		WebElement signupBtnEle = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
		signupBtnEle.click();
		logger.info("user click on signup/login button");
	}

	@When("User redirect to the signup\\/login page with title as {string}")
	public void user_redirect_to_the_signup_login_page_with_title_as(String signUpPageTitle) {
		Assert.assertEquals(true, driver.getTitle().contains(signUpPageTitle));
		scn.log("user verify signup page title" + " - " + signUpPageTitle);
		logger.info("user verify the signup page title");
	}

	@When("user able to see {string} section on login page")
	public void user_able_to_see_section_on_login_page(String loginToAcc) {
		WebElement loginToAccTextEle = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
		Assert.assertEquals(loginToAcc, loginToAccTextEle.getText());
		scn.log("user able to see " + loginToAcc + "on login page");
		logger.info("user able to see " + loginToAcc + "on login page");
		scn.log("user able to see " + loginToAcc + "on login page");
		logger.info("user able to see " + loginToAcc + "on login page");
	}

	@When("User enter {string} and {string}")
	public void user_enter_and(String EmailId, String Password) {
		WebElement EmailIdEle = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		EmailIdEle.sendKeys(EmailId);

		WebElement passwordEle = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
		passwordEle.sendKeys(Password);
		scn.log("user enter email and password - " + EmailId + " , " + Password);
		logger.info("user enter email and password - " + EmailId + " , " + Password);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		WebElement loginBtnEle = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
		loginBtnEle.click();
		logger.info("user click on login button");
	}

	@Then("User verify the error message {string}")
	public void user_verify_the_error_message(String errorMsg) {
		WebElement errorMsgEle = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
		Assert.assertEquals(errorMsg, errorMsgEle.getText());
		scn.log("user verify error msg - " + errorMsg);
		logger.info("user verify error msg - " + errorMsg);
	}

	@When("User enter valid {string} and {string} for login")
	public void user_enter_valid_and_for_login(String ValidEmailId, String ValidPassword) {
		WebElement EmailIdEle = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		EmailIdEle.sendKeys(ValidEmailId);

		WebElement passwordEle = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
		passwordEle.sendKeys(ValidPassword);
		scn.log("user enter valid email and password- " + ValidEmailId + " , " + ValidPassword);
		logger.info("user enter valid email and password- " + ValidEmailId + " , " + ValidPassword);
	}

	@Then("User verify with {string} just after Logged in as button")
	public void user_verify_with_just_after_logged_in_as_button(String username) {
		WebElement loggedInUserNameTxtEle = driver.findElement(By.xpath("//a[text()= ' Logged in as ']/b"));
		Assert.assertEquals(username, loggedInUserNameTxtEle.getText());
		scn.log("user verify username after logged in - " + username);
		logger.info("user verify username after logged in - " + username);
	}

	@Then("User click on logout button")
	public void user_click_on_logout_button() {
		WebElement logoutBtnEle = driver.findElement(By.xpath("//a[text()=' Logout']"));
		logoutBtnEle.click();
		logger.info("user click on logout button");
	}

	@Given("user navigate to the home application url")
	public void user_navigate_to_the_home_application_url() {
		driver.get(base_url);
	}

	@When("url for the login page contains {string} as keyword")
	public void url_for_the_login_page_contains_as_keyword(String loginPageUrlKeyword) {
		wait.until(ExpectedConditions.urlContains(loginPageUrlKeyword));
		Assert.assertEquals(true, driver.getCurrentUrl().contains(loginPageUrlKeyword));
	}

	@When("user enters valid registered email id as {string}")
	public void user_enters_valid_registered_email_id_as(String userRegEmailIDtxt) {
		WebElement loginEmailIdFieldEle = driver
				.findElement(By.xpath("//input[@placeholder='Email Address' and @data-qa='login-email']"));
		loginEmailIdFieldEle.sendKeys(userRegEmailIDtxt);
	}

	@When("user enters valid password as {string}")
	public void user_enters_valid_password_as(String userRegPasswordtxt) {
		WebElement loginPasswordFieldEle = driver
				.findElement(By.xpath("//input[@placeholder='Password' and @data-qa='login-password']"));
		loginPasswordFieldEle.sendKeys(userRegPasswordtxt);
	}
	
	@When("click on login button")
	public void click_on_login_button() {
		WebElement loginButtonEle = driver.findElement(By.xpath("//button[text()='Login']"));
		loginButtonEle.click();
	}
	
	@Then("after login user able to see {string} button at top header of application")
	public void after_login_user_able_to_see_button_at_top_header_of_application(String logoutButtontext) {
		WebElement logoutButtonEle = driver.findElement(By.xpath("//a[text()=' Logout']"));
		Assert.assertEquals(logoutButtontext, logoutButtonEle.getText().trim());
	}
	
	@Then("user is able to see {string} button at top header section of application")
	public void user_is_able_to_see_button_at_top_header_section_of_application(String deleteAccountButtontext) {
		    	WebElement deleteAccButtonEle = driver.findElement(By.xpath("//a[text()=' Delete Account']"));
		Assert.assertEquals(deleteAccountButtontext, deleteAccButtonEle.getText().trim());
	}
	
	@Then("with {string} as user name just after Logged in as button")
	public void with_as_user_name_just_after_logged_in_as_button(String loggedInUserName) {
		WebElement loggedInUserNameTxtEle = driver.findElement(By.xpath("//a[text()= ' Logged in as ']/b"));
		Assert.assertEquals(loggedInUserName, loggedInUserNameTxtEle.getText().trim());
	}

}
