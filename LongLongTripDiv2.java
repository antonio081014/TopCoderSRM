public class LongLongTripDiv2 {

	public String isAble(long D, int T, int B) {
		long a = (D - T) / (B - 1);
		long b = T - a;
		if (a >= 0 && b >= 0 && a * (B - 1) == (D - T))
			return "Possible";
		return "Impossible";
	}

}
