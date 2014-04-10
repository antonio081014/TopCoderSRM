import java.util.Arrays;
//Wed Apr  9 23:38:00 PDT 2014
public class TaroFriends {
	/**
	 * Initially, I followed the pattern, R,R,...,L,L,L. While, the only problem
	 * here is how to find the mid point, which decides the left ones add X and
	 * right ones minus X. So I chosen the mid point of all the coordinate
	 * firstly. But this was wrong for some cases. Then, I'd rather go through
	 * every coordinate, set it as mid point, to see which helps produce the
	 * minimum distance.
	 * */
	public int getNumber(int[] coordinates, int X) {
		Arrays.sort(coordinates);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coordinates.length; i++) {
			min = Math.min(min, minDist(coordinates, X, coordinates[i]));
		}
		return min;
	}

	private int minDist(int[] coordinates, int X, int mid) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < coordinates.length; i++) {
			int x = 0;
			if (coordinates[i] >= mid)
				x = coordinates[i] - X;
			else
				x = coordinates[i] + X;
			min = Math.min(min, x);
			max = Math.max(max, x);
		}
		return max - min;
	}
}
