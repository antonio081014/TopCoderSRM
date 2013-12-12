import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ArcadeManao
{
	private int h;
	private int w;
	private boolean[][] visited;
	public int shortestLadder(String[] level, int coinRow, int coinColumn)
	{
		h = level.length;
		w = level[0].length();
		for(int l=0; l<=h; l++){
			visited = new boolean[h][w];
			valid(level, h-1, 0, l);
			if(visited[coinRow-1][coinColumn-1]) return l;
		}
		return -1;
	}
	
	private void valid(String[] level, int r, int c, int L) 
	{
		if(visited[r][c]) return;
		visited[r][c] = true;
		
		if(c+1 < w && level[r].charAt(c+1)=='X') valid(level, r, c+1, L);
		if(c-1 >= 0 && level[r].charAt(c-1)=='X') valid(level, r, c-1, L);
		for(int i=1; i<=L; i++){
			if(i+r < h && level[i+r].charAt(c) == 'X') valid(level, i+r, c, L);
			if(r-i >= 0 && level[r-i].charAt(c) == 'X') valid(level, r-i, c, L);
		}
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new ArcadeManao().shortestLadder(new String[]{"XXXX....", "...X.XXX", "XXX..X..", "......X.", "XXXXXXXX"}, 2, 4);
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
		answer = new ArcadeManao().shortestLadder(new String[]{"XXXX", "...X", "XXXX"}, 1, 1);
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
		answer = new ArcadeManao().shortestLadder(new String[]{"..X..", ".X.X.", "X...X", ".X.X.", "..X..", "XXXXX"}, 1, 3);
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
		answer = new ArcadeManao().shortestLadder(new String[]{"X"}, 1, 1);
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
		answer = new ArcadeManao().shortestLadder(new String[]{"XXXXXXXXXX", "...X......", "XXX.......", "X.....XXXX", "..XXXXX..X", ".........X", ".........X", "XXXXXXXXXX"}, 1, 1);
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
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
