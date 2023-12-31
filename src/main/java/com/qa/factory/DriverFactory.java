package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


	public WebDriver init_driver(String browser) {

		System.out.println("browser value is: " + browser);

		if(browser.equals("chrome")) {
			tlDriver.set(new ChromeDriver());
		} 

		else if(browser.equals("firefox")) {
			tlDriver.set(new FirefoxDriver());
		} 
		else {
			System.out.println("Please pass the Correct Broswer Value : " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	public static synchronized  WebDriver getDriver() {
		return tlDriver.get();

	}












}
