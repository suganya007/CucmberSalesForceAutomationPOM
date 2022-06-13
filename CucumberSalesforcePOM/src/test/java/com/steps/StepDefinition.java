package com.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.salesforce.homepages.HomePage;
import com.salesforce.loginpages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	
	@Before
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Given("user go to {string}")
	public void user_go_to(String url) {
		 driver.get(url);
	}

	@When("user on {string}")
	public void user_on(String page) {
		if(page.equalsIgnoreCase("loginpage"))
			login = new LoginPage(driver);
		else if(page.equalsIgnoreCase("homepage"))
			home = new HomePage(driver);
	}

	@When("user enters {string} in username field")
	public void user_enters_in_username_field(String userName) throws InterruptedException {
		Thread.sleep(3000);
		login.enterUsername(userName);
		System.out.println("user name entered");
	}

	@When("user enters {string} in username field in forgot password")
	public void user_enters_in_username_field_in_forgot_password(String userName) throws InterruptedException {
		Thread.sleep(3000);
		login.enterUsernameForgotPW(userName);
		System.out.println("user name entered");
	}

	@When("{string} in password field")
	public void in_password_field(String password) {
		login.enterPassword(password);
		System.out.println("password entered");
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
	//	Thread.sleep(3000);
		login.clickLoginButton();
		System.out.println("Login button clicked");
	}

	@Then("validate error message {string}")
	public void validate_error_message(String expected) {
		String actual = login.GetText();
		Assert.assertEquals(expected, actual);
	}

	@When("select the rememberme checkbox")
	public void select_the_rememberme_checkbox() {
		login.chkRemember();
		System.out.println("Check remember me clicked");
	}

	@When("user click on logout button")
	public void user_click_on_logout_button() throws InterruptedException {
		Thread.sleep(3000);
		home.logout();
		System.out.println("Logout button clicked");
	}

	@Then("validate username should be {string}")
	public void validate_username_should_be(String expected) throws InterruptedException {
		Thread.sleep(3000);
		WebElement id = driver.findElement(By.id("idcard-identity"));
		String actual = id.getText();
		//String actual = login.GetID();
		Assert.assertEquals(actual, expected);
	}

	@When("user clicks forgot password")
	public void user_clicks_forgot_password() {
		login.forgotPassword();
		System.out.println("Forgot password clicked");
	}

	@When("user click on continue button")
	public void user_click_on_continue_button() {
		login.continueButton();
	}

	@Then("validate the text message {string}")
	public void validate_the_text_message(String expected) throws InterruptedException {
		String actual = login.GetTextForgotPW();
		Assert.assertEquals(actual, expected);
	}

	@After
	public void teardown()
	{
		driver.quit();
	}

}
