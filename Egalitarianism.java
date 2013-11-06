import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class Egalitarianism
{
	/*
	 * This problem is a graph problem.
	 * 
	 * 1st, if this problem had finite answer, 
	 * then it has to be a connected graph, 
	 * or we could have a very low amount for person from group1, 
	 * while having a very high amount for person from group2.
	 * 
	 * 2nd, the difference between two person depends on the distance person1 can reach to person2.
	 * So here we use Floyd Warshall algorithm to find the indirected distance from any two person.
	 *
	 * At last, we find the biggest distance from existings.
	 */
	public int maxDifference(String[] isF, int d)
	{
		int N = isF.length;
		int max = 0;
		int[][] cost = new int[N][N];
		
		boolean[] visit = new boolean[N];
		flood(isF, visit, 0);
		for(int i=0; i<N; i++) if(!visit[i]) return -1;
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				cost[i][j] = isF[i].charAt(j) == 'Y' ? 1 : 0;
			}
		}
		for(int k=0; k<N; k++){
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(cost[i][k] != 0 && cost[k][j] !=0) {
						if (cost[i][j] == 0) cost[i][j] = cost[i][k] + cost[k][j];
						else cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) for(int j=0; j<N; j++) if(i!=j) max = Math.max(max, cost[i][j]);
		//for(int i=0; i<N; i++, System.out.println()) for(int j=0; j<N; j++) System.out.print(cost[i][j] + " ");
		return max * d;
	}
	
	private void flood(String[] isF, boolean[] visit, int current){
		if(visit[current]) return;
		visit[current] = true;
		for(int i=0; i<isF[current].length(); i++){
			if(isF[current].charAt(i) == 'Y')
				flood(isF, visit, i);
		}
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new Egalitarianism().maxDifference(new String[]{"NYYY", "YNYY", "YYNY", "YYYN"}, 777);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 777;
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
		answer = new Egalitarianism().maxDifference(new String[]{"NN", "NN"}, 1);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1;
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
		answer = new Egalitarianism().maxDifference(new String[]{"NNYNNN", "NNYNNN", "YYNYNN", "NNYNYY", "NNNYNN", "NNNYNN"}, 1000);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 3000;
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
		answer = new Egalitarianism().maxDifference(new String[]{"NNYN", "NNNY", "YNNN", "NYNN"}, 584);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1;
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
		answer = new Egalitarianism().maxDifference(new String[]{"NYNYYYN", "YNNYYYN", "NNNNYNN", "YYNNYYN", "YYYYNNN", "YYNYNNY", "NNNNNYN"}, 5);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 20;
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
		answer = new Egalitarianism().maxDifference(new String[]{"NYYNNNNYYYYNNNN", "YNNNYNNNNNNYYNN", "YNNYNYNNNNYNNNN", "NNYNNYNNNNNNNNN", "NYNNNNYNNYNNNNN", "NNYYNNYNNYNNNYN", "NNNNYYNNYNNNNNN", "YNNNNNNNNNYNNNN", "YNNNNNYNNNNNYNN", "YNNNYYNNNNNNNNY", "YNYNNNNYNNNNNNN", "NYNNNNNNNNNNNNY", "NYNNNNNNYNNNNYN", "NNNNNYNNNNNNYNN", "NNNNNNNNNYNYNNN"}, 747);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2988;
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
		answer = new Egalitarianism().maxDifference(new String[]{"NY", "YN"}, 0);
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
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
