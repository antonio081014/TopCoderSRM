public class BirthdayOdds {

	public int minPeople(int minOdds, int daysInYear) {
		int num = 0;
		double target = 1.0 - 1.0 * minOdds / 100.0;
		double p = 1;
		while (p > target) {
			p *= 1.0 * (daysInYear - num) / daysInYear;
			num++;
		}
		return num;
	}

}
