package Section16FW1TestNG;

import org.testng.annotations.Test;

public class HelperAttribute {
	
	//Please run B() method first and then A() -> For this need to use depends helper attribute
	//-> Do not use () this methods bracket here else error
	
	
	@Test  (enabled=false) //To skip any method as we know here test will fail due to KP issue
	public void A()
	{
		System.out.println("I am from A method ");
	}
	
	
	@Test (dependsOnMethods={"C"})
	public void B()
	{
		System.out.println("I am from B method ");
	}
	
	@Test (timeOut=4000)
	public void C()
	{
		System.out.println("I am from C method ");
	}

}
