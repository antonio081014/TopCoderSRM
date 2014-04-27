public class FizzBuzzTurbo {

	public long[] counts(long A, long B) {
		long[] ret = new long[3];
		ret[2] = cal(A, B, 15L);
		ret[0] = cal(A, B, 3) - ret[2];
		ret[1] = cal(A, B, 5) - ret[2];
		return ret;
	}

	private long cal(long A, long B, long C) {
		long a1 = A;
		long a2 = B;
		while (a1 % C != 0)
			a1++;
		while (a2 % C != 0)
			a2--;
		if (a2 < a1)
			return 0L;
		return (a2 - a1) / C + 1;
	}

}
