package section14JavaStreams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class JavaStreamsFilterBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> a = new ArrayList<String>();
		a.add("Chinmay");
		a.add("Siddheshware");
		a.add("Raju");
		a.add("Akash");
		a.add("Vaidehi");
		a.add("Vikas");
		
		System.out.println(a);
		
		//Print all elements which starts from using Java streams
		Long b = Stream.of("Chinmay","Siddheshware","Raju","Akash","Vaidehi","Vikas").filter(s->
		{
			s.startsWith("V");
			return true;
		}).count();
		System.out.println(b);
		a.stream().filter(s->s.startsWith("V")).forEach(s->System.out.println(s));
		a.stream().filter(s->s.length()>5).limit(2).forEach(s->System.out.println(s));
	}

}
