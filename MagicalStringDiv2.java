import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class MagicalStringDiv2
{
	public int minimalMoves(String s)
	{
		int total = 0;
		for(int i=0; i<s.length()/2; i++)
			if(s.charAt(i) == '<') total++;
		for(int i=s.length()/2; i<s.length(); i++)
			if(s.charAt(i) == '>') total++;
		return total; 
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
