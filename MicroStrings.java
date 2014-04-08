public class MicroStrings {

	public String makeMicroString(int A, int D) {
		String s = "";
		while (A >= 0) {
			s += A;
			A -= D;
		}
		return s;
	}

}
