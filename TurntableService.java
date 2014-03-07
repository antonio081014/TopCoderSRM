public class TurntableService {

	private int N;
	private boolean[][] likes;
	private int[][] mark;

	/**
	 * Dynamic Programming Problem.
	 * 
	 * */
	public int calculateTime(String[] favorites) {
		N = favorites.length;
		likes = new boolean[N][N];
		mark = new int[1 << N][N];
		for (int i = 0; i < (1 << N); i++)
			for (int j = 0; j < N; j++)
				mark[i][j] = -1;
		for (int i = 0; i < N; i++) {
			String[] str = favorites[i].split("\\s");
			for (String s : str) {
				int a = Integer.parseInt(s);
				likes[i][a] = true;
			}
		}
		return Math.min(choose(0, 0), serve(0, 0));
	}

	/**
	 * @param mask
	 *            indicates which have been served, and which are not.
	 * @param currentP
	 *            indicates current stop position.
	 * */
	private int choose(int mask, int currentP) {
		if (mask == (1 << N) - 1)
			return mark[mask][currentP] = 0;
		if (mark[mask][currentP] != -1)
			return mark[mask][currentP];
		mark[mask][currentP] = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if (i == currentP)
				continue;
			int dist = Math.min((currentP - i + N) % N, (i - currentP + N) % N) + 1;
			int cost = serve(mask, i);
			if (cost != Integer.MAX_VALUE)
				mark[mask][currentP] = Math.min(mark[mask][currentP], dist
						+ cost);
		}
		return mark[mask][currentP];
	}

	/**
	 * @param mask
	 *            indicates which have been served, and which are not.
	 * @param currentP
	 *            indicates current stop position.
	 * */
	private int serve(int mask, int currentP) {
		int mask2 = mask;
		for (int i = 0; i < N; i++) {
			if (likes[i][(i + currentP) % N])
				mask2 |= (1 << i);
		}
		if (mask2 == mask)
			return Integer.MAX_VALUE;
		return 15 + choose(mask2, currentP);
	}
}
