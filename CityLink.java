import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class CityLink
{
	
	public int timeTaken(int[] x, int[] y)
	{
		int N = x.length;
		int[][] dist = new int[N][N];
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++) 
				dist[i][j] = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++) 
				dist[i][j] = distance(x[i], y[i], x[j], y[j]);
		
		
        // Floyd Graph Algorithms, calculate the minimum time(distance) between any two cities.
		for(int k=0; k<N; k++){
			for(int i=0; i<N; i++){
				//if(i==k)continue;
				for(int j=0; j<N; j++){
					//if(j==k || j==i) continue;
                    //Here is the key. To connect the two cities through one, this is how we calculate the cost(distance).
					dist[i][j] = Math.min(dist[i][j], Math.max(dist[i][k], dist[k][j]));
				}
			}
		}
		int max = 0;
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++)
				max = Math.max(max, dist[i][j]);
		
		return max;
	}
	
	private int distance(int x1, int y1, int x2, int y2){
		if(x1 == x2) return (Math.abs(y1-y2)+1)/2;
		if(y1 == y2) return (Math.abs(x1-x2)+1)/2;
		return Math.max(Math.abs(x1-x2), Math.abs(y1-y2));
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new CityLink().timeTaken(new int[]{0,5}, new int[]{0,5}	);
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
		answer = new CityLink().timeTaken(new int[]{0,0}, new int[]{30,-59});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 45;
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
		answer = new CityLink().timeTaken(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26, 27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49}	, new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26, 27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49});
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
		answer = new CityLink().timeTaken(new int[]{100000}, new int[]{-1000000});
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
		answer = new CityLink().timeTaken(new int[]{1593,-88517,14301,3200,6,-15099,3200,5881,-2593,11,57361,-92990}, new int[]{99531,-17742,-36499,1582,46,34001,-19234,1883,36001,0,233,485});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 73418;
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
