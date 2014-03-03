import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class CirclesCountry
{
	public int leastBorders(int[] X, int[] Y, int[] R, int x1, int y1, int x2, int y2)
	{
		int ret = 0;
		for(int i=0; i<X.length; i++){
			if(inSide(X[i], Y[i], R[i], x1, y1) ^ inSide(X[i], Y[i], R[i], x2, y2)) ret++;
		}
		return ret;
	}
	
	private boolean inSide(int x, int y, int r, int xx, int yy){
		return (xx-x)*(xx-x) + (yy-y)*(yy-y) <= r*r;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new CirclesCountry().leastBorders(new int[]{0}, new int[]{0}, new int[]{2}, -5, 1, 5, 1);
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
		answer = new CirclesCountry().leastBorders(new int[]{0,-6,6}, new int[]{0,1,2}, new int[]{2,2,2}, -5, 1, 5, 1);
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
		answer = new CirclesCountry().leastBorders(new int[]{1,-3,2,5,-4,12,12}, new int[]{1,-1,2,5,5,1,1}, new int[]{8,1,2,1,1,1,2}, -5, 1, 12, 1);
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
		answer = new CirclesCountry().leastBorders(new int[]{-3,2,2,0,-4,12,12,12}, new int[]{-1,2,3,1,5,1,1,1}, new int[]{1,3,1,7,1,1,2,3}, 2, 3, 13, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 5;
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
		answer = new CirclesCountry().leastBorders(new int[]{-107,-38,140,148,-198,172,-179,148,176,153,-56,-187}, new int[]{175,-115,23,-2,-49,-151,-52,42,0,68,109,-174}, new int[]{135,42,70,39,89,39,43,150,10,120,16,8}, 102, 16, 19, -108);
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
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
