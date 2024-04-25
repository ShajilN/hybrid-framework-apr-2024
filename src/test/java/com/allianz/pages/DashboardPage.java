package com.allianz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.allianz.base.WebDriverKeywords;

public class DashboardPage extends WebDriverKeywords {

	private By dashboardTextLocator = By.xpath("//h6[text()='Dashboard']");
	private By assignLeaveLocator = By.xpath("//button[@title='Assign Leave']");
	private By leaveListLocator = By.xpath("//button[@title='Leave List']");
	private By timeSheetLocator = By.xpath("//button[@title='Timesheets']");

	private WebDriver driver;

	public DashboardPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
	}

	public String getDashboardHeader() {

//		return driver.findElement(dashboardTextLocator).getText();
		return getText(dashboardTextLocator);

	}

	// clickOnAssignLeave
	public void clickOnAssignLeave() {

//		driver.findElement(assignLeaveLocator).click();
		clickElement(assignLeaveLocator);
	}

	// Click on LeaveList
	public void clickOnLeaveList() {

//		driver.findElement(leaveListLocator).click();
		clickElement(leaveListLocator);
	}

	// click on Time sheet
	public void clickOnTimesheets() {

//		driver.findElement(timeSheetLocator).click();
		clickElement(timeSheetLocator);
	}
}
