public class NinjaTurtles {

	public int countOpponents(int P, int K) {

		for (int i = 0; i <= P; i += 3) {
			int a1 = i / 3;
			int a2 = P - i;
			if (a2 * 3 / K == a1) {
				return a2 * 3;
			} else if ((a2 * 3 + 1) / K == a1) {
				return a2 * 3 + 1;
			} else if ((a2 * 3 + 2) / K == a1) {
				return a2 * 3 + 2;
			}
		}

		return -1;
	}
}
