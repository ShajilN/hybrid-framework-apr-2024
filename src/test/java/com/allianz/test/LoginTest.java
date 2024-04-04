package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;

public class LoginTest extends AutomationWrapper{
	
	@Test
	public void validLoginTest() {
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login'] ")).click();
		String actualHeader=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		//Assert the header - Dashboard
		Assert.assertEquals(actualHeader, "Dashboard");
	}
	
	@Test
	public void invalidLoginTest()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		//enter password bala123
		driver.findElement(By.name("password")).sendKeys("bala123");
		//click on login
		driver.findElement(By.xpath("//button[normalize-space()='Login'] ")).click();
		//Assert the error - Invalid credentials
	}

}
