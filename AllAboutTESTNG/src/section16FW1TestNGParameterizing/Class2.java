package section16FW1TestNGParameterizing;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Class2 {

	@Test
	public void myfirsttesttngtest()
	{
		System.out.println("Hello welcome to TestNG world..!! Go crush it..!!");
		
	}
	
	@Parameters ({"URL"})
	@Test 
	public void def(String b)
	{
		System.out.println("DEF");
		System.out.println(b);
	}
	
	@Test
	public void lmn()
	{
		System.out.println("LMN");
	}
	
	@Test
	public void ghi()
	{
		System.out.println("GHI");
	}
	
	
}
