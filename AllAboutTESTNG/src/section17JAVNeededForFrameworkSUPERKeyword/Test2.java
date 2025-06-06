package section17JAVNeededForFrameworkSUPERKeyword;

import org.testng.annotations.Test;

public class Test2 extends Test1 {

	public void test2()
	{
		System.out.println("Hello I am from test2");
	}
	
	@Test
	public void TestRun()
	{
		Test3 obj = new Test3(3);
		int a=3;
		System.out.println(obj.addition());
		System.out.println(obj.multiplyByThree());
	}
	
}
