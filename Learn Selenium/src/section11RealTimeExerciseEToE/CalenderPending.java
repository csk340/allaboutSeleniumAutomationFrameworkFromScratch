package section11RealTimeExerciseEToE;

import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderPending {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String month ="5";
		String day = "26";
		String year = "2027";
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.linkText("Top Deals")).click();
		Set <String> windows = driver.getWindowHandles();
		java.util.Iterator<String> diffw = windows.iterator();
		String cw = diffw.next();
		String pw = diffw.next();
		Thread.sleep(3000);
		driver.switchTo().window(pw);
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__tile.react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
	//	driver.findElement(By.xpath("(//button[@class='react-calendar__tile react-calendar__month-view__days__day'])//abbr[text()='"+day+"']")).click();
		System.out.println(driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText());
		List <WebElement> DateFormat = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for (int i=0;i<DateFormat.size();i++)
		{
			String a = DateFormat.get(i).getText();
			System.out.println(a);
		}
		
		
	}

}
