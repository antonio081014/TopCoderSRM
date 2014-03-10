import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class AlienAndGame
{
	public int getNumber(String[] board)
	{
		int n = board.length;
		int m = board[0].length();
		int[][] count = new int[n][m];
		for(int i=0; i<n; i++){
			count[i][0] = 1;
			for(int j=1; j<m; j++){
                // if(i>0 && j>0 && board[i].charAt(j) == board[i].charAt(j-1) && board[i-1].charAt(j) == board[i-1].charAt(j-1))
                // count[i][j] = 1 + Math.min(count[i-1][j], Math.min(count[i][j-1], count[i-1][j-1]));
				if(board[i].charAt(j) == board[i].charAt(j-1)) {
					count[i][j] = count[i][j-1] + 1;
				} else {
					count[i][j] = 1;
				}
				//System.out.print(" " + count[i][j]);
			}
			//System.out.println();
		}
		
		int max = 1;
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				for(int k = Math.min(i+1, count[i][j]); k>1; k--){
					boolean flag = true;
					for(int p=0; p<k; p++){
						if(count[i-p][j] >= k) continue;
						else {flag = false; break;}
					}
					if(flag) {max = Math.max(max, k); break;}
				}
			}
		}
		
		return max * max;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new AlienAndGame().getNumber(new String[]{"BB", "WW"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 4;
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
		answer = new AlienAndGame().getNumber(new String[]{"W"});
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
		answer = new AlienAndGame().getNumber(new String[]{"WBBB", "WBBB", "WWWW"});
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
		answer = new AlienAndGame().getNumber(new String[]{"W", "B", "W", "W", "W"});
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
		answer = new AlienAndGame().getNumber(new String[]{"BWBBWBB", "WWBWWBW", "BBBBBBW", "WBBBBWB", "BBWWWWB", "WWWWWWW", "BBWWBBB"});
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
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
