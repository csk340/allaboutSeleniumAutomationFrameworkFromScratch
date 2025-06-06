package section7DropdownandCalender;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EndToEndTestingBookFlights {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
	    //System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isSelected());
	    driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	    driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
	    System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isSelected());
	    driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
	    driver.findElement(By.xpath("//a[@value='HBX']")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("(//a[@value='CMB'])[2]")).click();//turning point imp
	    driver.findElement(By.className("ui-state-active")).click();//turning point imp
	    driver.findElement(By.id("divpaxinfo")).click();
	    driver.findElement(By.id("hrefIncAdt")).click();
	    driver.findElement(By.id("hrefIncChd")).click();
	    driver.findElement(By.id("hrefIncInf")).click();
	    driver.findElement(By.id("btnclosepaxoption")).click();
	   // WebElement a = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	    Select drpdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));//turning point imp (new word)
	    drpdown.selectByVisibleText("USD");
	    driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
	    driver.findElement(By.id("ctl00_mainContent_chk_Unmr")).click();
	    driver.findElement(By.id("autosuggest")).click();
	    driver.findElement(By.id("autosuggest")).sendKeys("ind");
	    List<WebElement> all = driver.findElements(By.xpath("//body/ul/li[@class='ui-menu-item']"));
	    for (int i=0;i<all.size();i++)
	    {
	    	String a = all.get(i).getText();
	    	if (a.equalsIgnoreCase("india"))
	    	{
	    		all.get(i).click();//turning point imp (a vr action keli but print or final action krtana old vrch (i.e. all)
	    	}
	    }
	    
	    System.out.println("Done All Process");
	    driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
	    
	    
	    
	}
}


