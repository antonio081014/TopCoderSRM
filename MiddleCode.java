public class MiddleCode {

	// Fri Mar 14 22:50:33 PDT 2014
	// Antonio081014
	public String encode(String s) {
		String t = "";
		while (s.length() > 0) {
			if (s.length() % 2 == 0) {
				if (s.charAt(s.length() / 2) < s.charAt(s.length() / 2 - 1)) {
					t += s.charAt(s.length() / 2);
					s = s.substring(0, s.length() / 2)
							+ s.substring(s.length() / 2 + 1);
				} else {
					t += s.charAt(s.length() / 2 - 1);
					s = s.substring(0, s.length() / 2 - 1)
							+ s.substring(s.length() / 2);
				}
			} else {
				int index = s.length() / 2;
				t += s.charAt(index);
				s = s.substring(0, index) + s.substring(index + 1);
			}
		}
		return t;
	}

}
