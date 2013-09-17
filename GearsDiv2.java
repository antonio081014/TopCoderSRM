public class GearsDiv2 {
	public int getmin(String dir) {
		int N = dir.length();
		int ret = N - 1;
		if (dir.charAt(0) != dir.charAt(N - 1))
			ret = Math.min(ret, getminLinear(dir));
		ret = Math.min(ret, 1 + getminLinear(dir.substring(1)));
		ret = Math.min(ret, 1 + getminLinear(dir.substring(0, N - 1)));
		return ret;
	}

	private int getminLinear(String dir) {
		if (dir.length() < 2)
			return 0;
		// change the second one to '_'
		if (dir.charAt(0) == dir.charAt(1)) {
			return 1 + getminLinear(dir.substring(2));
		}
		return getminLinear(dir.substring(1));
	}
}