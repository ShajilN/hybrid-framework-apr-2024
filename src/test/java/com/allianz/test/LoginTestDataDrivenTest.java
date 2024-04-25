package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;
import com.allianz.pages.DashboardPage;
import com.allianz.pages.LoginPage;
import com.allianz.utils.DataUtils;

public class LoginTestDataDrivenTest extends AutomationWrapper{
	
	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class)
	public void validLoginTest(String username, String password, String ExpectedHeader) {
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();
		
		DashboardPage dashboardPage=new DashboardPage(driver);
		String actualHeader=dashboardPage.getDashboardHeader();
		//Assert the header - Dashboard
		Assert.assertEquals(actualHeader, ExpectedHeader);
	}
	
	
	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class)
	public void invalidLoginTest(String username, String password, String expectedError)
	{

		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();
		//Assert the error - Invalid credentials
		String actualErrorText=loginPage.getInvalidErrorMessage();
		Assert.assertEquals(actualErrorText, expectedError);
	
	}

}
