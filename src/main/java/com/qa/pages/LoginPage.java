package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By SignBtn = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}


	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickLoginBtn() {
		driver.findElement(SignBtn).click();
	}

	public AccountsPage doLogin(String un, String pwd) {
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(SignBtn).click();


		return new AccountsPage(driver);

	}









}
