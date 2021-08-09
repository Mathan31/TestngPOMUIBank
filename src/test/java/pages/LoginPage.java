package pages;

import org.openqa.selenium.By;

import base.BeforeAndAfter;

public class LoginPage extends BeforeAndAfter{
	
	private By oUsername = By.id("username");
	private By oPassword = By.id("password");
	private By oSignIn = By.xpath("//button[text()='Sign In']");
	private By oRegister = By.xpath("//*[text()='Register For Account']");
	
	public boolean verifyElement() {
		if(driver.findElement(oUsername).isDisplayed() && driver.findElement(oPassword).isDisplayed()
				&& driver.findElement(oSignIn).isDisplayed() && driver.findElement(oRegister).isDisplayed()) {
			return true;			
		}else {
			return false;
		}
	}
	
	public LoginPage typeUserName(String sUserName) {
		driver.findElement(oUsername).sendKeys(sUserName);
		return this;
	}
	
	public LoginPage typePassword(String sPassword) {
		driver.findElement(oPassword).sendKeys(sPassword);
		return this;
	}
	
	public HomePage clickSignIn() {
		driver.findElement(oSignIn).click();
		return new HomePage();
	}
	
	public LoginPage clickSignIn_InvalidDetails() {
		driver.findElement(oSignIn).click();
		boolean result = driver.findElement(oRegister).isDisplayed();
		if(result) {
			System.out.println("User is in Login for Invalid Credential!!!");
		}else {
			System.out.println("User not in Login for Invalid Credential!!!");
		}
		return this;
	}
	
	public RegistrationPage clickRegisterAccount() {
		driver.findElement(oRegister).click();
		return new RegistrationPage();
	}

}
