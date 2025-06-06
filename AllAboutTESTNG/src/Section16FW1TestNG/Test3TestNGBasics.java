package Section16FW1TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Test3TestNGBasics {

	//It's all about Personal Loan
		@Test
		public void MobiletestClassPersonalLoan()
		{
			System.out.println("Personaloan | Mobile");
		}
		
		@Test (groups= {"Smoke"})
		public void testClassPersonaWebLoan()
		{
			System.out.println("Personaloan | Web");
		}
		
		@Test
		public void testClassPersonaTabLoan()
		{
			System.out.println("Personaloan | Tab");
		}
}
