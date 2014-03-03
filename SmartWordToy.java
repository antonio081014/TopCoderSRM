import java.util.LinkedList;
import java.util.Queue;

/**
 * For this problem, it's easy to find out each 4-digit string is a state. And
 * it's easy to move to next state from current state by going to next
 * alpha-letter or previous alpha-letter. So here, using BFS to track the state
 * to state process, and find out the shortest distance from start to finish
 * state.
 * 
 * PS: initially, I used Map interface to keep the record of state's distance
 * from start, it will Exceed Time Limit. Then, I used a 4-dim array to keep
 * track of the state's distance. It works like a charm now. I think it's the
 * getter of Map interface costs too much time since I instantized with a
 * linkedlist, each time the iterator will go through every element in the map
 * to check the value of the key.
 * 
 * */
public class SmartWordToy {
	// Map<String, Integer> map;
	int[][][][] count;

	public int minPresses(String start, String finish, String[] forbid) {
		// map = new HashMap<String, Integer>();
		count = new int[26][26][26][26];
		// map.put(start, 0);
		for (int i = 0; i < 26; i++)
			for (int j = 0; j < 26; j++)
				for (int m = 0; m < 26; m++)
					for (int n = 0; n < 26; n++)
						count[i][j][m][n] = -1;
		preprocess(forbid);
		setCounter(start, 0);
		Queue<String> q = new LinkedList<String>();
		q.add(start);
		while (!q.isEmpty()) {
			start = q.poll();
			if (start.compareTo(finish) == 0)
				return getCounter(start);
			int value = getCounter(start);
			for (int i = 0; i < 4; i++) {
				String next = nextString(start, i);
				if (getCounter(next) == -1) {
					setCounter(next, value + 1);
					// map.put(next, map.get(start) + 1);
					q.add(next);
				}
				String prev = prevString(start, i);
				if (getCounter(prev) == -1) {
					setCounter(prev, value + 1);
					q.add(prev);
				}
			}
		}
		return -1;
	}

	private void setCounter(String s, int value) {
		count[s.charAt(0) - 'a'][s.charAt(1) - 'a'][s.charAt(2) - 'a'][s
				.charAt(3) - 'a'] = value;
	}

	private int getCounter(String s) {
		return count[s.charAt(0) - 'a'][s.charAt(1) - 'a'][s.charAt(2) - 'a'][s
				.charAt(3) - 'a'];
	}

	private void preprocess(String[] forbid) {
		for (String s : forbid) {
			String[] str = s.split("\\s");
			for (int i = 0; i < str[0].length(); i++) {
				for (int j = 0; j < str[1].length(); j++) {
					for (int m = 0; m < str[2].length(); m++) {
						for (int n = 0; n < str[3].length(); n++) {
							// String tmp = "" + str[0].charAt(i)
							// + str[1].charAt(j) + str[2].charAt(m)
							// + str[3].charAt(n);
							// map.put(tmp, -1);
							count[str[0].charAt(i) - 'a'][str[1].charAt(j) - 'a'][str[2]
									.charAt(m) - 'a'][str[3].charAt(n) - 'a'] = -10;
						}
					}
				}
			}
		}
	}

	private String nextString(String s, int index) {
		return s.substring(0, index)
				+ (char) ('a' + (s.charAt(index) - 'a' + 1) % 26)
				+ s.substring(index + 1);
	}

	private String prevString(String s, int index) {
		return s.substring(0, index)
				+ (char) ('a' + (s.charAt(index) - 'a' + 25) % 26)
				+ s.substring(index + 1);
	}
}
// Powered by [KawigiEdit] 2.0!