import java.util.Arrays;
import java.util.HashMap;

/**
 * For this proble, you are having a formula, a0x0 + a1x1 + ... + anxn, if a0,
 * a1, ..., an are distinct and such array exists;
 * */
public class ColorfulCoinsEasy {

	public String isPossible(int[] values) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < values.length; i++) {
			int v = values[i];
			for (int j = i + 1; j < values.length; j++) {
				if (values[j] % v == 0) {
					v = values[j];
					break;
				}
			}
			if (values[i] != v) {
				v = v / values[i];
				if (map.get(v) != null)
					map.put(v, map.get(v) + 1);
				else
					map.put(v, 1);
			}
		}
		// for (int a : map.keySet()) {
		// System.out.println("" + a + " : " + map.get(a));
		// }
		int count = 0;
		Object[] array = map.keySet().toArray();
		Arrays.sort(array);
		for (Object aa : array) {
			int a = (Integer) aa;
			if (a <= map.get(a) + count)
				return "Impossible";
			else
				count += map.get(a);
		}
		return "Possible";
	}
}
