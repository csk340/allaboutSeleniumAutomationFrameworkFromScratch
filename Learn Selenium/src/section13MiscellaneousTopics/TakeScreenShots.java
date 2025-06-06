package section13MiscellaneousTopics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenShots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("E:\\\\TakeAutomaticScreenshotsUsingSeleniumAndStoreHere\\Screenshot1r.png"));
		
		//Need to use FileHandler and copy instead of FileUtils and copyFile as per new version
		//FileUtils.copyFile(src, new File("E:\\TakeAutomaticScreenshotsUsingSeleniumAndStoreHere"));
	}

}
