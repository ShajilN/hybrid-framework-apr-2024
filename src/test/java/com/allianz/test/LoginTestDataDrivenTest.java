package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;
import com.allianz.pages.LoginPage;
import com.allianz.utils.DataUtils;

public class LoginTestDataDrivenTest extends AutomationWrapper{
	
	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class)
	public void validLoginTest(String username, String password, String ExpectedHeader) {
		
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.clickOnLogin(driver);
		String actualHeader=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		//Assert the header - Dashboard
		Assert.assertEquals(actualHeader, ExpectedHeader);
	}
	
	
	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class)
	public void invalidLoginTest(String username, String password, String expectedError)
	{

		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.clickOnLogin(driver);
		//Assert the error - Invalid credentials
		String actualErrorText=driver.findElement(By.xpath("//p[contains(@class,'alert-content-text')]")).getText();	
		Assert.assertEquals(actualErrorText, expectedError);		
	
	}

}
