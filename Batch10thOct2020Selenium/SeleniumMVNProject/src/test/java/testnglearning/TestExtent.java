package testnglearning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestExtent {

	public ExtentSparkReporter htmlReporter; // Create HTML file and add Config
	public ExtentReports extent; // Attach reporter and other sys info
	public ExtentTest test; // create test cases add logs

	@BeforeTest
	public void setReport() {

		htmlReporter = new ExtentSparkReporter("./reports/extent.html");

		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Test Results");
		htmlReporter.config().setReportName("W2A Automation Report");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Automation Tester", "Rahul Arora");
		extent.setSystemInfo("Organization", "Way2Automation");
		extent.setSystemInfo("Build No: ", "1234");

	}

	@AfterTest
	public void endReport() {

		extent.flush();
	}

	@Test
	public void doLogin() {

		test = extent.createTest("Login Test");
		test.info("Entered username");
		test.info("Entered password");

	}

	@Test
	public void doUserReg() {

		test = extent.createTest("User Reg Test");
		Assert.fail("user reg failed");

	}

	@Test
	public void isSkip() {

		test = extent.createTest("Skip Test");
		throw new SkipException("Skipping the test case");
		// test.skip("Skipping the test");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			
			test.fail("Exception message :"+result.getThrowable().getMessage());

			test.fail("Test case failed");

			String methodName = result.getMethod().getMethodName();

			
			
			String screenshot = "C:\\Users\\way2automation\\Desktop\\cypressio.jpg";
			test.fail("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",
			MediaEntityBuilder.createScreenCaptureFromPath(screenshot)
			.build());

			
			
			
			
			
			Markup m = MarkupHelper.createLabel("TEST FAILED : " + methodName, ExtentColor.RED);
			test.fail(m);

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.pass("Test Case Pass");

			String methodName = result.getMethod().getMethodName();

			Markup m = MarkupHelper.createLabel("TEST PASS : " + methodName, ExtentColor.GREEN);
			test.pass(m);

		} else if (result.getStatus() == ITestResult.SKIP) {

			test.skip("Skipping the test");

			String methodName = result.getMethod().getMethodName();

			Markup m = MarkupHelper.createLabel("TEST SKIPPED : " + methodName, ExtentColor.YELLOW);
			test.skip(m);

		}

	}

}
