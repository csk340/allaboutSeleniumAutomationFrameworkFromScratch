package section14JavaStreams;

import java.util.Arrays;
import java.util.List;

public class Assignment116Lecture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Take Array -> (3,2,2,7,5,1,9,7);
		 * WAPTP unique number from this array and also sort the array
		 */
		
		int[] a = {3,2,2,7,5,1,9,7};
		List<int[]> intlist = Arrays.asList(a);
		intlist.stream().distinct().sorted().forEach(s->System.out.println(s));
	}

}
