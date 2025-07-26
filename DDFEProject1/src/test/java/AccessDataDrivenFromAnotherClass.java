import java.io.IOException;
import java.util.ArrayList;

public class AccessDataDrivenFromAnotherClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataDrivenDemo obj = new DataDrivenDemo();
		ArrayList a =obj.getData("Purchase");
	    System.out.println(a.get(0));
	    System.out.println(a.get(1));
	    System.out.println(a.get(2));
	    System.out.println(a.get(3));
	}

}
