package section32CDPIntegrationInSelenium;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v137.network.Network;
import org.openqa.selenium.devtools.v137.network.model.ConnectionType;

public class NetworkEmulateSpeedToSlowExecution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		DevTools obj = driver.getDevTools();
		obj.createSession();
		obj.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		obj.send(Network.emulateNetworkConditions(true, 2000, 20000, 30000, Optional.of(ConnectionType.ETHERNET), Optional.empty(),  Optional.empty(),  Optional.empty()));
		
		obj.addListener(Network.loadingFailed(), loadingFailed -> 
		{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
		});
		
		
		long a =System.currentTimeMillis();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	    driver.findElement(By.xpath("//button[text()=\" Virtual Library \"]")).click();
	    long b = System.currentTimeMillis();
		long c = b-a ;
		System.out.println(c);
	   
		  

	}

}
