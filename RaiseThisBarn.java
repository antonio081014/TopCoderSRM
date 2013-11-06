public class RaiseThisBarn {

	public int calc(String str) {
		int N = str.length();
		int[] cnt = new int[N + 1];
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == 'c')
				cnt[i + 1] = cnt[i] + 1;
			else
				cnt[i + 1] = cnt[i];
		}
		if (cnt[N] % 2 != 0) {
			return 0;
		}
		int mid = cnt[N] / 2;
		int count = 0;
		for (int i = 1; i < N; i++) {
			if (cnt[i] == mid)
				count++;
		}
		return count;
	}

}
