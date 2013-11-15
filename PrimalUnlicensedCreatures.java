import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class PrimalUnlicensedCreatures
{
	public int maxWins(int cur, int[] gp)
	{
		Arrays.sort(gp);
		int cnt = 0;
		for(int i=0; i<gp.length; i++){
			if(cur > gp[i]){
				cur += gp[i] / 2;
				cnt++;
			} else
				return cnt;
		}
		return cnt;
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
