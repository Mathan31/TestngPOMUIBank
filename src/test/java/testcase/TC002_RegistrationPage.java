package testcase;


import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BeforeAndAfter;
import pages.LoginPage;
import pages.RegistrationPage;

public class TC002_RegistrationPage extends BeforeAndAfter{
	
  @Test(priority = 1)
  public void verifyAlltheElements() {
	 boolean result = new LoginPage()
	 .clickRegisterAccount()
	 .verifyElement();
	  Assert.assertTrue(result);
	  new RegistrationPage().clickOnLogin();
  }

  @Test(priority = 2)
  public void registerWithMandatoryFields() {
	  new LoginPage()
	 .clickRegisterAccount()
	 .enter_the_first_name("Mathan")
	 .enter_the_middle_name()
	 .enter_the_last_name("Chandrasekaran")
	 .select_the_title()
	 .select_the_gender()
	 .enter_the_user_name("Credo"+randomNumGen())
	 .enter_the_email("credosystemz"+randomNumGen()+"@credo.com")
	 .enter_the_password("testing123")
	 .click_on_register_button()
	 .verifyUserRegistration()
	 .clickOnLogin();
	 
  }
  
  public int randomNumGen() {
	  Random ran = new Random();
	  return ran.nextInt(10000);
  }
  
  
}
