package section17JAVNeededForFramework;

import org.testng.annotations.Test;

public class InheritanceInTestNG1 extends InheritanceInTestNG{

	
	
	@Test
	public void execute()
	{
		int a=3;
		THISKeyword obj = new THISKeyword(3);
		System.out.println(obj.increment());
		System.out.println(obj.decrement());
		
		
	}
	
	@Test
	public void Child()
	{
		
		TestParent();
	}
	
	@Test
	public void ChildsMethod()
	{
		System.out.println("I am from child method");
	}
}
