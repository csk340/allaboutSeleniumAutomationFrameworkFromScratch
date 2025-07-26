import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GridForParallellsystemExecution {
	
	@Test
	public void MyFirstGridProject()
	{
		WebDriver driver = new ChromeDriver(); //We cannot initialize driver using own method cause here we are intentially asking to run on chrome
		//browser but we need to run using Hub and Node. Hence there is different way to initialize drivers
		driver.get("https://www.facebook.com/");
	}

}
