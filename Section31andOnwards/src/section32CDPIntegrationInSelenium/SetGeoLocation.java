package section32CDPIntegrationInSelenium;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v137.emulation.Emulation;

public class SetGeoLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub)
		ChromeDriver driver = new ChromeDriver();
	    DevTools obj = driver.getDevTools();
        obj.createSession();
        Map<String, Object> longAndLat = new HashMap<String, Object>();
        longAndLat.put("latitude", 40);
        longAndLat.put("longitude", 3);
        longAndLat.put("accuracy", 1);
        driver.executeCdpCommand("Emulation.setGeolocationOverride", longAndLat);
        
      //  obj.send(Emulation.setGeolocationOverride(40, 3, 1, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
        
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
        driver.findElements(By.cssSelector(".LC20lb ")).get(0).click();
        String NetflixText =  driver.findElement(By.cssSelector(".default-ltr-cache-jmnaey")).getText();
        System.out.println(NetflixText);
	}

}
