package section10ActionWindowHandleAndFrames;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/loginpagePractise/");
			driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
			Set <String> a = driver.getWindowHandles();
			Iterator<String> itn = a.iterator();
			String parentWindow  = itn.next();
			String  childWindow= itn.next(); //Don't use hasnext() as its return type is boolean only
	        driver.switchTo().window(childWindow);
	        WebDriverWait expectedElement = new WebDriverWait(driver, Duration.ofSeconds(4));
	        expectedElement.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".im-para.red")));
	        String requiredText = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
	        System.out.println(requiredText);
	        driver.switchTo().window(parentWindow);
	        Thread.sleep(4000);
	        driver.findElement(By.cssSelector("input[id='username']")).click();
	        driver.findElement(By.cssSelector("input[id='username']")).sendKeys(requiredText);	        
	
	
	}


}
