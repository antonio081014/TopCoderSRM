public class FoxAndWord {

	public int howManyPairs(String[] words) {
		int count = 0;
		for (int i = 0; i < words.length; i++)
			for (int j = i + 1; j < words.length; j++)
				if (pair(words[i], words[j]))
					count++;
		return count;
	}

	private boolean pair(String a, String b) {
		if (a.length() != b.length())
			return false;
		for (int i = 0; i < a.length(); i++) {
			String s = a.substring(i) + a.substring(0, i);
			if (s.compareTo(b) == 0)
				return true;
		}
		return false;
	}
}
