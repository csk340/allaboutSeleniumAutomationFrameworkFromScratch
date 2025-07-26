package Section35FileUploadAndDwnldusingAUTOIT;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class FileUploadUsingAUTOIT {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://png2pdf.com/");
		driver.findElement(By.xpath("//span[text()=\"UPLOAD FILES\"]")).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\AKASH KULKARNI\\Documents\\FileUpload.exe");
	}

}
