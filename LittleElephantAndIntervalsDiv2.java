import java.util.HashSet;

public class LittleElephantAndIntervalsDiv2 {

	HashSet<String> set;

	/*
	 * Find all possible results. The could be changed mostly 2^L times, which
	 * is 2^10 = 1024.
	 */
	public int getNumber(int M, int[] L, int[] R) {
		set = new HashSet<String>();
		cal(new boolean[M + 1], L, R, 0);
		return set.size();
	}

	private void cal(boolean[] array, int[] L, int[] R, int current) {
		if (current >= L.length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < array.length; i++)
				sb.append(array[i] ? '1' : '0');
			set.add(sb.toString());
			return;
		}
		cal(toBlack(array.clone(), L[current], R[current]), L, R, current + 1);
		cal(toWhite(array.clone(), L[current], R[current]), L, R, current + 1);
	}

	private boolean[] toBlack(boolean[] array, int l, int r) {
		for (int i = l; i <= r; i++)
			array[i] = true;
		return array;
	}

	private boolean[] toWhite(boolean[] array, int l, int r) {
		for (int i = l; i <= r; i++)
			array[i] = false;
		return array;
	}
}
