package section16FWTestNGAnnotation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {

	@AfterSuite
	public void aftersuite()
	{
		System.out.println("I am the bottom most from suite");
	}
	@AfterTest
	public void aftertest()
	{
		System.out.println("I am the LAST of all test");
	}
	@Test
	public void MobileCarLoan()
	{
		System.out.println("Carloan | Mobile");
	}
	
	@Test
	public void WebCarLoan()
	{
		System.out.println("Carloan | Web");
	}
	
	@Test
	public void TabCarLoan()
	{
		System.out.println("Carloan | Tab");
	}
	
	@BeforeMethod
	public void beforeallmethod()
	{
		System.out.println("Before all methods");
	}
	
	@AfterMethod
	public void afterallmethod()
	{
		System.out.println("After all methods from Test 1");
	}
}
