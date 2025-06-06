package section14JavaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomSeleniumMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//table/thead/tr/th[1]")).click();
		List<WebElement> AllVeggies = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		List<String> OriginalList = AllVeggies.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(OriginalList);
		do {
			List<WebElement> AllVeggies1 = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
			
		    }
		while(AllVeggies.contains("a"));
	}
		
		
	}


