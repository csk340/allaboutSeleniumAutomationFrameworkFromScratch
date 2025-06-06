package RahulShettyAcademy.PageObjectModelAndFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;


public class LandingPage extends AbstractComponent {

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);//Null pointer exception if we not pass driver to page factory 
	}
	
	@FindBy (css="#userEmail")
	WebElement EmailEle;
	
	@FindBy (xpath="//input[@placeholder=\"enter your passsword\"]")
	WebElement PasswordEle;
	
	@FindBy (id="login")
	WebElement Login;
	
	@FindBy (css=".ng-trigger-flyInOut")
	WebElement ErrorMessage;
	

	public void GoTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
	public ProductCatelog Action(String EmailID, String pwd)
	{
		EmailEle.sendKeys(EmailID);
		PasswordEle.sendKeys(pwd);
		Login.click();
		ProductCatelog PCobj = new ProductCatelog(driver);
		return PCobj;
		
	}
	
	
	public String GetErrorMessage()
	{
		WaitForWebElementToAppear(ErrorMessage);
		ErrorMessage.getText();
		return ErrorMessage.getText();
	}
	
	
}
