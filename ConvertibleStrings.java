public class ConvertibleStrings {

	public int leastRemovals(String A, String B) {
		int len = A.length();
		int ret = len;
		int[] array = new int['I' - 'A' + 1];
		for (int i = 0; i < array.length; i++)
			array[i] = i;
		do {
			int count = 0;
			for (int i = 0; i < len; i++) {
				if (array[A.charAt(i) - 'A'] != B.charAt(i) - 'A')
					count++;
			}
			ret = Math.min(ret, count);
		} while (next_permutation(array));
		return ret;
	}

	public boolean next_permutation(int[] array) {
		int i, j;

		for (i = array.length - 2; i >= 0; i--) {
			if (array[i] < array[i + 1])
				break;
		}
		if (i < 0) {

			return false;
		}

		for (j = array.length - 1; j > i; j--) {
			if (array[j] > array[i])
				break;
		}

		swap(array, i++, j);

		for (j = array.length - 1; j > i; i++, j--) {
			swap(array, i, j);
		}
		return true;
	}

	public void swap(int[] array, int x, int y) {
		array[x] ^= array[y];
		array[y] ^= array[x];
		array[x] ^= array[y];
	}

}