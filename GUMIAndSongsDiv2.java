import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class GUMIAndSongsDiv2 {

	/**
	 * There is 2^N possibilities of having items in your bag. <br />
	 * For each possibility, we add all the duration cost, while sort the tunes.<br />
	 * This trick could make sure we'll have the least cost for these jumping
	 * tones. Brilliant trick.
	 * */
	public int maxSongs(int[] duration, int[] tone, int T) {
		int N = duration.length;
		int max = 0;
		for (int i = 1; i < (1 << N); i++) {
			int sum = 0;
			int count = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < N; j++) {
				if (((i >> j) & 1) == 1) {
					sum += duration[j];
					list.add(tone[j]);
					count++;
				}
			}
			Collections.sort(list);
			int l = list.size();
			sum += list.get(l - 1) - list.get(0);
			// for (int j = 1; j < count; j++) {
			// sum += Math.abs(list.get(j) - list.get(j - 1));
			// }
			if (sum <= T && max < count)
				max = count;
		}

		return max;
	}

	/**
	 * Dynamic Programming;<br />
	 * mark[mask] represents: the minimum time cost for having items in the bag
	 * with mask, which is a N-length digit binary number. <br />
	 * 1:includes; 0: excludes;
	 * 
	 * So we check for mask, if item i is not in the bag while j is in the bag,
	 * we could have i as the next one to be in the bag; Then, we update the
	 * mask with the new item i added.
	 * */
	public int maxSongs_Option1(int[] duration, int[] tone, int T) {
		int N = duration.length;
		int max = 0;
		int[] mark = new int[1 << N];
		for (int i = 0; i < (1 << N); i++)
			mark[i] = Integer.MAX_VALUE;
		mark[0] = 0;
		for (int i = 0; i < N; i++)
			mark[1 << i] = duration[i];
		for (int mask = 0; mask < (1 << N); mask++) {
			if (mark[mask] != Integer.MAX_VALUE) {
				for (int i = 0; i < N; i++) {
					if (((mask >> i) & 1) != 1) {
						for (int j = 0; j < N; j++) {
							if (((mask >> j) & 1) == 1) {
								mark[mask | 1 << i] = Math.min(
										mark[mask | 1 << i],
										mark[mask]
												+ Math.abs(tone[i] - tone[j])
												+ duration[i]);
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < (1 << N); i++) {
			if (mark[i] <= T) {
				int count = 0;
				int mask = i;
				while (mask > 0) {
					if (mask % 2 == 1)
						count++;
					mask /= 2;
				}
				if (count > max)
					max = count;
			}
		}
		return max;
	}

	/**
	 * This solution is very similar with the maxSongs, sort tones is pretty
	 * significant. For each start to end of Music we have, we only choose the
	 * smallest duration possible of music, while the max cost of tones could
	 * only be the difference between first music tone and the last music tone
	 * from our selection.
	 * */
	public int maxSongs_Option2(int[] duration, int[] tone, int T) {
		int N = duration.length;
		int max = 0;
		Music[] list = new Music[N];
		for (int i = 0; i < N; i++)
			list[i] = new Music(duration[i], tone[i]);
		Arrays.sort(list);

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				int t = T - list[j - 1].tone + list[i].tone;
				int count = 0;
				PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
				for (int k = i; k < j; k++) {
					queue.add(list[k].dur);
				}
				while (!queue.isEmpty()) {
					if (t >= queue.peek()) {
						t -= queue.poll();
						count++;
					} else
						break;
				}
				max = Math.max(max, count);
			}
		}
		return max;
	}
}

class Music implements Comparable<Music> {
	public int dur;
	public int tone;

	public Music(int d, int t) {
		dur = d;
		tone = t;
	}

	public int compareTo(Music m) {
		return tone - m.tone;
	}
}
