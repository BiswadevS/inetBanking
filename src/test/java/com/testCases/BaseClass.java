package com.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig config = new ReadConfig();

	public String baseUrl = config.getApplicationUrl();
	public String username = config.getUsername();
	public String password = config.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		logger = LogManager.getLogger(BaseClass.class);

		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);
		driver.manage().window().maximize();

	}

	@AfterTest
	public void tearDown() {

		driver.close();
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/ " + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");

	}

	public String randomString() {

		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return (generatedString);

	}

	public String randomNum() {

		String generatedNum = RandomStringUtils.randomNumeric(8);
		return (generatedNum);

	}

}
