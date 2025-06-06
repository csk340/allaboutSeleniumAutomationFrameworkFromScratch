package section9Synchronization;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWait1234 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		driver.findElement(By.cssSelector("#start button")).click();
		
		//Fluent Wait Process
		
		Wait <WebDriver> wait = new FluentWait <WebDriver> (driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>()
		{
			public WebElement apply (WebDriver driver)
			{
				if (driver.findElement(By.cssSelector("#finish h4")).isDisplayed())
				{
					return driver.findElement(By.cssSelector("#finish h4"));
				}
				else return null;
			}
		});
		System.out.println(driver.findElement(By.cssSelector("#finish h4")).getText());
				
		
		
		
	}

}
