public class PyramidSequences {

	public long gcd(long a, long b) {
		// Euclid's algorithm: repeat (a,b) = (b, a%b) until b = 0:
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public long distinctPairs(int N, int M) {
		long g = gcd(N - 1, M - 1);

		long x = (N - 1) / g;
		long y = (M - 1) / g;

		long s = (g - 1) * x * y;
		long t = ((x + 1) * (y + 1) + 1) / 2;
		return s + t;
	}

}
