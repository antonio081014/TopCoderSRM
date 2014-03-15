public class LeftAndRightHandedDiv2 {

	public int count(String S) {
		int count = 0;
		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i) == 'L' && S.charAt(i - 1) == 'R')
				count++;
		}
		return count;
	}

}
