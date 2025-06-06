package Section2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduciton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//WebDriver driver = new ChromeDriver(); //Create object of an class to access its method
		WebDriver driver = new EdgeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//driver.close();
	}

}

//3rd december -> call from COGNIZENT CONTRACT