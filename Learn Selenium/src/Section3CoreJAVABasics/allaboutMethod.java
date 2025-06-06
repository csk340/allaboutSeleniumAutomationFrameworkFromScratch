package Section3CoreJAVABasics;

public class allaboutMethod {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		allaboutMethod obj = new allaboutMethod();
		obj.ChinmayMethod();
		String returnValue = obj.MethodWitReturnType();
		//System.out.println(returnValue);
	}

	
	
	//All methods should be declared in class block
	public void ChinmayMethod()
	{
		System.out.println("My first method from chinmay");
	}
	
	
	//Method with return type
	public String MethodWitReturnType()
	{
		System.out.println("My method with return type");
		return "Yes somthing is returning here";
		
	}
}
