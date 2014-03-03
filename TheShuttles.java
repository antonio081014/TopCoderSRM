public class TheShuttles {

	public int getLeastCost(int[] cnt, int baseCost, int seatCost) {
		int min = Integer.MAX_VALUE;
		for (int x = 1; x <= 100; x++) {
			min = Math.min(min, cost(cnt, baseCost, seatCost, x));
		}
		return min;
	}

	private int cost(int[] cnt, int base, int seat, int X) {
		int total = 0;
		for (int i = 0; i < cnt.length; i++) {
			int count = (int) Math.ceil(1.0 * cnt[i] / X);
			total += count * seat * X + base * count;
		}
		return total;
	}

}
