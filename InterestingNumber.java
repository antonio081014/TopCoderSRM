import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class InterestingNumber
{
	public String isInteresting(String x)
	{
		int[] start = new int[10];
		int[] cnt = new int[10];
		Arrays.fill(start, -1);
		for(int i=0; i<x.length(); i++){
			int c = x.charAt(i) - '0';
			cnt[c] ++;
			if(cnt[c] > 2) return "Not interesting";
			if(start[c] == -1) {
				//if(c ==0 || c == 1) continue;
				start[c] = i;
			} else {
				int len = i - start[c] - 1;
				if (len != c) return "Not interesting";
				start[c] = -1;
			}
		}
		for(int i=0; i<10; i++)
			if(cnt[i]==1) return "Not interesting";
		return "Interesting";
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
