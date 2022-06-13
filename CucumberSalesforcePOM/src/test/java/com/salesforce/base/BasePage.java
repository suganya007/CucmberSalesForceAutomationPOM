package com.salesforce.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BasePage {
	 protected static WebDriver driver;
	 protected static WebDriverWait wait;
		ExtentHtmlReporter htmlReporter;
		public static ExtentReports extent;
		public static ExtentTest logger;
		 public static GenerateReports report;
	
	 
	public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public static void enterText(WebElement element,String text,String objName) {
		if(element.isDisplayed()) {
			clearElement(element);
			element.sendKeys(text);
			//report.logTestInfo("text entered in "+objName +"field");
		}
		else {
			System.out.println("fail: "+objName+" element not displayed");
		}
	}
	public static void clickElement(WebElement element,String objName) {
		if(element.isDisplayed()) {
			element.click();
			//report.logTestInfo("pass:"+objName+" element clicked");
		}
		else {
			//report.logTestInfo("fail:"+objName+"  element not displayed");
			
		}
	}
	public static void clearElement(WebElement element) {
		if(element.isDisplayed()) {
			element.clear();
		//	report.logTestInfo("pass:"+objName+"  element cleared");
			
		}
		else {
		//	report.logTestInfo("fail:"+objName+" element not displayed");
		}
	}
	
	public static String readText(WebElement element,String objectName) {
		waitUntilVisible(element, objectName);
		String text=element.getText();
		return text;
	}
	
	public static void waitUntilVisible(WebElement element,String objName) {
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	public static void waitUntilvisibilityOfElementLocated(By locator,String objName) {
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
	public static void waitUntilElementToBeClickable(By locator,String objName) {
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
}
