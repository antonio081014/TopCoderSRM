public class PowerOfThreeEasy {

	// Fri Mar 14 22:25:12 PDT 2014
	// Solution from editorial.
	public String ableToGet(int x, int y) {
		// If (x==0, y==0, then it is possible).
		while (x != 0 || y != 0) {
			// decreasing one of x or y must yield a multiple of 3.
			// so either x%3 == 1 and y%3 == 0 or
			// x%3 == 0 and y%3 == 1.
			// It can be reduced to the following condition:
			if (x % 3 + y % 3 != 1)
				return "Impossible";
			// Decrease one of them, divide them by 3.
			// * If x % 3 == 1, then x/3 = (x-1)/3
			// * Same with y.
			x /= 3;
			y /= 3;
		}
		return "Possible";
	}

}
