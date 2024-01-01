package com.qa.automation.core;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
	private static WebDriver driver = null;

	public WebDriver getWebDriverForBrowser(String browser) throws Exception {
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			driver = new ChromeDriver();
			logger.info("Chrome Browser invoked");
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Firefox Browser invoked");
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			logger.info("Opera Browser invoked");
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Opera Browser invoked");
			break;
		case "headless":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
			logger.info("Headless Chrome Browser invoked");
			break;
		default:
			logger.fatal("No such browser is implemented.Browser name sent: " + browser);
			throw new Exception("No such browser is implemented.Browser name sent: " + browser);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Driver maximized and implicit time out set to 20 seconds");
		return driver;
	}

	public static void navigateToTheUrl(String url) {
		driver.get(url);
		logger.info("Browser navigated to the url: " + url);
	}

	public static void quitDriver() {
		driver.quit();
		logger.info("Driver closed");
	}

	public String getBrowserName() {
		String browserDefault = "chrome"; // Set by default
		String browserSentFromCmd = System.getProperty("browser");

		if (browserSentFromCmd == null) {
			return browserDefault;
		} else {
			return browserSentFromCmd;
		}
	}

}
