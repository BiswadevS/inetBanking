package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Listener class used to generate extent reports
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports reports;
	public ExtentTest test;

	public void onStart(ITestContext context) {
		// String timeStamp = new SimpleTimeZone("yyyy.MM.dd.HH.mm.ss").;

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // time Stamp
		String repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter("./test-output/" + repName);
		// sparkReporter = new
		// ExtentSparkReporter(System.getProperty("user.dir"))+"/test-output/"+repName);
		// //specify location
		try {
			sparkReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);
		reports.setSystemInfo("Host Name", "localhost");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("user", "Pappu");

		sparkReporter.config().setDocumentTitle("InetBanking Test Project");
		sparkReporter.config().setReportName("Functional test report");
		sparkReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult tr) {
		/*
		 * ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		 * ExtentReports reports =new ExtentReports(); reports.attachReporter(spark);
		 * 
		 * ExtentTest test= reports.createTest("Google Search test one",
		 * "this is a test to validate google search functionality");;
		 * test.log(Status.INFO, "Starting test case");
		 */

		test = reports.createTest(tr.getName()); // create new entry in the report
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult tr) {

		test = reports.createTest(tr.getName()); // create new entry in the report
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";

		File f = new File(screenshotPath);

		if (f.exists()) {
			test.fail("Screenshot is below: " + test.addScreenCaptureFromPath(screenshotPath));
		}

	}

	public void onTestSkipped(ITestResult tr) {

		test = reports.createTest(tr.getName()); // create new entry in the report
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onTestFinish(ITestResult tr) {
		reports.flush();
	}
}
