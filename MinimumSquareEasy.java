public class MinimumSquareEasy {

	/**
	 * The problem asks: find the smallest square area to cover at N-2 vertices
	 * in the plane. So as long as N-2 vertices out of N are covered, we don't
	 * need to care about others.
	 * */
	public long minArea(int[] x, int[] y) {
		long area = Long.MAX_VALUE;
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x.length; j++) {
				if (i != j) {
					long x1 = Long.MAX_VALUE;
					long y1 = Long.MAX_VALUE;
					long x2 = Long.MIN_VALUE;
					long y2 = Long.MIN_VALUE;
					for (int k = 0; k < x.length; k++) {
						if (i != k && j != k) {
							x1 = Math.min(x1, x[k] - 1);
							y1 = Math.min(y1, y[k] - 1);
							x2 = Math.max(x2, x[k] + 1);
							y2 = Math.max(y2, y[k] + 1);
						}
					}
					area = Math.min(
							area,
							Math.max(y2 - y1, x2 - x1)
									* Math.max(y2 - y1, x2 - x1));
				}
			}
		}
		return area;
	}
}
