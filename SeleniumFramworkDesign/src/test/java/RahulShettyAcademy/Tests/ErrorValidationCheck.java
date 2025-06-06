package RahulShettyAcademy.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import RahulShettyAcademy.TestComponents.BaseTests;

public class ErrorValidationCheck extends BaseTests {

	String EmailID = "CSK567@gmail.com";
	String pwd = "Chinm@234";
	@Test (groups={"ErrorHandling"}/*,retryAnalyzer = Retry.class*/ )//Why this is showing error ?
	public void SubmitOrder()
	{
		LPObj.Action("CSK567@gmail.com","Chinm@234");
		LPObj.GetErrorMessage();
		Assert.assertEquals("Incorrect email password.", LPObj.GetErrorMessage());
	}
	
	//Consider there are another set of code which show errors in this class
	//Error1 
	//Error2
	//Error3
	
}
