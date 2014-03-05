import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class LCMSetEasy
{
	public String include(int[] S, int x)
	{
		int count = 0;
		long lcm = 1L;
		for(int i=0; i<S.length; i++){
			if(x % S[i] ==0) {
				count++;
				long div = gcd(lcm, S[i]);
				lcm = div * (lcm / div) * (S[i] / div);
			}
		}
		if(lcm == x) return "Possible";
		return "Impossible";
	}
	
	private long gcd(long a, long b){
		if(b ==0) return a;
		return gcd(b, a%b);
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
