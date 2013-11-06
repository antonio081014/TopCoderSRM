import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class FoxAndGo
{
	private boolean[][] mark;
	private int N;
	private int M;

	private int[] dx = { 1, 0, -1, 0 };
	private int[] dy = { 0, 1, 0, -1 };

	public int maxKill(String[] board) {
		N = board.length;
		M = board[0].length();
		char[][] mat = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				mat[i][j] = board[i].charAt(j);
			}
		}

		int max = Math.max(0, flood(mat));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mat[i][j] == '.') {
					mat[i][j] = 'x';
					max = Math.max(max, flood(mat));
					mat[i][j] = '.';
				}
			}
		}
		return max;
	}

	private int flood(char[][] board) {
		mark = new boolean[N][M];
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'o') {
					count += Math.max(0, flood(board, i, j));
				}
			}
		}
		return count;
	}

    /*
     * Do not stop even if you have found something wrong, 
     * it should come with a result when flood from (x, y) ended.
     */
	private int flood(char[][] board, int x, int y) {
		if (mark[x][y])
			return 0;
		mark[x][y] = true;
		int count = 1;
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (inB(xx, yy)) {
				if (board[xx][yy] == '.')
					flag = true;
				else if (board[xx][yy] == 'o') {
					int cnt = flood(board, xx, yy);
					if (cnt != -1)
						count += cnt;
					else
						flag = true;
					;
				}
			}
		}
		return flag ? -1 : count;
	}

	private boolean inB(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new FoxAndGo().maxKill(new String[]{".....", "..x..", ".xox.", ".....", "....."});
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
		answer = new FoxAndGo().maxKill(new String[]{"ooooo", "xxxxo", "xxxx.", "xxxx.", "ooooo"});
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
		answer = new FoxAndGo().maxKill(new String[]{".xoxo", "ooxox", "oooxx", "xoxox", "oxoox"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 13;
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
		answer = new FoxAndGo().maxKill(new String[]{".......", ".......", ".......", "xxxx...", "ooox...", "ooox...", "ooox..."});
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
		answer = new FoxAndGo().maxKill(new String[]{".......", ".xxxxx.", ".xooox.", ".xo.ox.", ".xooox.", ".xxxxx.", "......."});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 8;
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
		answer = new FoxAndGo().maxKill(new String[]{"o.xox.o", "..xox..", "xxxoxxx", "ooo.ooo", "xxxoxxx", "..xox..", "o.xox.o"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 12;
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
		answer = new FoxAndGo().maxKill(new String[]{".......", "..xx...", ".xooox.", ".oxxox.", ".oxxxo.", "...oo..", "......."});
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
		answer = new FoxAndGo().maxKill(new String[]{".ox....", "xxox...", "..xoox.", "..xoox.", "...xx..", ".......", "......."} );
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
		answer = new FoxAndGo().maxKill(new String[]{"...................", "...................", "...o..........o....", "................x..", "...............x...", "...................", "...................", "...................", "...................", "...................", "...................", "...................", "...................", "...................", "................o..", "..x................", "...............x...", "...................", "..................."});
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
