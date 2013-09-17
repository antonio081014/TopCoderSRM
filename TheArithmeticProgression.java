public class TheArithmeticProgression {

	public double minimumChange(int a, int b, int c) {
		double ret = 1.0 * (a + c) / 2.0 - b;
		return Math.abs(ret);

	}

}
