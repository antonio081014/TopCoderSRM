public class TheSquareRootDilemma {

	public int countPairs(int N, int M) {
		int count = 0;
		for (int i = 1; i <= N; i++) {
			int tmp = i;
			for (int j = 2; j * j <= tmp; j++) {
				while (tmp % (j * j) == 0)
					tmp /= j * j;
			}
			count += Math.sqrt(1.0 * M / tmp);
		}
		return count;
	}

}
