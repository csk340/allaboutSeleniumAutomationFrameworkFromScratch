package RahulShettyAcademy.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.naming.Context;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;
import RahulShettyAcademy.PageObjectModelAndFactory.CartPage;
import RahulShettyAcademy.PageObjectModelAndFactory.LandingPage;
import RahulShettyAcademy.PageObjectModelAndFactory.OrderPage;
import RahulShettyAcademy.PageObjectModelAndFactory.ProductCatelog;
import RahulShettyAcademy.TestComponents.BaseTests;


public class StandAloneTest2 extends BaseTests
{
	

	@Test(dataProvider="getData",groups="Purchase")
	public void StandAloneSubmitOrder(HashMap <String, String> input) throws IOException, InterruptedException
	{
		String productName = input.get("PName");
        String countryinit = "indi";

        ProductCatelog PCobj = LPObj.Action(input.get("EmailID"), input.get("pwd"));
        List<WebElement> List = PCobj.GetProductList();
        PCobj.GetProductByName(productName);
        PCobj.AddProductToCart(productName);
        Thread.sleep(6000);
        CartPage CPobj = PCobj.CartSelection();

        Boolean match = CPobj.CartCheckForSelectedItem(productName);
        Assert.assertTrue(match);
        CPobj.checkout();
        CPobj.fillCheckoutDetails(countryinit);
        String a = CPobj.PlaceOrder();
        Assert.assertEquals(a, "THANKYOU FOR THE ORDER.");

	}


	 @Test(dataProvider = "getData", dependsOnMethods = { "StandAloneSubmitOrder" })
	    public void OrderHistory(HashMap<String, String> input) {
	        String productName = input.get("PName");
	        ProductCatelog PCobj = LPObj.Action(input.get("EmailID"), input.get("pwd"));
	        OrderPage obj = PCobj.OrdersPage();
	        Assert.assertTrue(obj.CheckOrderHistory(productName));
	    }	
	//Using JSON file
	//So now we will read the data from JSON file and convert it into HashMap
	
	 @DataProvider
	    public Object[][] getData() throws IOException {
	        List<HashMap<String, String>> data = getJsonToHashMap(System.getProperty("user.dir")
	                + "\\src\\test\\java\\RahulShettyAcademy\\data\\PurchaseOrder.json");
	        return new Object[][] { { data.get(0) }};
	    }
	
}

//Using HashMap
//HashMap <Object,Object> HashObj = new HashMap<Object, Object>();
//HashObj.put("EmailID", "CSK567@gmail.com");
//HashObj.put("pwd", "Chinmay@234");
//HashObj.put("PName", "ZARA COAT 3");
//
//HashMap <Object,Object> HashObj1 = new HashMap<Object, Object>();
//HashObj1.put("EmailID", "johnson@gmail.com");
//HashObj1.put("pwd", "Chinmay@234");
//HashObj1.put("PName", "IPHONE 13 PRO");

//	public Object[][] getData()  //According to Sir
//	{
//		return new Object[][] {{"CSK567@gmail.com","Chinmay@234","ZARA COAT 3"},{"johnson@gmail.com","Chinmay@234", "IPHONE 13 PRO"}};
//		
//	}
	
	
	
//	public Object[][] getData()  //According to Me
//	{
//		Object[][] abc = new Object[2][3];
//		                   //Object[r][c]
//		//rows: Combinations
//		//columns: number of values for each combination
//		abc[0][0] = "CSK567@gmail.com";
//		abc[0][1] = "Chinmay@234";
//		abc[0][2] = "ZARA COAT 3";
//		
//		abc[1][0] = "johnson@gmail.com";
//		abc[1][1] = "Chinmay@234";
//		abc[1][2] = "IPHONE 13 PRO";
//		
//		return abc;
//		
//				
//	}

	
    

