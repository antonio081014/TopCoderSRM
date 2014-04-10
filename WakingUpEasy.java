public class WakingUpEasy {

	public int countAlarms(int[] volume, int S) {
		int index = 0;
		do {
			S -= volume[index % volume.length];
			index = (index + 1);
		} while (S > 0);
		return index;
	}
}
