
package com.adminlte.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adminlte.base.TestBase;
import com.adminlte.pages.LoginPage;
import com.adminlte.pages.RegistrationPage;
import com.adminlte.utility.TestUtil;

public class RegistrationPageTest extends TestBase {

	RegistrationPage registrationPage;
	LoginPage loginpage;
	String sheetName= "RegistrationPageData";

	RegistrationPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		
		initialization();
		
		registrationPage = new RegistrationPage();
		loginpage = new LoginPage();
		loginpage.verifyMembershipLink();
	}

	@Test(priority = 1)
	public void titleTest() {
		// loginpage.verifyMembershipLink();
		String title = registrationPage.verifyTitle();
		Assert.assertEquals(title, "AdminLTE 2 | Registration Page");
	}

	@Test(priority = 2)
	public void VerifyRegBoxTextTest() {
		
		// loginpage.verifyMembershipLink();
		String text = registrationPage.VerifyRegBoxText();
		Assert.assertEquals(text, "Register a new membership");
	}

	@DataProvider
	public Object[][] getRegTestData() {
		
		Object[][] data = TestUtil.getTestData(sheetName);
		
		return data;
	}

	@Test(priority = 3,dataProvider = "getRegTestData")
	public void createRegistrationTest(String name, String mobileNo, String emailID, String pass) {

		registrationPage.createRegistration(name, mobileNo, emailID, pass);

	}

	@Test(priority = 4)
	public void clickOnMembershipTest() {
		
		registrationPage.clickOnMembership();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
