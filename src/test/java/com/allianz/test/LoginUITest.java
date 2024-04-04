package com.allianz.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUITest {

	@Test
	public void titleTest() {
		
		System.out.println("Title test");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		String actualTitle=driver.getTitle();
		System.out.println("Actual title---->"+actualTitle);
		Assert.assertEquals(actualTitle, "OrangeHRM");
		
	}
	

	@Test
	public void applicationDescriptionTest() {
			
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		
		String actualText=driver.findElement(By.xpath("//p[text()='OrangeHRM OS 5.6.1']")).getText();
		System.out.println("Actual text--->"+actualText);
		Assert.assertEquals(actualText, "OrangeHRM OS 5.6.1");
	}
}
