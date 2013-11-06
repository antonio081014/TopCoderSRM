import java.util.Arrays;

public class PipeCuts {

	/**
	 * Find all possible two-cuts, which could produce a pipe longer than L.
	 * */
	public double probability(int[] weldLocations, int L) {
		double total = weldLocations.length * (weldLocations.length - 1) / 2;
		double sum = 0;
		Arrays.sort(weldLocations);
		for (int i = 0; i < weldLocations.length; i++) {
			for (int j = i + 1; j < weldLocations.length; j++) {
				if (weldLocations[i] > L
						|| weldLocations[j] - weldLocations[i] > L
						|| 100 - weldLocations[j] > L)
					sum++;
			}
		}
		return sum / total;
	}
}
