import java.util.HashSet;
import java.util.Set;

public class AmebaDiv1 {

	/**
	 * From the statement, we know, if any number doesn't appear in the X array,
	 * the result will be that number. Nothing changed.
	 * 
	 * So, we are using only the unique numbers from the array as our initial
	 * number a. The order of the number really doesn't matter, so a Set will be
	 * our ideal choice here. At the end, we need to testify if the result
	 * number could be one of unique numbers in our set. If it is, then remove
	 * it from our array(set2).
	 * */
	public int count(int[] X) {
		Set<Integer> set = new HashSet<Integer>();
		for (int a : X)
			set.add(a);
		Set<Integer> set2 = new HashSet<Integer>(set);
		for (int a : set) {
			for (int i = 0; i < X.length; i++) {
				if (a == X[i])
					a += X[i];
			}
			if (set2.contains(a))
				set2.remove(a);
		}
		return set2.size();
	}

}
