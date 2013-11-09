import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class BlackAndWhiteSolitaire
{
	// Just go through string with two possibility, one starts with W, one starts with B.
	public int minimumTurns(String card)
	{
		int min1 = 0;
		for(int i=0, j=0; i<card.length(); i++){
			if(j==0 &&  card.charAt(i)!='B') min1++;
			else if(j==1 && card.charAt(i) !='W') min1++;
			j = 1-j; 
		}
		int min2 = 0;
		for(int i=0, j=0; i<card.length(); i++){
			if(j==0 && card.charAt(i)=='B') min2++;
			else if(j==1 && card.charAt(i)=='W') min2++;
			j = 1-j;
		}
		return Math.min(min1, min2);
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
