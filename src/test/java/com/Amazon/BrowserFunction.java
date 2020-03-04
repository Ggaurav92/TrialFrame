package com.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BrowserFunction {
	
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void initialioseBrowser() {
	
	
	htmlReporter = new ExtentHtmlReporter("./Reports/One_Extent.html");
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    
    System.out.println("Extent Start");
    
    
    extent.setSystemInfo("Windows", "Mac Sierra");
    extent.setSystemInfo("Host Name", "Test");
    extent.setSystemInfo("Environment", "QA");
    extent.setSystemInfo("User Name", "Gaurav Garje");

    htmlReporter.config().setChartVisibilityOnOpen(true);
    htmlReporter.config().setDocumentTitle("Extent report");
    htmlReporter.config().setReportName("Final Report");
    System.out.println("Extent end");
	
    System.setProperty("webdriver.chrome.driver","C:\\Training\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	}

	@BeforeClass
	public void beforeclass() {
			System.out.println(this.getClass().getSimpleName());
			test= extent.createTest(this.getClass().getSimpleName());
			
	}
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		System.out.println("In After method");
		System.out.println(result.getMethod().getConstructorOrMethod().getMethod().getName());
		System.out.println(this.getClass().getSimpleName());
		//test= extent.createTest(result.getMethod().getConstructorOrMethod().getMethod().getName());
	    if(result.getStatus() == ITestResult.FAILURE)
	    {
	    	System.out.println("Test failed entering in Report");
	        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	        test.fail(result.getThrowable());
	    }
	    else if(result.getStatus() == ITestResult.SUCCESS)
	    {
	    	System.out.println("Test passed entering in report");
	        test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	    }
	    else
	    {
	        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	        test.skip(result.getThrowable());
	    }
	    System.out.println("At end of after method");
	}
	
	@AfterSuite
	public void closeBrowser() {
		
	System.out.println("In after suite");
	driver.quit();
	extent.flush();
	}


}
