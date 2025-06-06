package section12JSExecutorScroll;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		List <WebElement> AllColumns = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th"));
		System.out.println("Count of all columns in table are: "+AllColumns.size());
		System.out.println("Names of eache columns are: ");
		for (int i=0;i<AllColumns.size();i++)
		{
			String ColNames = AllColumns.get(i).getText();
			System.out.println(ColNames);
		}
		System.out.println("Count of all rows in table are: "+driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size());
		System.out.println(driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[3]")).getText());
	}

}
