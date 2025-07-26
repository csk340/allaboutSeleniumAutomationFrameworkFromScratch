package section32CDPIntegrationInSelenium;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v137.network.Network;

import com.google.common.collect.ImmutableList;

public class NetworkBlockReq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools obj = driver.getDevTools();
	    obj.createSession();
	    obj.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
	   // obj.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
	    
	    long a =System.currentTimeMillis();
	    driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	    driver.findElement(By.cssSelector(".btn-success")).click();
	    driver.findElement(By.linkText("Selenium")).click();
	    driver.findElement(By.cssSelector(".add-to-cart")).click();
	    System.out.println(driver.findElement(By.tagName("p")).getText());
	    
	    long b = System.currentTimeMillis();
	    long c = b-a ;
	    //System.out.println("Difference between both timing by blocking image and css is : "+c);
	    System.out.println("Difference between both timing without blocking image and css is : "+c);
	    //6546 //12074  = 5528ms
	}

}
