package section14JavaStreams;

import java.util.ArrayList;

public class maps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> a = new ArrayList<String>();
		a.add("Chinmay");
		a.add("Siddheshware");
		a.add("Rajui");
		a.add("Akashi");
		a.add("Vaidehi");
		a.add("Vikas");
		
		a.stream().filter(s->s.startsWith("V")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		System.out.println("------------------------------------------------------------------------");
		a.stream().forEach(s->System.out.println(s));
		System.out.println("------------------------------------------------------------------------");
		a.stream().filter(s->s.endsWith("i")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
		System.out.println("------------------------------------------------------------------------");
		a.stream().map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
		
		
		
	}

}
