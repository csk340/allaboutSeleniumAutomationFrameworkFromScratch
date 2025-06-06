package section16FWTestNGAnnotation;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {

	@Test
	public void MobileHomeLoan()
	{
		System.out.println("Homeloan | Mobile");
	}
	
	@Test
	public void WebHomeLoan()
	{
		System.out.println("HomeLoan | Web");
	}
	
	@Test
	public void TabHomeLoan()
	{
		System.out.println("HomeLoan | Tab");
	}
	
	@AfterMethod
	public void afterallmethod()
	{
		System.out.println("After all methods from Test 2");
	}
}
