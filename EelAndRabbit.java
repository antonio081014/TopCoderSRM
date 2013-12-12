import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class EelAndRabbit
{
	public int getmax(int[] l, int[] t)
	{
		int n = l.length;
		int max1 = 0;
		int max2 = 0;
		
		for(int i=0; i<n; i++){
			int cnt = 0;
			for(int j=i+1; j<n; j++){
				if(i!=j && met(t[i], t[j], t[j]+l[j])) cnt++;
			}
			if(cnt > max1) {max2 = max1; max1 = cnt;}
			
			cnt = 0;
			for(int j=i+1; j<n; j++){
				if(i!=j && met(t[i]+l[i], t[j], t[j]+l[j])) cnt++;
			}
			if(cnt > max1) {max2 = max1; max1 = cnt;}
			
		}
		System.out.println(max1);
		System.out.println(max2);
		return max1+max2;
	}
	
	private boolean met(int a, int a2, int b2)
	{
		if(a2>a || b2<a) return false;
		return true;
	}
	

	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new EelAndRabbit().getmax(new int[]{2, 4, 3, 2, 2, 1, 10}, new int[]{2, 6, 3, 7, 0, 2, 0});
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
		answer = new EelAndRabbit().getmax(new int[]{1, 1, 1}, new int[]{2, 0, 4});
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
		answer = new EelAndRabbit().getmax(new int[]{1}, new int[]{1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1;
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
		answer = new EelAndRabbit().getmax(new int[]{8, 2, 1, 10, 8, 6, 3, 1, 2, 5}, new int[]{17, 27, 26, 11, 1, 27, 23, 12, 11, 13});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 7;
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
