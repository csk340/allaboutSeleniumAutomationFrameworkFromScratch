package section32CDPIntegrationInSelenium;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v137.network.Network;
import org.openqa.selenium.devtools.v137.network.model.Request;
import org.openqa.selenium.devtools.v137.network.model.Response;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
	    DevTools obj = driver.getDevTools();
        obj.createSession();
        
        //Here we are enabeling network traffic for client and now client can listen it
        obj.send(Network.enable(Optional.empty(), Optional.empty(),  Optional.empty()));
        
       //For Requests
        obj.addListener(Network.requestWillBeSent(), requests -> 
        {
        	System.out.println("All about Requests: ");
        	Request Reqobj = requests.getRequest();
        	System.out.println("URL is: "+Reqobj.getUrl());
        	System.out.println("Method is: "+Reqobj.getMethod());
        	System.out.println("Policy: "+Reqobj.getReferrerPolicy());
        	System.out.println("Tokens: "+Reqobj.getTrustTokenParams());
        	System.out.println("*********************************************************");
        });
        
        //For Response
        obj.addListener(Network.responseReceived(), response ->
        {
          Response ResponseObj = response.getResponse();
         // if (ResponseObj.getStatus().toString().startsWith("4"))
          System.out.println("All about Responses: ");
          System.out.println("Response URL is: "+ResponseObj.getUrl());
          System.out.println("Response Status Code is: "+ResponseObj.getStatus());
          System.out.println("Response Header is: "+ResponseObj.getHeaders());
          System.out.println("*********************************************************");
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[text()=\" Virtual Library \"]")).click();    
	}

}
