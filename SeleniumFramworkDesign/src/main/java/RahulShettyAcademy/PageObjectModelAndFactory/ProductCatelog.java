package RahulShettyAcademy.PageObjectModelAndFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;



public class ProductCatelog extends AbstractComponent {

     WebDriver driver;

	public ProductCatelog(WebDriver driver) {
		// TODO Auto-generated constructor 
        super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (css=".card-body h5")
	List<WebElement> ProductsEle;
	
	By productsBy = By.cssSelector(".card-body h5");
	By AddTOCartBy = By.xpath("//button[@class='btn w-10 rounded']");
	By toastBy = By.cssSelector(".toast-message");
	
	public List<WebElement> GetProductList()
	{
		WaitElementToAppear(productsBy);
		return ProductsEle;
	}
	
	public WebElement GetProductByName(String PName)
	{
		WebElement prod  = GetProductList().stream().filter(s->s.findElement(By.cssSelector("h5 b")).getText().equals(PName)).findFirst().orElse(null);
		return prod;
		
		
		
		
	}
	
	public void AddProductToCart(String PName)
	{
		System.out.println("I am From Product Catelog"+PName);
		WebElement prod= GetProductByName(PName);
		prod.findElement(AddTOCartBy).click();
		WaitElementToAppear(toastBy);//Just reused abstract method by passing locator as its By locator and not webelement else we can use page factory here
	}
}
