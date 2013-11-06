public class QuizShow {

	/*
	 * Since every contestant has 50 - 50 to win, then everyone could either win
	 * or lose.
	 */
	private static final int[] seq = { -1, 1 };

	/**
	 * For all the wages 'I' can get, which range from 0 to the score I have
	 * now. Check every (2^3) cases the outcome could be, to see if 'my' score
	 * could be strictly better than the other two.
	 * */
	public int wager(int[] scores, int wager1, int wager2) {
		int bestCount = 0;
		int max = 0;

		for (int w = 0; w <= scores[0]; w++) {
			int sum = 0;
			for (int i = 0; i < seq.length; i++) {
				for (int j = 0; j < seq.length; j++)
					for (int k = 0; k < seq.length; k++) {
						int s1 = scores[0] + seq[i] * w;
						int s2 = scores[1] + seq[j] * wager1;
						int s3 = scores[2] + seq[k] * wager2;
						if (s1 > s2 && s1 > s3) {
							sum++;
						}
					}
			}
			if (sum > bestCount) {
				max = w;
				bestCount = sum;
			}
		}
		return max;
	}

}
