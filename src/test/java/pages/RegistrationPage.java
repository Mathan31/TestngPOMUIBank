package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import base.BeforeAndAfter;
import libraries.SeleniumWrapper;

public class RegistrationPage extends BeforeAndAfter{
	
	private By oFirstName = By.id("firstName");
	private By oMiddleName = By.id("middleName");
	private By oLastName = By.id("lastName");
	private By oUserName = By.id("username");
	private By oEmail = By.id("email");
	private By oPassword = By.id("password");
	private By oRegister = By.xpath("//button[text()='Register']");
	private By oTitle = By.id("title");
	private By oGender = By.id("sex");
	private By oLogin = By.xpath("//a[text()='Login']");
		
	public boolean verifyElement() {
		if(verifyDisplayedwithReturn(getDriver().findElement(oUserName))&&
				verifyDisplayedwithReturn(getDriver().findElement(oEmail))&&
				verifyDisplayedwithReturn(getDriver().findElement(oPassword))&&
				verifyDisplayedwithReturn(getDriver().findElement(oRegister))) {
			return true;
		}else {
			return false;
		}
	}
	
	public RegistrationPage enter_the_first_name(String firstname) {
		type(getDriver().findElement(oFirstName), firstname);
		return this;
	}

	public RegistrationPage enter_the_middle_name() {
		type(getDriver().findElement(oMiddleName), "Mentor");
		return this;
	}

	public RegistrationPage enter_the_last_name(String sLastName) {
		type(getDriver().findElement(oLastName), sLastName);
		return this;
	}
	
	public RegistrationPage select_the_title() {
		selectDropDownUsingVisibleText(getDriver().findElement(oTitle), "Mr");
		return this;
	}

	public RegistrationPage select_the_gender() {
		selectDropDownUsingVisibleText(getDriver().findElement(oGender), "Female");
		return this;
	}

	public RegistrationPage enter_the_user_name(String username) {
		type(getDriver().findElement(oUserName), username);
		return this;
	}

	public RegistrationPage enter_the_email(String email) {
		type(getDriver().findElement(oEmail), email);
		return this;
	}

	public RegistrationPage enter_the_password(String password) {
		type(getDriver().findElement(oPassword), password);
		return this;
	}
	
	public EmailVerificationPage click_on_register_button() {
		click(getDriver().findElement(oRegister));
		return new EmailVerificationPage(); 
	}
	
	public LoginPage clickOnLogin() { 
		click(getDriver().findElement(oLogin));
		return new LoginPage();
	}
}
