package section32CDPIntegrationInSelenium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v137.fetch.Fetch;
import org.openqa.selenium.devtools.v137.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v137.network.model.ErrorReason;

public class NetworkFailedReq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools obj = driver.getDevTools();
		
		
		Optional<List<RequestPattern>> pattern = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));

		obj.send(Fetch.enable(pattern, Optional.empty()));
		
		obj.addListener(Fetch.requestPaused(), request ->
		{
			obj.send(Fetch.failRequest(request.getRequestId(), ErrorReason.ACCESSDENIED));
		}
		
		);
		
		 driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	     driver.findElement(By.xpath("//button[text()=\" Virtual Library \"]")).click();
	}

}
