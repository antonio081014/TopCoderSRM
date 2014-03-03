public class TheMatrix {

	public int MaxArea(String[] board) {
		int m = board.length;
		int n = board[0].length();

		int ret = 1;

		// This is the most amazing part: matrix conversion
		int[][] matrix = new int[m][n];
		for (int i = 0, s = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (s > 0)
					matrix[i][j] = '1' - board[i].charAt(j);
				else
					matrix[i][j] = board[i].charAt(j) - '0';
				s = 1 - s;
			}
			if (n % 2 == 0)
				s = 1 - s;
		}

		int[][] count = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				count[i + 1][j + 1] = matrix[i][j] + count[i][j + 1]
						+ count[i + 1][j] - count[i][j];

		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++)
				for (int k = i; k <= m; k++)
					for (int l = j; l <= n; l++) {
						int use = count[k][l] + count[i - 1][j - 1]
								- count[k][j - 1] - count[i - 1][l];
						int area = (k - i + 1) * (l - j + 1);
						if (use == 0 || use == area) {
							ret = Math.max(ret, area);
						}
					}
		return ret;
	}

}
