import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class LittleElephantAndString
{
	public int getNumber(String A, String B)
	{
		int[] cnt = new int[26];
		for(int i=0; i<A.length(); i++){
			cnt[A.charAt(i)-'A']++;
			cnt[B.charAt(i)-'A']--;
		}
		for(int i=0; i<26; i++){
			if(cnt[i]!=0) return -1;
		}
		
		int j=B.length()-1;
		int ret = A.length();
		for(int i=A.length()-1; i>=0; i--){
			if(A.charAt(i) == B.charAt(j)){
				ret--;
				j--;
			}
			//if(j<0) return ret;
		}
		return ret;
	}
}
//Powered by [KawigiEdit] 2.0!
