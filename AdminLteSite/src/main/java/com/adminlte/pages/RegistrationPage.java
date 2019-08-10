package com.adminlte.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adminlte.base.TestBase;

public class RegistrationPage extends TestBase {

	@FindBy(xpath = "//p[@class='login-box-msg']")
	WebElement textmsg;

	@FindBy(xpath = "//input[@id='name']")
	WebElement name;

	@FindBy(xpath = "//input[@id='mobile']")
	WebElement mobile;

	@FindBy(xpath = "//input[@id='email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//a[@class='text-center']")
	WebElement alreadyMembership;

	public RegistrationPage() {

		PageFactory.initElements(driver, this);
	}

	public String verifyTitle() {

		return driver.getTitle();
	}

	public String VerifyRegBoxText() {

		return textmsg.getText();

	}

	public void createRegistration(String uname, String umobile, String uemail, String upassword) {

		name.sendKeys(uname);

		mobile.sendKeys(umobile);

		email.sendKeys(uemail);

		password.sendKeys(upassword);

		submit.click();

		
		  Alert alert = driver.switchTo().alert();
		  
		  alert.accept();
		 
		// return new RegistrationPage();
	}

	public LoginPage clickOnMembership() {
		alreadyMembership.click();
		return new LoginPage();
	}

}
