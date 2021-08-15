package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BeforeAndAfter;
import libraries.SeleniumWrapper;

public class LoginPage extends BeforeAndAfter{
	
	private By oUsername = By.id("username");
	private By oPassword = By.id("password");
	private By oSignIn = By.xpath("//button[text()='Sign In']");
	private By oRegister = By.xpath("//*[text()='Register For Account']");
	 	
	public boolean verifyElement() {
		
		if(verifyDisplayedwithReturn(getDriver().findElement(oUsername))&&verifyDisplayedwithReturn(getDriver().findElement(oPassword))
				&& verifyDisplayedwithReturn(getDriver().findElement(oSignIn))&&
				verifyDisplayedwithReturn(getDriver().findElement(oRegister))) {
			return true;
		}else {
			return false;
		}
	}
	
	public LoginPage typeUserName(String sUserName) {
		type(getDriver().findElement(oUsername), sUserName);
		return this;
	}
	
	public LoginPage typePassword(String sPassword) {
		type(getDriver().findElement(oPassword), sPassword);
		return this;
	}
	
	public HomePage clickSignIn() {
		click(getDriver().findElement(oSignIn));
		return new HomePage();
	}
	
	public LoginPage clickSignIn_InvalidDetails() {
		getDriver().findElement(oSignIn).click();
		boolean result =verifyDisplayedwithReturn(getDriver().findElement(oRegister));
		if(result) {
			System.out.println("User remains in Login Page due to Invalid Credential!!!");
		}else {
			System.out.println("User not in Login for Invalid Credential!!!");
		}
		return this;
	}
	
	public RegistrationPage clickRegisterAccount() {
		click(getDriver().findElement(oRegister));
		return new RegistrationPage();
	}

}
