package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;
import com.allianz.utils.DataUtils;

public class LoginTestDataDrivenTest extends AutomationWrapper{
	
	@Test
	public void validLoginTest() {
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login'] ")).click();
		String actualHeader=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		//Assert the header - Dashboard
		Assert.assertEquals(actualHeader, "Dashboard");
	}
	
	
	@Test(dataProvider = "invalidLoginData",dataProviderClass = DataUtils.class)
	public void invalidLoginTest(String username, String password, String expectedError)
	{
		//enter username
		driver.findElement(By.name("username")).sendKeys(username);
		//enter password 
		driver.findElement(By.name("password")).sendKeys(password);
		//click on login
		driver.findElement(By.xpath("//button[normalize-space()='Login'] ")).click();
		//Assert the error - Invalid credentials
		String actualErrorText=driver.findElement(By.xpath("//p[contains(@class,'alert-content-text')]")).getText();	
		Assert.assertEquals(actualErrorText, expectedError);		
	
	}

}
