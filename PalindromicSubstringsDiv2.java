public class PalindromicSubstringsDiv2 {

	public int count(String[] S1, String[] S2) {
		String s = "";
		for (String str : S1)
			s += str;
		for (String str : S2)
			s += str;

		return count(s);
	}

	private int count(String s) {
		int n = s.length();
		int res = 0;
		// pick the middle point m:
		for (int m = 0; m < n; m++) {
			// Try an odd-length substring (even == 0), and also an even-length
			// one (even == 1):
			for (int even = 0; even < 2; even++) {
				int i, j;
				// initialize pointers depending on even or not:
				boolean pal = true;
				if (even == 1) {
					i = m;
					j = m + 1;
					res++;
				} else {
					i = m - 1;
					j = m + 1;
				}
				// do the check:
				while ((i >= 0) && (j < n)) {
					pal = (pal && (s.charAt(i) == s.charAt(j)));
					if (pal) {
						res++;
					}
					i--;
					j++;
				}
			}
		}
		return res;
	}

}
