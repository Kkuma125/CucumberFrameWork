package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

	private WebDriver driver;

	private By subjectHeading = By.id("id_contact");
	private By email = By.id("email");
	private By orderRef = By.name("id_order");
	private By button = By.id("submitMessage");
	private By message = By.xpath("//textarea[@id='message']");
	private By sucesMesag = By.cssSelector("div#center_column p");


	public ContactUsPage(WebDriver driver) {
		this.driver = driver;

	}	

	public String getContactUsPageTitle() {
		return driver.getTitle();
	}

	public void fillContactUsForm(String heading, String emailId, String OrderRef, String Message) {
		Select select = new Select(driver.findElement(subjectHeading));
		select.selectByVisibleText(heading);
		driver.findElement(email).sendKeys(emailId);
		driver.findElement(orderRef).sendKeys(OrderRef);
		driver.findElement(message).sendKeys(Message);

	}

	public void clickSend() {
		driver.findElement(button).click();
	}

	public String getSuccessMessage() {
		return driver.findElement(sucesMesag).getText();
	}


}
