package section13MiscellaneousTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chromoptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions obj = new ChromeOptions();
		obj.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(obj);
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());
		
		
	}

}
