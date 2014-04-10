public class MergeStrings {

	private String[][] mark;
	private static final String defaultString = "[invalid]";
	private String S;
	private String A;
	private String B;
	private int N;
	private int T;

	public String getmin(String _S, String _A, String _B) {
		S = _S;
		A = _A;
		B = _B;
		N = A.length();
		T = B.length();
		mark = new String[N + 1][T + 1];

		for (int j = 0; j <= N; j++)
			for (int k = 0; k <= T; k++) {
				mark[j][k] = defaultString;
			}
		mark[0][0] = "";
		solve(N, T);

		return mark[N][T].compareTo(defaultString) == 0 ? "" : mark[N][T];
	}

	// Find the lexicographically smallest string by combining first a
	// characters from A and first b characters from B;
	private void solve(int a, int b) {
		if (a == 0 && b == 0)
			return;
		if (mark[a][b].compareTo(defaultString) != 0)
			return;

		mark[a][b] = defaultString;

		if (b > 0
				&& (B.charAt(b - 1) == S.charAt(a + b - 1) || S.charAt(a + b
						- 1) == '?')) {
			solve(a, b - 1);
			String s = mark[a][b - 1] + B.charAt(b - 1);
			if (mark[a][b].compareTo(s) > 0) {
				mark[a][b] = s;
			}
		}
		if (a > 0
				&& (A.charAt(a - 1) == S.charAt(a + b - 1) || S.charAt(a + b
						- 1) == '?')) {
			solve(a - 1, b);
			String s = mark[a - 1][b] + A.charAt(a - 1);
			if (mark[a][b].compareTo(s) > 0) {
				mark[a][b] = s;
			}
		}
	}
}
