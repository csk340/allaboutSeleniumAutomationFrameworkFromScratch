package section16FW1TestNGParameterizing;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Class1 {

	@Parameters ({"URL", "KEY"})
	@Test 
	public void abc(String A, String B)
	{
		System.out.println("ABC");
	    System.out.println(A);
	    System.out.println(B);
	    System.out.println("check for URL and key at a time");
	}
	
	@Parameters ({"KEY"})
	@Test
	public void xyz(String c)
	{
		System.out.println("XYZ");
		System.out.println(c);
	}
	
	@Test
	public void pqr()
	{
		System.out.println("PQR");
	}
	
}
