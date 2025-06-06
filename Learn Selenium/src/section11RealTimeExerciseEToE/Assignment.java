package section11RealTimeExerciseEToE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		driver.findElement(By.xpath("//label[@for='honda']")).click();
		driver.findElement(By.xpath("//label[@for='honda']")).isSelected();
		//String label = driver.findElement(By.id("checkBoxOption3")).getText();
		String label = driver.findElement(By.xpath("//label[@for='honda']")).getText();
		System.out.println(label);
		WebElement drop = driver.findElement(By.id("dropdown-class-example"));
		Select drpdwn = new Select(drop);
		drpdwn.selectByVisibleText(label);
		driver.findElement(By.cssSelector("#name")).sendKeys(label);
		driver.findElement(By.id("alertbtn")).click();
		String popup = driver.switchTo().alert().getText();
		if (popup.contains(label))
		{
			System.out.println("Yes"+"'"+label+"'"+" is present in alert popup");
		}
		
		
	}

}
