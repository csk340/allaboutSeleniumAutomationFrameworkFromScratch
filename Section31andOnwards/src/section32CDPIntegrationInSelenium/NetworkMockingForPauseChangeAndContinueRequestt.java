package section32CDPIntegrationInSelenium;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v137.fetch.Fetch;

public class NetworkMockingForPauseChangeAndContinueRequestt {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		DevTools obj = driver.getDevTools();
		obj.send(Fetch.enable(Optional.empty(), Optional.empty())); //Enable network mocking
		
		obj.addListener(Fetch.requestPaused(), requests ->
				{
					if (requests.getRequest().getUrl().contains("shetty"))
					{
						String mockedUrl = requests.getRequest().getUrl().replace("=shetty", "=BadGuy");
						System.out.println(mockedUrl);
						
						obj.send(Fetch.continueRequest(requests.getRequestId(), Optional.of(mockedUrl), Optional.of(requests.getRequest().getMethod()), Optional.empty(),  Optional.empty(),  Optional.empty()));
					}
					else 
					{
						obj.send(Fetch.continueRequest(requests.getRequestId(), 
								Optional.of(requests.getRequest().getUrl()), Optional.of(requests.getRequest().getMethod()), Optional.empty(),  Optional.empty(),  Optional.empty()));
					}
			
				});
		
		    driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	        driver.findElement(By.xpath("//button[text()=\" Virtual Library \"]")).click();
	        Thread.sleep(5000);
	        System.out.println(driver.findElement(By.tagName("p")).getText());
				
	}

}


















