package RahulShettyAcademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import RahulShettyAcademy.PageObjectModelAndFactory.CartPage;
import RahulShettyAcademy.PageObjectModelAndFactory.OrderPage;

public class AbstractComponent {

	WebDriver driver;
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="button[routerlink=\"/dashboard/cart\"]")
	WebElement CartSelection;
	
	@FindBy (xpath="(//li//button[@class='btn btn-custom'])[2]")
	WebElement OrdrHis; 
	
	public void WaitElementToAppear(By findBy)
	{
		WebDriverWait obj1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		obj1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	public void WaitForWebElementToAppear(WebElement ErrorMessage)
	{
		WebDriverWait obj1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		obj1.until(ExpectedConditions.visibilityOf(ErrorMessage));
	}
	
	public CartPage CartSelection()
	{
		CartSelection.click();
		CartPage CPobj = new CartPage(driver);
		return CPobj;
	}
	
	public OrderPage OrdersPage()
	{
		OrdrHis.click();
		OrderPage OPObj = new OrderPage(driver);
		return OPObj;
	}
}
