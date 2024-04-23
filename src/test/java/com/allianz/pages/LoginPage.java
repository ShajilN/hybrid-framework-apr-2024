package com.allianz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	
	public static void enterUsername(WebDriver driver,String username)
	{
		driver.findElement(By.name("username")).sendKeys(username);
	}
	public static void enterPassword(WebDriver driver,String password)
	{
		driver.findElement(By.name("password")).sendKeys(password);
	}
	public static void clickOnLogin(WebDriver driver)
	{
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	//getInvalidErrorMessage()-->should return String
}