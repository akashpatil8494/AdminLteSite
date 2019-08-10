package com.adminlte.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adminlte.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//div[@class='login-logo']")
	WebElement logo;

	// Valid Email
	@FindBy(xpath = "//input[@type='text']")
	WebElement email;

	// InValid Email
	@FindBy(xpath = "//div[@id='email_error']")
	WebElement emailerror;

	// password
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	// invalid password
	@FindBy(xpath = "//div[@id='password_error']")
	WebElement passworderror;

	// submit button
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;

	// text msg
	@FindBy(xpath = "//p[@class='login-box-msg']")
	WebElement loginmsg;

	// new membership
	@FindBy(xpath = "//a[@class='text-center']")
	WebElement newmembership;

	//initializing above page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();	
	}
	
	public boolean verifyloginlogo() {
		return logo.isDisplayed();
	}

	public String verifyLoginBoxMsg() {
		return loginmsg.getText();
	}
	
	public String verifyInvalidEmailError(String error) throws Exception {
		email.sendKeys(error);
		submit.click();
		return emailerror.getText();
	}

	public String verifyInvalidPasswordError(String pwderror) {
		password.sendKeys(pwderror);
		submit.click();
		return passworderror.getText();
	}
	

	public RegistrationPage verifyMembershipLink() {
		newmembership.click();
		
		return new RegistrationPage();
	}
	
	public DashboardPage login(String eml, String pwd) {
		email.sendKeys(eml);
		password.sendKeys(pwd);
		submit.click();
		
		return new DashboardPage();
	}
	

	

}
