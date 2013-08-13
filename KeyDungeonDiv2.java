public class KeyDungeonDiv2 {

	public int countDoors(int[] doorR, int[] doorG, int[] keys) {
		int count = 0;
		for (int i = 0; i < doorG.length; i++) {
			int white = keys[2];
			if (doorR[i] > keys[0]) {
				white -= doorR[i] - keys[0];
			}
			if (white < 0)
				continue;
			if (doorG[i] > keys[1]) {
				white -= doorG[i] - keys[1];
			}
			if (white < 0)
				continue;
			count++;
		}
		return count;
	}

}
