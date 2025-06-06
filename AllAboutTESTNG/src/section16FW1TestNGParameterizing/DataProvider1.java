package section16FW1TestNGParameterizing;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	
	
	@Test (dataProvider="getdata")
	public void testDataProvider(String Username, String Password)
	{
		System.out.println("I am from data provider");
		System.out.println(Username);
		System.out.println(Password);
	}
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] Credentials = new Object[3][2];
		//[3] : Number of combinations : Number of rows (possiblities/scenario)
		//[2] : Total number of values for each combination : Number of columns (No. of credentials to check)
		/*
		 * Comb.1 :- Good Credit History acc1
		 * Comb.2 :- No Credit History acc2
		 * Comb.3 :- Fraud Credit History acc3
		 */
		Credentials[0][0] = "acc1usernmae";
		Credentials[0][1] = "acc1password";
		
		Credentials[1][0] = "acc2usernmae";
		Credentials[1][1] = "acc2password";
		
		Credentials[2][0] = "acc3usernmae";
		Credentials[2][1] = "acc3password";
		return Credentials;
	}

}
