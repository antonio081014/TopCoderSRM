import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class LCMSet
{
	public String equal(int[] A, int[] B)
	{
		ArrayList<Integer> a = compress(A);
		ArrayList<Integer> b = compress(B);
		if(a.size() != b.size()) return "Not equal";
		for(int i=0; i< a.size(); i++) {
            // Very important: Integer object cannot be simply compared by value only.
			if(a.get(i).intValue() != b.get(i).intValue()) 
				return "Not equal";
		}
		return "Equal";
	}
	
	private ArrayList<Integer> compress(int[] a)
	{
		Arrays.sort(a);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<a.length; i++){
			if(include(list, a[i]) == false) {
				list.add(a[i]);
			}
		}
		return list;
	}
	
	private boolean include(ArrayList<Integer> S, int x){
		long lcm = 1L;
		for(int i=0; i<S.size(); i++){
			if(x % S.get(i) ==0) {
				lcm = lcm / gcd(lcm, S.get(i)) * S.get(i);
			}
		}
		return lcm == x;
	}
	
	private long gcd(long a, long b)
	{
		if(b==0) return a;
		return gcd(b, a%b);
	}
}
//Powered by [KawigiEdit] 2.0!
