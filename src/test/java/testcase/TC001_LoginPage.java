package testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BeforeAndAfter;
import pages.LoginPage;

public class TC001_LoginPage extends BeforeAndAfter {

	@BeforeTest
	public void setUpTestCase() {
		sSheetName = "TC001";
		authors = "Mathan";
		category = "Smoke";
		testCaseName = "Login";
		testDescription = "Testing the Login functionality";
		module = "Login Module";
	}

	@Test(priority = 1)
	public void verifyAlltheElements() {
		boolean result = new LoginPage().verifyElement(); 
		Assert.assertTrue(result);
	}

	@Test(priority = 2, dataProvider = "ExcelData")
	public void loginwithValidCredential(String uName, String password) {
		new LoginPage()
		.typeUserName(uName)
		.typePassword(password)
		.clickSignIn()
		.verifyHomePage()
		.clickLogout();
	}

	@Test(priority = 3)
	public void loginWithInValidCredential() {
		new LoginPage()
		.typeUserName("Mathan")
		.typePassword("testing")
		.clickSignIn_InvalidDetails();

	}
}
