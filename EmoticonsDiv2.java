import java.util.Arrays;

public class EmoticonsDiv2 {

	public int printSmiles(int smiles) {
		int[] count = new int[smiles + 1];
		Arrays.fill(count, Integer.MAX_VALUE);
		count[1] = 0;
		for (int i = 1; i <= smiles; i++) {
			for (int j = 2 * i; j <= smiles; j += i) {
				count[j] = Math.min(count[j], 1 + (j - i) / i + count[i]);
			}
			// System.out.println(count[i]);
		}
		return count[smiles];
	}
}
