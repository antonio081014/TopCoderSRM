import java.util.HashSet;

public class AvoidRoads {
	/**
	 * count[x][y] represents the number of ways to reach grid (x, y). For this
	 * DP problem, we could either calculate the count[x][y] by adding [x-1][y]
	 * and [x][y-1] according to the path traversable. While, I use another one.
	 * I use the calculated value to calculate the new one.
	 * 
	 * State: count[x][y] = count[x-1][y] + count[x][y-1];
	 * 
	 * @param width
	 * @param height
	 * @param bad
	 * */
	public long numWays(int width, int height, String[] bad) {

		HashSet<String> avoids = new HashSet<String>();
		for (int i = 0; i < bad.length; i++)
			avoids.add(bad[i]);

		long[][] count = new long[width + 1][height + 1];
		count[0][0] = 1L;
		for (int x = 0; x <= width; x++) {
			for (int y = 0; y <= height; y++) {
				String s1 = String.format("%d %d %d %d", x, y, x + 1, y);
				String s2 = String.format("%d %d %d %d", x + 1, y, x, y);
				String s3 = String.format("%d %d %d %d", x, y, x, y + 1);
				String s4 = String.format("%d %d %d %d", x, y + 1, x, y);
				if (avoids.contains(s1) == false
						&& avoids.contains(s2) == false && x + 1 <= width)
					count[x + 1][y] += count[x][y];
				if (avoids.contains(s3) == false
						&& avoids.contains(s4) == false && y + 1 <= height)
					count[x][y + 1] += count[x][y];
			}
		}
		return count[width][height];
	}
}