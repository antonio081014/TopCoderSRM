public class Unique {

	public String removeDuplicates(String S) {
		int[] mark = new int[26];
		String s = "";
		for (int i = 0; i < S.length(); i++) {
			if (mark[S.charAt(i) - 'a'] == 0) {
				s += S.charAt(i);
				mark[S.charAt(i) - 'a'] = 1;
			}
		}
		return s;
	}

}
