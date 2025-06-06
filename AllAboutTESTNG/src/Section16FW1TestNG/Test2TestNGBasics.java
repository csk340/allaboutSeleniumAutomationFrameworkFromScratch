package Section16FW1TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Test2TestNGBasics {

	//It's all about Home Loan
		@Test
		public void MobiletestClassHomeLoan()
		{
			System.out.println("HomeLoan | Mobile");
		}
		
		@Test
		public void testClassHomeWebLoan()
		{
			System.out.println("Homeloan | Web");
		}
		
		@Test (groups= {"Smoke"})
		public void testClassHomeTabLoan()
		{
			System.out.println("Homeloan | Tab");
		}
}
