public class WolfDelaymaster {

	public String check(String str) {
		int current = 0;
		while (current < str.length()) {
			int count = 0;
			for (; current < str.length(); current++) {
				if (str.charAt(current) == 'w')
					count++;
				else
					break;
			}
			if (count == 0 || current + count * 3 > str.length())
				return "INVALID";
			for (int i = 0; i < count; i++) {
				if (str.charAt(current) != 'o')
					return "INVALID";
				current++;
			}
			for (int i = 0; i < count; i++) {
				if (str.charAt(current) != 'l')
					return "INVALID";
				current++;
			}
			for (int i = 0; i < count; i++) {
				if (str.charAt(current) != 'f')
					return "INVALID";
				current++;
			}
		}
		return "VALID";
	}

}
