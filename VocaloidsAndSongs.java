import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class VocaloidsAndSongs
{
	private static final int MOD = 1000000007;
	private int[][][][] mark;
	public int count(int S, int gumi, int ia, int mayu)
	{
		mark = new int[S+1][gumi+1][ia+1][mayu+1];
		for(int i=0; i<=S; i++) for(int j=0; j<=gumi; j++)
		for(int m=0; m<=ia; m++) for(int n=0; n<=mayu; n++)
		mark[i][j][m][n] = -1;
		
		return solve(S, gumi, ia, mayu);
	}
	
	private int solve(int s, int a, int b, int c){
		if(mark[s][a][b][c] != -1) return mark[s][a][b][c];
		if(s == 0)
		{
			if(a==0 && b==0 && c==0) return mark[s][a][b][c] = 1;
			else return mark[s][a][b][c] = 0;
		}
		
		long res = 0L;
		if(a>0 && b>0 && c>0) res += solve(s-1, a-1,b-1,c-1);res %= MOD;
		if(a>0 && b>0) res += solve(s-1, a-1,b-1,c);res %= MOD;
		if(c>0 && b>0) res += solve(s-1, a,b-1,c-1);res %= MOD;
		if(a>0 && c>0) res += solve(s-1, a-1,b,c-1);res %= MOD;
		if(a>0) res += solve(s-1, a-1,b,c);res %= MOD;
		if(b>0) res += solve(s-1, a,b-1,c);res %= MOD;
		if(c>0) res += solve(s-1, a,b,c-1);res %= MOD;
		
		return mark[s][a][b][c] = (int)res;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new VocaloidsAndSongs().count(3, 1, 1, 1);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 6;
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
		answer = new VocaloidsAndSongs().count(3, 3, 1, 1);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 9;
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
		answer = new VocaloidsAndSongs().count(50, 10, 10, 10);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0;
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
		answer = new VocaloidsAndSongs().count(18, 12, 8, 9);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 81451692;
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
		answer = new VocaloidsAndSongs().count(50, 25, 25, 25);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 198591037;
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
