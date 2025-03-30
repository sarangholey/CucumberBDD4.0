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

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Products_StepDefs {

	private static final Logger logger = LogManager.getLogger(Products_StepDefs.class);

	WebDriver driver;
	TestContext testContext;
	WebDriverWait wait;
	String base_url = "https://automationexercise.com/";
	Scenario scn;

	public Products_StepDefs(TestContext testContext) {
		this.testContext = testContext;
		driver = testContext.getDriver();
		wait = testContext.getWebDriverWait();
		scn = testContext.getScenario();
	}

	@When("user header over to products page")
	public void user_header_over_to_products_page() {
		driver.navigate().to(base_url + "/products");
	}

	@When("user redirected to products page with title as {string}")
	public void user_redirected_to_products_page_with_title_as(String pageTitle) {
		wait.until(ExpectedConditions.titleContains(pageTitle));
		Assert.assertEquals(pageTitle, driver.getTitle());
	}

	@When("url for the login page contains the {string} as keyword")
	public void url_for_the_login_page_contains_the_as_keyword(String keywordInUrl) {
		wait.until(ExpectedConditions.urlContains(keywordInUrl));
		Assert.assertEquals(true, driver.getCurrentUrl().contains(keywordInUrl));
	}

	@When("user search for a product {string}")
	public void user_search_for_a_product(String productName) {
		WebElement productSearchBoxEle = driver.findElement(By.xpath("//input[@id='search_product']"));
		productSearchBoxEle.sendKeys(productName);
	}

	@When("click on search button")
	public void click_on_search_button() {
		WebElement productSearchBtnEle = driver.findElement(By.xpath("//button[@id='submit_search']"));
		productSearchBtnEle.click();
	}

	@Then("from the product list the first product contain the {string} as keyword")
	public void from_the_product_list_the_first_product_contain_the_as_keyword(String productNameKeyowrd) {
		List<WebElement> searchedProdListEle = driver
				.findElements(By.xpath("//div[@class='features_items']//div[@class='productinfo text-center']/p"));
		Assert.assertEquals(true, searchedProdListEle.get(0).getText().contains(productNameKeyowrd));
	}
	
	@When("User search following product from search box and add into cart")
	public void user_search_following_product_from_search_box_and_add_into_cart(List<Map<String,String>> cartDataTable) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    // For other transformations you can register a DataTableType.
		for (int i=0; i<cartDataTable.size();i++) {
			searchAndAddProduct(cartDataTable, i);
		}	
	}
	
	public void searchAndAddProduct(List<Map<String,String>> data, int index) throws InterruptedException
	{
		String itemName = data.get(index).get("ITEM");
		String productName = data.get(index).get("PRODUCT_NAME");
        int productQuantity = Integer.parseInt(data.get(index).get("QUANTITY"));
        System.out.println("----------------------");
        System.out.println((index+1) + " Item Name : " + itemName + " Product Name : " + productName + " product quantity : " + productQuantity);
        System.out.println("----------------------");
        
	}
	
	@Then("User cart is updated with the products and quantity")
	public void user_cart_is_updated_with_the_products_and_quantity() {
	    // Yet to be implimented
	}
}
