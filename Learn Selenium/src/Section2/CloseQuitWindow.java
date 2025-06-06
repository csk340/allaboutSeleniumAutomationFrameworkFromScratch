package Section2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseQuitWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("(//input[@class=\"radioButton\"])[3]")).click();
		driver.findElement(By.id("opentab")).click();
		Thread.sleep(5000);
		driver.close(); //This means not a latest opened tab but tab from where we opened latest tab (i.e. original website here)
		Thread.sleep(5000);
		driver.quit();
	}

}
