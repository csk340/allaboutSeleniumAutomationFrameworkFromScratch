package section11RealTimeExerciseEToE;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScopePrintLinksCount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//A. get all the links count in whole page																										qqqa
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//B. Limiting scope of webdriver to footer section of the page
		WebElement FooterDriver = driver.findElement(By.cssSelector("#gf-BIG"));
		System.out.println(FooterDriver.findElements(By.tagName("a")).size());
		
		//C. Limiting scope of webdriver to fist column of footer section
		WebElement FirstColumnDriver = FooterDriver.findElement(By.xpath("(//div[@id='gf-BIG'])/table/tbody/tr/td[1]"));
		System.out.println(FirstColumnDriver.findElements(By.tagName("a")).size());
		
		//D. Check all links of first column are opening or not
		System.out.println("Here are the links present in 1st column of footeer:-");
		List <WebElement> AllLinksOfFirstColumn = FirstColumnDriver.findElements(By.tagName("a"));
		for (int i=0; i<AllLinksOfFirstColumn.size();i++)
		{
			String clickonLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
			AllLinksOfFirstColumn.get(i).sendKeys(clickonLinks);
			Thread.sleep(4000);
		}
		//Till this step you have opened all tabs and now this completed so go out of this loop so close loop here
		//Earlier you don't have closed the bracket here (and closed after while loop) it was performing for first time and for 2nd time error no such element
		    Set<String> windows = driver.getWindowHandles();
		    Iterator <String> abc = windows.iterator();
		   
		    while (abc.hasNext())
		    	{
		    	driver.switchTo().window(abc.next());
		        System.out.println( driver.getTitle());
		    	}
		   
		  
		   
		    
		}
        }

//FYI: We can add Keys.ENTER like this in sendkeys also 


