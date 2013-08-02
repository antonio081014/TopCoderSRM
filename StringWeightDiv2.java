/* This algorithm is from misof.
Suppose you want to count the number of solutions to x1+x2+x3+x4+...x26 = L such that all xi are positive integers. Set yi = xi-1, then all yi are non-negative integers that satisfy y1+...+y26 = L-26.

Now, this new equation can be read as follows: in how many ways can L-26 tokens be distributed into 26 labeled boxes?

Imagine the tokens all in a row: o o o o o o o o ...
Now, we take 25 separators and place them arbitrarily into the row: o o o | o | | o o | ...
Different ways of adding the separators correspond to different solutions. For example, the way shown above corresponds to y1=3, y2=1, y3=0, y4=2, ...

Thus the number of solutions to our original equation is the same as the number of ways in which you can put P=L-26 tokens and Q=25 separators into a row. And this is C(P+Q,Q), where C is the binomial coefficient: out of P+Q positions in the row, we choose the Q that contain the separators.

Hence, the number of solutions to the original equation is C(L-1,25).
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class StringWeightDiv2
{
	private static final int MOD = 1000000009;
	public int countMinimums(int L)
	{
		if(L <= 26) return factor(26 - L + 1, 26) % MOD;
		return (int)((factor(1, 26) * C(L-1, 25)) % MOD);
	}
	
	public int factor(int l, int r){
		long ret = 1;
		for(int i=l; i<=r; i++){
			ret *= i%MOD;
			ret %= MOD;
		}
		return (int)ret;
	}
	
	private long C(int n, int k) {
		long nom = 1;
		long dem = 1;
		for (int i = 0; i < k; i++) {
			nom = (nom * (n - i)) % MOD;
			dem = (dem * (i + 1)) % MOD;
		}
		return (nom * BigInteger.valueOf(dem)
				.modInverse(BigInteger.valueOf(MOD)).longValue()) % MOD;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new StringWeightDiv2().countMinimums(1);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 26;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new StringWeightDiv2().countMinimums(2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 650;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new StringWeightDiv2().countMinimums(50);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 488801539;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
