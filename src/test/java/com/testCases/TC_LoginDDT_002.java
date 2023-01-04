package com.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;
import com.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{

		@Test(dataProvider = "LoginData")
		public void loginDTT(String username, String password) throws Exception {
			LoginPage page = new LoginPage(driver);
			page.setUserName(username);
			logger.info("username provided");
			page.setPassword(password);
			logger.info("password provided");
			page.clickSubmit();
			Thread.sleep(3000);
			
			if(isAlertPresent() == true) {
				driver.switchTo().alert().accept(); // close alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
				logger.warn("login failed");
			}else
			{
				Assert.assertTrue(true);
				logger.info("Login passed");
				page.clickLogout();
				Thread.sleep(3000);
				driver.switchTo().alert().accept(); //close logout alert
				driver.switchTo().defaultContent();
				
			}

		}
		
		public boolean isAlertPresent() {  //user defined method to check alert is present or not
			
			try {
				driver.switchTo().alert();
				return true;
				
			} catch (Exception e) {
				return false;
			}
			
			
		}

		@DataProvider(name = "LoginData")
		public String[][] getData() throws Exception {

			String path = System.getProperty("user.dir") + "/src/test/java/com/testData/Data driven.xlsx";

			int rowNum = XLUtils.getRowCount(path, "Sheet1");
			int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
			String loginData[][] = new String[rowNum][colCount];
			
			for(int i=1;i<=rowNum; i++) {
				for(int j=0; j<colCount; j++) {
					loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
				}
			}
			return loginData;

		}

	}
