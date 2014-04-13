import java.util.Arrays;

public class EllysSortingTrimmer {

	public String getMin(String S, int L) {
		for (int i = S.length() - L; i >= 0; i--) {
			String pref = S.substring(0, i);
			String s = S.substring(i, i + L);
			char[] c = s.toCharArray();
			Arrays.sort(c);
			S = pref + new String(c);
		}
		return S;
	}

}
