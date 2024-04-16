package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;

public class LoginUITest extends AutomationWrapper {

	@Test
	public void titleTest() {
		
		String actualTitle=driver.getTitle();
		System.out.println("Actual title---->"+actualTitle);
		Assert.assertEquals(actualTitle, "OrangeHRM");
		
	}
	

	@Test
	public void applicationDescriptionTest() {
		
		String actualText=driver.findElement(By.xpath("//p[text()='OrangeHRM OS 5.6.1']")).getText();
		System.out.println("Actual text--->"+actualText);
		Assert.assertEquals(actualText, "OrangeHRM OS 5.6.1");
	}
}
