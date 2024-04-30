package com.allianz.test;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;
import com.allianz.pages.DashboardPage;
import com.allianz.pages.LoginPage;
import com.allianz.pages.PIMPage;

public class AddEmployee2Test extends AutomationWrapper {
	
	@Test
	public void uploadInvalidDisplayPictureTest(String username, String password)
	{
		File file = new File("src/test/resources/files/dummy.pdf");
		String filePath = file.getAbsolutePath();
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		//click on PIM menu
//		driver.findElement(By.linkText("PIM")).click();
		dashboardPage.clickOnPIM();
		PIMPage pimPage = new PIMPage(driver);
		//click on add employee
		pimPage.clickOnAddEmployee();
		//upload the pdf file instead of image
//		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(filePath);
		pimPage.inputText(filePath);
		//Assert the error - File type not allowed
//		String actualError = driver.findElement(By.xpath("//span[contains(@class,'error-message')]")).getText();
		String actualError = pimPage.getInvalidErrorMessage();
		Assert.assertEquals(actualError, "File type not allowed");
		Assert.assertTrue(actualError.contains("File type not allowed"));
	}

}