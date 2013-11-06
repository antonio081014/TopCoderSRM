import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class FlippingBitsDiv2
{
	private HashMap<String, Integer> map;
	public int getmin(String[] S, int M)
	{
		String s = "";
		for(int i=0; i<S.length; i++) s += S[i];
		int min = Integer.MAX_VALUE;
		String sr = reverse(s);
		int N = s.length();
		System.out.println(N);
		map = new HashMap<String, Integer>();
		for(int i=0; i<N/M; i++){
			min = Math.min(min, solve(s.substring(0, i), M) + solve(sr.substring(0, sr.length()-i), M));
		}
		return min;
	}
	
	private int solve(String s, int M){
		if(map.containsKey(s)) return map.get(s);
		if(s == null || s.length() == 0) return 0;
		
		int count = 0;
		for(int i=0; i<M; i++) 
			if(s.charAt(s.length() - i - 1) == '0')
				count++;
		String flip = "";
		for(int i=0; i<s.length()-M; i++){
			flip += s.charAt(i)=='1'?'0':'1';
		}
		return Math.min(count + solve(s.substring(0, s.length()-M), M), 1 + M - count + solve(flip, M));
	}
	
	private String reverse(String s){
		return (new StringBuffer(s)).reverse().toString();
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new FlippingBitsDiv2().getmin(new String[]{"00111000"}, 1);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2;
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
		answer = new FlippingBitsDiv2().getmin(new String[]{"00111000"}, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 3;
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
		answer = new FlippingBitsDiv2().getmin(new String[]{"111111"}, 3);
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
		answer = new FlippingBitsDiv2().getmin(new String[]{"00100"}, 5);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2;
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
		answer = new FlippingBitsDiv2().getmin(new String[]{"00010","11010110","1010111","110001010","0110001100","000110110","011010101","00","111","100"}, 13);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 31;
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
