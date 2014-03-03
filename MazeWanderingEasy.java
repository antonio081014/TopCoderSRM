import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class MazeWanderingEasy
{
	private int[][] mark;
	private int N;
	//private int M;
	private String[] board;
	
	private final int[] dx = {1, 0, -1, 0};
	private final int[] dy = {0, 1, 0, -1};
	
	public int decisions(String[] maze)
	{
		N = maze.length;
		//M = maze[0].length();
		board = maze;
		mark = new int[50][50];
		for(int i=0; i<N; i++) for(int j=0; j<board[i].length(); j++) mark[i][j] = Integer.MAX_VALUE;
		
		boolean flag = true;
		for(int i=0; flag&&i<N; i++){
			for(int j=0; flag&&j<board[i].length(); j++){
				if(board[i].charAt(j)=='M'){
					mark[i][j] = 0;
					find(i, j);
					flag = false;
				}
			}
		}
		for(int i=0; i<N; i++) for(int j=0; j<board[i].length(); j++) if(board[i].charAt(j)=='*') return mark[i][j];
		return 0;
	}
	
	private void find(int x, int y){
		int cost = mark[x][y];
		int decisions = 0;
		//System.out.println(String.format("(%d %d): %d", x, y, cost));
		for(int i=0; i<dx.length; i++){
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(inSide(xx, yy) && mark[xx][yy] > cost+1 && board[xx].charAt(yy)!='X') decisions++;
		}
		if(decisions == 0) return;
		
		for(int i=0; i<dx.length; i++){
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(inSide(xx, yy) && mark[xx][yy] > cost + 1 && board[xx].charAt(yy)!='X'){
				if(decisions==1){
					mark[xx][yy] = cost;
					find(xx, yy);
				} else {
					mark[xx][yy] = cost + 1;
					find(xx, yy);
				}
			}
		}
	}
	
	private boolean inSide(int x, int y){
		return x>=0&&x<N&&y>=0&&y<board[x].length();
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new MazeWanderingEasy().decisions(new String[]{"*.M"});
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
		answer = new MazeWanderingEasy().decisions(new String[]{"*.M", ".X."});
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
		answer = new MazeWanderingEasy().decisions(new String[]{"...", "XMX", "..*"});
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
		answer = new MazeWanderingEasy().decisions(new String[]{".X.X......X", ".X*.X.XXX.X", ".XX.X.XM...", "......XXXX."});
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
		answer = new MazeWanderingEasy().decisions(new String[]{"..........*", ".XXXXXXXXXX", "...........", "XXXXXXXXXX.", "M.........."});
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
