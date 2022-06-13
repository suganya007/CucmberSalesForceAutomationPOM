package com.salesforce.homepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.base.BasePage;

public class HomePage extends BasePage{
	WebDriver driver;
	
	@FindBy(xpath ="//h1[text()='Student Registration Form']") WebElement salesForceHome;
	@FindBy(id = "userNavLabel") WebElement dropdown;
	@FindBy(xpath ="//a[contains(text(),'Logout')]") WebElement logout;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void logout() {
		clickElement(dropdown, "dropdown button");
		clickElement(logout,"logout button");
	}
	
	public String GetText() throws InterruptedException {
		String text=readText(salesForceHome, "text form field");
		return text;
	}

}
