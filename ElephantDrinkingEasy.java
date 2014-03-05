public class ElephantDrinkingEasy {
	// down, right, up, left
	static final int[] dx = { 1, 0, -1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };

	public int maxElephants(String[] map) {
		int n = map.length;
		int e = 4 * n;
		int max = 0;
		for (int i = 1; i < (1 << e); i++) {
			int count = 0;
			boolean flag = true;
			char[][] mp = board(map);
			for (int j = 0; j < e; j++) {
				if (((i >> j) & 1) == 1) {
					Pair p = decode(j + 1, n);
					// System.out.println("" + (j + 1) + ": " + p.x + ", " +
					// p.y);
					for (int m = 1;; m++) {
						int xx = p.x + dx[p.d] * m - 1;
						int yy = p.y + dy[p.d] * m - 1;
						if (xx < 0 || xx >= n || yy < 0 || yy >= n) {
							flag = false;
							break;
						}
						if (mp[xx][yy] == '.') {
							flag = false;
							break;
						}
						if (mp[xx][yy] == 'Y') {
							mp[xx][yy] = '.';
							break;
						}
						if (mp[xx][yy] == 'N') {
							mp[xx][yy] = '.';
						}
					}
					if (flag)
						count++;
				}
				if (!flag)
					break;

			}
			if (flag)
				max = Math.max(max, count);
		}
		return max;
	}

	private char[][] board(String[] map) {
		int n = map.length;
		char[][] ret = new char[n][n];
		for (int i = 0; i < n; i++)
			ret[i] = map[i].toCharArray();
		return ret;
	}

	private Pair decode(int x, int n) {
		if (x <= n)
			return new Pair(0, x, 0);
		if (x <= 2 * n)
			return new Pair(x - n, 0, 1);
		if (x <= 3 * n)
			return new Pair(x - 2 * n, n + 1, 3);
		return new Pair(n + 1, x - 3 * n, 2);
	}

	class Pair {
		int x;
		int y;
		int d;

		public Pair(int xx, int yy, int dd) {
			x = xx;
			y = yy;
			d = dd;
		}
	}
}
// Powered by [KawigiEdit] 2.0!
