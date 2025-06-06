package section16FWTestNGAnnotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test3 {
	
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("Before class from Test 3");
	}

	@Test
	public void MobilePersonalLoan()
	{
		System.out.println("Personalloan | Mobile");
	}
	
	@Test
	public void WebPersonalLoan()
	{
		System.out.println("PersonalLoan | Web");
	}
	
	@Test
	public void TabPersonalLoan()
	{
		System.out.println("PersonalLoan | Tab");
	}
	
	@BeforeTest
	public void beforetest()
	{
		System.out.println("I am the first above all tests");
	}
	
	@BeforeSuite
	public void beforesuit()
	{
		System.out.println("I am the top most from suite");
	}
	
	@AfterClass
	public void afterclass()
	{
		System.out.println("After class from Test 3");
	}
}
