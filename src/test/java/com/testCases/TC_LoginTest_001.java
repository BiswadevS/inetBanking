package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws Exception {

		logger.info("URL is opened");
		LoginPage page = new LoginPage(driver);
		page.setUserName(username);
		logger.info("Username is entered");
		page.setPassword(password);
		logger.info("Password is entered");
		page.clickSubmit();
		
		System.out.println("Title is: "+driver.getTitle());

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {

			Assert.assertTrue(true);
			logger.info("Login test passed");

		} else
			logger.info("Login test failed");
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		
	}

}
