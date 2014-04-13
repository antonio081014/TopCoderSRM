// This is Greedy.
// For each position, check out all the candidates and find out the smallest one.
public class EllysScrabble {

	public String getMin(String letters, int maxDistance) {
		int N = letters.length();
		boolean[] visit = new boolean[N];
		String s = "";
		for (int i = 0; i < N; i++) {
			String candidate = "a";
			int candidateIndex = i;
			for (int j = Math.max(0, i - maxDistance); j <= Math.min(N - 1, i
					+ maxDistance); j++) {
				if (visit[j] == false) {
					if (j == i - maxDistance) {
						candidate = "" + letters.charAt(j);
						candidateIndex = i - maxDistance;
						break;
					} else {
						if (candidate.compareTo("" + letters.charAt(j)) > 0) {
							candidate = "" + letters.charAt(j);
							candidateIndex = j;
						}
					}
				}
			}
			s += candidate;
			visit[candidateIndex] = true;
		}
		return s;
	}

}
