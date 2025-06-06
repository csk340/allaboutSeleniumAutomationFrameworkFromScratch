package section6AdvanceLocators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParseString {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("chinmayk340@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("353464t");
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]")).click();
		driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		driver.findElement(By.cssSelector("button.submit.signInBtn")).click();
		Thread.sleep(5000);
	    System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button[class=\"reset-pwd-btn\"]")).click();
		System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());
		String greenMessage = driver.findElement(By.cssSelector(".infoMsg")).getText();
		String[] passcheck = greenMessage.split("'");
		for (int i=0;i<passcheck.length;i++)
		{
		         System.out.println(passcheck[i]);
		}
		String actualpass = passcheck[1];
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys("chinmayk340@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys(actualpass);
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button.submit.signInBtn")).click();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//div[@class=\"login-container\"]/h1")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class=\"login-container\"]/h2")).getText());
	    String SuceesLoginMessage =  driver.findElement(By.xpath("//div[@class=\"login-container\"]/p")).getText();
	    driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button")).click();
	    driver.quit();
	    
		

	}

}
