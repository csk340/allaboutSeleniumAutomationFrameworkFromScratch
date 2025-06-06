package Section16FW1TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class TestNGBasics {

	@Test
	public void myfirsttesttngtest()
	{
		System.out.println("Hello welcome to TestNG world..!! Go crush it..!!");
		System.out.println("");
	}
	
	
	@Test (groups= {"Smoke"})
	public void test()
	{
		System.out.println("Hello");
		System.out.println("");
	}
}
