package section7DropdownandCalender;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("divpaxinfo")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		int i=1;
		while (i<5)
		{
		driver.findElement(By.id("hrefIncAdt")).click();
		i++;
		}
		 System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		for (int j=1;j<=2;j++)
		{
		driver.findElement(By.id("hrefIncChd")).click();
		}
		 System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		for (int k=1;k<=2;k++)
		{
		driver.findElement(By.id("hrefIncInf")).click();
		}
		 System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//3 adt , 1chd, 2inf

	}

}
