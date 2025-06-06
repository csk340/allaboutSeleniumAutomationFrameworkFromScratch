package section7DropdownandCalender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select; 
public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	    //Handling Currency Dropdown
	    Select obj = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
	    obj.selectByContainsVisibleText("AE");
	    System.out.println((driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).getText()));
	    obj.selectByIndex(0);
	    System.out.println((driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).getText()));
	    obj.selectByValue("USD");
	    System.out.println((driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).getText()));
	    Thread.sleep(4000);
	    obj.selectByVisibleText("INR");
        System.out.println((driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).getText()));
        
        
	   
        

	}

}
