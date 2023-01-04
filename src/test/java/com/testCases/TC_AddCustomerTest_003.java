package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.AddCustomerPage;
import com.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws Exception {
	
		LoginPage page = new LoginPage(driver);
		page.setUserName(username);
		logger.info("Username is provided");
		page.setPassword(password);
		logger.info("Password is provided");
		page.clickSubmit();
		
		Thread.sleep(5000);
		
		AddCustomerPage customerPage = new AddCustomerPage(driver);
		customerPage.clickAddNewCustomer();
		logger.info("providing customer details....");
		
		customerPage.custName("Biswadev");
		customerPage.custGender("Male");
		customerPage.custDob("03", "29", "1993");
		Thread.sleep(5000);
		
		customerPage.custAddress("India");
		customerPage.custCity("Bangalore");
		customerPage.custState("Karnataka");
		customerPage.custPinno("560100");
		customerPage.custTelephone("111111111");
		
		String email = randomString()+"@gmail.com";
		customerPage.custEmailid(email);
		
		customerPage.custPassword("asdfg");
		customerPage.clickSubmit();
		Thread.sleep(5000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!\r\n");
		
		if(res == true) {
			Assert.assertTrue(true);
			logger.info("test case is passed");
		}else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test cases failed");
		}
	}
	

}
