package Section3CoreJAVABasics;

public class EnhancedForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ArrayString = new 	String [3];
		ArrayString[0] = "Chinmay";
		ArrayString[1] = "Shrikant";
		ArrayString[2] = "Kulkarni";
		
		
		for (String New : ArrayString)             //for ( Data type      new name      : old name of array) and print using new name
		{
			System.out.println(New);
		}
		
		//WAP to print numbers from array which are divisible by 2 or even number
		int [] Values = {2,4,5,7,8,6,10,23,67,88,90,65,35,76,432};
		for (int multiple : Values)
		{
			if (multiple%2==0)
			{
			System.out.println(multiple);
			}
		}
		System.out.println(" HERE IS ANSWER FOR YOUR ASSIGNMENT:- ");
		double[] numbers = new double[5];
	    numbers[0]=1.25;
	    numbers[1]=3;
	    numbers[2]=34.56;
	    numbers[3]=10;
	    numbers[4]=4.4;
	    
	    System.out.println(numbers[0]);
	    System.out.println(numbers[4]);
	    System.out.println(" ");
	    
	    for (int i=numbers.length-1;i>=0;i--)
	    {
	        System.out.println(numbers[i]);
	    }
	    
	    System.out.println("Total number of elements within array are " + numbers.length);
	}

}
