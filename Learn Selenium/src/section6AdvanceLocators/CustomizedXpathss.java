package section6AdvanceLocators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomizedXpathss {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
	    //driver.findElement(By.xpath("//div/form/input[1]")).sendKeys("Chinmay");//Parent child traverse using xpath
		//driver.findElement(By.cssSelector("input[name*='put']")).sendKeys("rahulshettyacademy");//using customized Css Selector*** IMP
		//driver.findElement(By.xpath("//div[@class='checkbox-container']/span[1]/input")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();//using customized xpath*** IMP
        System.out.println(driver.findElement(By.cssSelector("div form p")).getText());
		//driver.findElement(By.cssSelector("button.signInBtn")).click();
		
		//So now parent child traverse using css selector

	}

}
