package section12JSExecutorScroll;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;

public class ScrollWithinWebPageAndTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		js.executeScript("document.querySelector('.tableFixHead').scrollBy(0,1000)");
		List <WebElement> Amount = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		int sum=0;
		for (int i=0; i<Amount.size();i++)
		{
			String a = Amount.get(i).getText();
			int b = Integer.parseInt(a);
			sum = sum + b;
		}
		
			System.out.println(sum);
			String msg = driver.findElement(By.cssSelector(".totalAmount")).getText();
			String Expected = msg.split(":")[1].trim();
			int ExpValue = Integer.parseInt(Expected);
			System.out.println(ExpValue);
			Assert.assertEquals(sum, ExpValue);
	}

}
