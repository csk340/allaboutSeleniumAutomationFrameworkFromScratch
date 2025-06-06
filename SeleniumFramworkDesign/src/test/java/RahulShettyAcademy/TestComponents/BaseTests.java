package RahulShettyAcademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import RahulShettyAcademy.PageObjectModelAndFactory.LandingPage;

public class BaseTests { //Reusable code or Boiler code

	protected String PName;
	 WebDriver driver;
	public LandingPage LPObj; 
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties propobj = new Properties();
		FileInputStream FISobj = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\RahulShettyAcademy\\Resources\\GlobalData.properties");
		propobj.load(FISobj);
	    String BrowserName = System.getProperty("browser") != null ? System.getProperty("browser") : propobj.getProperty("browser");
		
		if (BrowserName.contains("chrome"))
		{
		ChromeOptions obj = new ChromeOptions();
		if (BrowserName.contains("headless"))
		{
			obj.addArguments("headless");
		}
		 driver = new ChromeDriver(obj);
		 driver.manage().window().setSize(new Dimension(1440, 900));
		
		
		//But now to execute in any browser we need to set global property file 
		}
		else if (BrowserName.equalsIgnoreCase("FireFox"))
		{
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		return driver;
		
	
		}
	
	public List<HashMap<String, String>> getJsonToHashMap(String filepath) throws IOException 
	{
		//Step1: Reading JSON to String
		String jsonContent = FileUtils.readFileToString(new File (filepath), StandardCharsets.UTF_8);
	
	   //Step2: Converting String to HashMap using Jackson Databind dependency
		ObjectMapper mapper = new ObjectMapper();
		List <HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}
	
	public String getScreenShot(String TestCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot s =(TakesScreenshot) driver;
		File source = s.getScreenshotAs(OutputType.FILE);
		File  file = new File (System.getProperty("user.dir")+"//Reports" + TestCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//Reports" + TestCaseName+".png";
		
	}

@BeforeMethod (alwaysRun=true)
	public LandingPage LaunchApplication() throws IOException
	{
		driver = initializeDriver();
		LPObj = new LandingPage(driver);
		LPObj.GoTo();
		return LPObj;
	}

@AfterMethod (alwaysRun=true)
public void CloseBrowser()
{
	driver.quit();
}
}
