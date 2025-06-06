package RahulShettyAcademy.PageObjectModelAndFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath="//tbody/tr/td[2]")
	List<WebElement> OrderedItemsNames;
	
	
	@FindBy (xpath="//button[text()=\"Checkout\"]")
	WebElement checkout;
	
	@FindBy (xpath="//input[@placeholder=\"Select Country\"]")
	WebElement country;
	
	By countryBy = By.cssSelector(".ta-results");
	
	@FindBy (xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement SelectCountry;
	
	@FindBy (css=".btnn")
	WebElement OrderPlace;
	
	 By SuccessTextBy = By.cssSelector(".hero-primary");
	
	 @FindBy (css=".hero-primary")
	WebElement SuccessText;
	
	
	
	public Boolean CheckOrderHistory(String PName)
	{
		
		Boolean match = OrderedItemsNames.stream().anyMatch(s->s.getText().equalsIgnoreCase(PName));
		return match;
	}
	
	
}
