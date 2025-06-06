package TestAuotmationProjectForPractice.TestProjectSwagLabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EndToEndFlow {
	
	@Test
	public void PurchaseProduct() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	//	driver.switchTo().alert().accept();
	//	Thread.sleep(5000);
		List<WebElement> allProduct = driver.findElements(By.xpath("//div[@data-test='inventory-list']"));
		
		for (int i=0;i<allProduct.size();i++)
		{
		String ProductName = allProduct.get(i).findElement(By.xpath("//div/div[2]/div/a")).getText();
		System.out.println(ProductName);
		}
		
	}

}
