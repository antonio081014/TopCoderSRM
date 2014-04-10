public class TaroString {

	private static final String CAT = "CAT";

	public String getAnswer(String S) {
		if (!check(S))
			return "Impossible";
		int index = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == CAT.charAt(index)) {
				index++;
			}
			if (index == CAT.length())
				return "Possible";
		}
		return "Impossible";
	}

	private boolean check(String s) {
		int c = 0;
		int a = 0;
		int t = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'C')
				c++;
			else if (s.charAt(i) == 'A')
				a++;
			else if (s.charAt(i) == 'T')
				t++;
		}
		return a == 1 && c == 1 && t == 1;
	}

}
