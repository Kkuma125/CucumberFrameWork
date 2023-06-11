package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;

	private By accountsSectionList = By.cssSelector("div#center_column span");


	public AccountsPage(WebDriver driver) {
		this.driver = driver;

	}

	public String getAccountsPageTitle() {
		return driver.getTitle();
	}

	public int getAccountsSectionCount() {
		return driver.findElements(accountsSectionList).size();
	}

	public List<String> getAccountsSectionList() {

		List<String> accountsList = new ArrayList<>();

		List<WebElement> accoutnsHeadersList = driver.findElements(accountsSectionList);

		for(WebElement e : accoutnsHeadersList) {
			String text = e.getText();
			System.out.println(text);
			accountsList.add(text);
		}

		return accountsList;

	}

}
