package com.allianz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.allianz.base.WebDriverKeywords;

public class LoginPage extends WebDriverKeywords {

	private By usernameLocator = By.name("username");
	private By passwordLocator = By.name("password");
	private By loginLocator = By.xpath("//button[normalize-space()='Login']");
	private By errorTextLocator = By.xpath("//p[contains(@class,'alert-content-text')]");

	private WebDriver driver;

	public LoginPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
	}

	public void enterUsername(String username) {
//		driver.findElement(usernameLocator).sendKeys(username);
		super.setInputText(usernameLocator, username);
	}

	public void enterPassword(String password) {
//		driver.findElement(passwordLocator).sendKeys(password);
		setInputText(passwordLocator, password);
	}

	public void clickOnLogin() {
//		driver.findElement(loginLocator).click();
		clickElement(loginLocator);
	}

	// getInvalidErrorMessage()-->should return String
	public String getInvalidErrorMessage() {

//		return driver.findElement(errorTextLocator).getText();
		return getText(errorTextLocator);

	}

	// get username field placeholder text
	public String getUsernamePlaceholder() {

//		return driver.findElement(usernameLocator).getAttribute("placeholder");
		return getAttributeValue(usernameLocator, "placeholder");
	}

	public String getPasswordPlaceholder() {

//		return driver.findElement(passwordLocator).getAttribute("placeholder");
		return getAttributeValue(passwordLocator, "placeholder");
	}

}