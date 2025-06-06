package RahulShettyAcademy.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import RahulShettyAcademy.TestComponents.BaseTests;

public class ECommerceE2E2 extends BaseTests
{
	public static void main (String[] args) throws InterruptedException
	{
		String PName = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("CSK567@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder=\"enter your passsword\"]")).sendKeys("Chinmay@234");
		driver.findElement(By.id("login")).click();
		Thread.sleep(5000);
		List<WebElement> List = driver.findElements(By.cssSelector(".card-body h5"));
		//What I tried:-
//		for (int i=0;i<List.size();i++)
//		{
//		  System.out.println(List.get(i).getText());
//		
//		     if (List.get(i).getText().equalsIgnoreCase("zara coat 3"))
//		    	 {
//		    	 driver.findElement(By.xpath("(//button[@class=\"btn w-10 rounded\"])")).click();
//		    	 Thread.sleep(5000);
//		         }
//		
//	     }
	
		//What Sir Expected:-
		WebElement prod  = List.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(PName)).findFirst().orElse(null);
		 prod.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
		 
		WebDriverWait obj = new WebDriverWait(driver, Duration.ofSeconds(5));
		obj.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")));
		System.out.println(driver.findElement(By.cssSelector(".toast-message")).getText());
		
		driver.findElement(By.cssSelector("button[routerlink=\"/dashboard/cart\"]")).click();
		
		List<WebElement> cart= driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cart.stream().anyMatch(s->s.getText().equalsIgnoreCase(PName));
	//	Assert.assertTrue(match);
		Thread.sleep(3000);
        
		driver.findElement(By.xpath("//button[text()=\"Checkout\"]")).click();
	
        driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")).sendKeys("indi");
        obj.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
        List <WebElement> allsugg = driver.findElements(By.cssSelector(".ta-results"));
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
        driver.findElement(By.cssSelector(".btnn")).click();
        Thread.sleep(3000);
        obj.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".hero-primary"))));
        String a = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertEquals(a, "THANKYOU FOR THE ORDER.");
        driver.close();
       
	//div/h3
	//input[@fdprocessedid=\"4d30r\"]
	}
    }

