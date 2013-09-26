public class GooseTattarrattatDiv1 {

	private int[] count;
	private boolean[] notVisited;

	public int getmin2(String S) {
		count = new int[26];
		int min = S.length();
		int N = S.length();
		notVisited = new boolean[26];
		for (int i = 0; i < N; i++) {
			int a = S.charAt(i) - 'a';
			count[a]++;
			notVisited[a] = true;
		}
		for (int i = 0; i < N; i++) {
			min -= dfs(S.charAt(i), S);
		}
		return min;
	}

	/**
	 * Find the maximum number of characters connect to c in s; It's like a
	 * chain. We need to find the node in the chain with maximum cost; The
	 * algorithm here is like Flood Fill;
	 * */
	private int dfs(char c, String s) {
		if (notVisited[c - 'a'] == false)
			return 0;
		int max = count[c - 'a'];
		notVisited[c - 'a'] = false;
		for (int i = 0; i < s.length(); i++) {
			if (c == s.charAt(i))
				max = Math.max(max, dfs(s.charAt(s.length() - 1 - i), s));
		}
		return max;
	}

	/**
	 * Floyd–Warshall algorithm<br />
	 * Finding all the connectivity for all the characters from 'a' to 'z'.<br />
	 * Then, find the maximum and total characters for each group (subgraph),
	 * make all the rest of characters change to the character holds the
	 * maximum, Thus, it costs (total - maximum);
	 * */
	public int getmin3(String s) {
		int N = s.length();
		int[] counter = new int[26];
		boolean[][] connected = new boolean[26][26];
		for (int i = 0; i < N; i++) {
			counter[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < N - i; i++) {
			int a = s.charAt(i) - 'a';
			int b = s.charAt(N - i - 1) - 'a';
			connected[a][b] = true;
			connected[b][a] = true;
		}

		for (int i = 0; i < 26; i++)
			connected[i][i] = true;
		for (int k = 0; k < 26; k++) {
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < 26; j++) {
					connected[i][j] |= connected[i][k] && connected[k][j];
				}
			}
		}
		int ret = 0;
		for (int i = 0; i < N; i++) {
			if (counter[s.charAt(i) - 'a'] <= 0)
				continue;
			int total = 0;
			int max = 0;
			for (int j = 0; j < 26; j++) {
				if (connected[s.charAt(i) - 'a'][j]) {
					total += counter[j];
					max = Math.max(max, counter[j]);
					counter[j] = 0;
				}
			}
			ret += total - max;
		}
		return ret;
	}

	/**
	 * This problem actually asks to group 'a' - 'z'. Here I use the Union-Find
	 * data structure to speed this process up;
	 * */
	public int getmin(String S) {
		int[] count = new int[26];
		for (int i = 0; i < S.length(); i++) {
			count[S.charAt(i) - 'a']++;
		}
		int min = 0;
		Union_Find set = new Union_Find(26);
		for (int i = 0; i < S.length() - 1 - i; i++) {
			set.union(S.charAt(i) - 'a', S.charAt(S.length() - 1 - i) - 'a');
		}
		for (int i = 0; i < 26; i++) {
			int total = 0;
			int max = 0;
			for (int j = 0; j < 26; j++) {
				if (set.find(j) == set.find(i)) {
					total += count[j];
					max = Math.max(max, count[j]);
					count[j] = 0;
				}
			}
			min += total - max;
		}
		return min;
	}

	class Union_Find {
		public int[] parents;

		public Union_Find(int N) {
			parents = new int[N];
			for (int i = 0; i < N; i++) {
				parents[i] = i;
			}
		}

		public int find(int x) {
			if (x == parents[x])
				return x;
			return parents[x] = find(parents[x]);
		}

		public void union(int x, int y) {
			int xx = find(x);
			int yy = find(y);
			if (xx != yy) {
				this.parents[xx] = yy;
			}
		}
	}
}
