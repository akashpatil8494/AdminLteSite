package com.adminlte.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adminlte.base.TestBase;
import com.adminlte.pages.LoginPage;
import com.adminlte.pages.RegistrationPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	RegistrationPage registrationpage;

	LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		registrationpage = new RegistrationPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.verifyTitle();
		Assert.assertEquals(title, "AdminLTE 2 | Log in");
	}

	@Test(priority = 2)
	public void loginPageLogoTest() {
		Assert.assertTrue(loginpage.verifyloginlogo());
	}

	@Test(priority = 3)
	public void loginBoxMsgTest() {
		String msg = loginpage.verifyLoginBoxMsg();
		Assert.assertEquals(msg, "Sign in to start your session");
	}

	@Test(priority = 4)
	public void invalidEmailMsgTest() throws Exception {
		String msg = loginpage.verifyInvalidEmailError(prop.getProperty("invalidemail"));
		Assert.assertEquals(msg, "Please enter email as kiran@gmail.com");
	}

	@Test(priority = 5)
	public void invalidPwdMsgTest() {
		String msg = loginpage.verifyInvalidPasswordError(prop.getProperty("inavalidpassword"));
		Assert.assertEquals(msg, "Please enter password 123456");
	}

	@Test(priority = 6)
	public void membershipLinkTest() {
		registrationpage = loginpage.verifyMembershipLink();
	}

	@Test(priority = 7)
	public void loginTest() {
		loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
