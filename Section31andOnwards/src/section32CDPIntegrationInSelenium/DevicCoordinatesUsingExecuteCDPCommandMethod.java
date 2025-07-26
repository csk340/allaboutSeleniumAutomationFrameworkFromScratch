package section32CDPIntegrationInSelenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class DevicCoordinatesUsingExecuteCDPCommandMethod {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Map mapobj = new HashMap();
		mapobj.put("width", 375);
		mapobj.put("height", 667);
		mapobj.put("deviceScaleFactor", 25);
		mapobj.put("mobile", true);
		
        ChromeDriver driver  = new  ChromeDriver();
		
		DevTools obj = driver.getDevTools();
		
		obj.createSession();
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", mapobj);//CDP method in string format, Parameters required in form of HashMap
	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Library")).click();
	}
}
