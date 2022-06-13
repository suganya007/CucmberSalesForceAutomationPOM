package com.salesforce.loginpages;

import javax.inject.Named;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.base.BasePage;

public class LoginPage extends BasePage
{
	WebDriver driver;
	
	@FindBy(id = "username") WebElement userName;
	@FindBy(id = "password") WebElement password;
	@FindBy(xpath = "//input[@id='Login']") WebElement loginButton;
	@FindBy(id = "error") WebElement errorMsg;
	@FindBy(xpath = "//input[@id='rememberUn']") WebElement rememberme;
	@FindBy(id = "idcard-identity") WebElement idcard;
	@FindBy(id = "forgot_password_link") WebElement forgotPW;
	@FindBy(id = "un") WebElement uname;
	@FindBy(id = "continue") WebElement cont;
	@FindBy(xpath ="//h1[text()='Check Your Email']") WebElement emailChk;
	
	//h1[text()='Check Your Email']

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterUsername(String username) {
		waitUntilVisible(userName,"user name field");
		clearElement(userName);
		enterText(userName, username, "user name field");
		
	}
	public void enterUsernameForgotPW(String username) {
		waitUntilVisible(uname,"user name field");
		clearElement(uname);
		enterText(uname, username, "user name field");
		
	}
	
	public void enterPassword(String passWord) {
		
		enterText(password, passWord, "password field");
		
	}
	
	public void clickLoginButton() {
		waitUntilVisible(loginButton, "login button");
		clickElement(loginButton,"login button");
	}
	
	public void chkRemember()
	{
		clickElement(rememberme,"remember me");
	}
	
	public void login(String usrname,String passWrd) 
	{
		enterUsername(usrname);
		enterPassword(passWrd);
		clickLoginButton();
	}
	
	public String GetText()
	{
		String text=readText(errorMsg, "error msg");
		return text;
	}
	
	public String GetID()
	{
		String text=readText(idcard, "id card");
		return text;
	}
	
	public void forgotPassword()
	{
		clickElement(forgotPW, "forgot Password");
	}
	public void continueButton()
	{
		clickElement(cont, "continue button");
	}
	
	public String GetTextForgotPW() throws InterruptedException
	{
		String text=readText(emailChk, "email check");
		return text;
	}
}
