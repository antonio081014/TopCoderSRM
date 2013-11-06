import java.util.HashSet;

public class LittleElephantAndBallsAgain {

	public int getNumber(String S) {
		int max = 0;
		for (int i = 0; i < S.length(); i++) {
			for (int j = i; j < S.length(); j++) {
				HashSet<String> set = new HashSet<String>();
				for (int k = i; k <= j; k++) {
					set.add("" + S.charAt(k));
				}
				if (set.size() == 1) {
					max = Math.max(max, j - i + 1);
				}
			}
		}
		return S.length() - max;
	}

	public int getNumber2(String S) {
		int r = 0;
		int g = 0;
		int b = 0;
		int max = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'R') {
				r++;
				g = 0;
				b = 0;
			} else if (S.charAt(i) == 'G') {
				g++;
				r = 0;
				b = 0;
			} else if (S.charAt(i) == 'B') {
				b++;
				g = 0;
				r = 0;
			}
			max = Math.max(max, Math.max(r, Math.max(g, b)));
		}
		return S.length() - max;
	}
}
