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
