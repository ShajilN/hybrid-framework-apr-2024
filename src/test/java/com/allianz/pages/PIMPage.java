package com.allianz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.allianz.base.WebDriverKeywords;

public class PIMPage extends WebDriverKeywords {

	private By addEmployeeLocator = By.linkText("Add Employee");
	private By insertImageLocator = By.xpath("//input[@type='file']");
	private By errorTextLocator = By.xpath("//span[contains(@class,'error-message')]");

	private WebDriver driver;

	public PIMPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
	}

	public void clickOnAddEmployee() {

		clickElement(addEmployeeLocator);
	}

	public void inputText(String text) {

		setInputText(insertImageLocator, text);
	}

	public String getInvalidErrorMessage() {

//		return driver.findElement(errorTextLocator).getText();
		return getText(errorTextLocator);

	}
}
