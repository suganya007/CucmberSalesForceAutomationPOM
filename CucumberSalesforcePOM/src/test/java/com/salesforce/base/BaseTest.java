package com.salesforce.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mongodb.MapReduceCommand.OutputType;
import com.salesforce.utility.CommonUtilities;
import com.salesforce.utility.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	 protected static WebDriver driver;
	 protected static WebDriverWait wait;
	 public static ExtentHtmlReporter htmlReporter;
	 public static ExtentReports extent;
	 public static ExtentTest logger;
	 public static GenerateReports report;
	 
	 @BeforeTest
	 public static void initialTestSetup() {
		 System.out.println("before test started");
		report= GenerateReports.getInstance();
		report.startExtentReport();
	 }
	 
	 @BeforeMethod
	 public static void setUp(Method method) {
		 report.startSingleTestReport(method.getName());
		 System.out.println("before method started");
		 String url=CommonUtilities.getApplicationProperty("url");
		 getDriver();
		 gotoUrl(url);
		
	 }

	 public static void getDriver() 
	 {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 report.logTestInfo("driver instance created");
	 }
	 
	 public static void gotoUrl(String url) 
	 {
		 driver.get(url);
		 report.logTestInfo("url entered is "+url);
	 }

	 @AfterMethod
	 public static void tearDown() throws IOException {
		 System.out.println("after method started");
		 takeScreenShot(driver);
		 closeAllDriver();
	 }
	 
	 @AfterTest
	 public static void finalTestTearDown() {
		 System.out.println("after test started");
		 report.endReport();
	 }

	 public static void closeDriver() 
	 {
		 driver.close();
	 }
		
	 public static void closeAllDriver() 
	 {
		 driver.quit();
	 }

	 public static void takeScreenShot(WebDriver driver) throws IOException
		{
			TakesScreenshot screenshot=((TakesScreenshot)driver);
			File source = screenshot.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
			String timeStamp = new SimpleDateFormat("YYYY-MM-dd HH-MM-ss").format(new java.util.Date());
			String reportFileName = "screenshot"+timeStamp+".jpg";	
			String path = Constants.SCREENSHOT_PATH+reportFileName;
			File destFile = new File(path);
			FileUtils.copyFile(source, destFile);
		}
			

}

