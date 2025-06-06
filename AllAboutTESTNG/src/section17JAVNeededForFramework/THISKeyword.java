package section17JAVNeededForFramework;

public class THISKeyword {

	int a;
	public THISKeyword(int a) {
		// TODO Auto-generated constructor stub
		this.a=a; // Here we just assigning value of instance variable a to this class's local variable a so that we can use it globally 
	}

	public int increment()
	{
		a=a+1;
		return a;
	}
	
	public int decrement()
	{
		a=a-1;
		return a;
	}
}
