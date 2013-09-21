import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GUMIAndSongsDiv1 {

	public int maxSongs(int[] duration, int[] tone, int T) {
		int N = duration.length;
		int max = 0;
		ArrayList<Songs> list = new ArrayList<Songs>();
		for (int i = 0; i < N; i++) {
			list.add(new Songs(duration[i], tone[i]));
			if (T >= duration[i])
				max = 1;
		}
		Collections.sort(list, new Comparator<Songs>() {
			public int compare(Songs a, Songs b) {
				return a.tone - b.tone;
			}
		});
		// print(list);
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				Songs a = list.get(i);
				Songs b = list.get(j);
				int left = T - (b.tone - a.tone) - a.duration - b.duration;
				PriorityQueue<Songs> queue = new PriorityQueue<Songs>();
				for (int k = i + 1; k < j; k++) {
					Songs c = list.get(k);
					// if (c.tone <= b.tone && c.tone >= a.tone)
					queue.add(c);
				}
				int count = 0;
				if (left >= 0)
					count += 2;
				while (!queue.isEmpty() && left >= 0) {
					Songs c = queue.poll();
					if (c.duration <= left)
						count++;
					left -= c.duration;
				}
				max = Math.max(max, count);
			}
		}
		return max;
	}

	private void print(List<Songs> list) {
		for (Songs s : list) {
			System.out.println(String.format("%d %d", s.tone, s.duration));
		}
	}

	class Songs implements Comparable<Songs> {
		public int duration;
		public int tone;

		public Songs(int d, int t) {
			duration = d;
			tone = t;
		}

		public int compareTo(Songs a) {
			return this.duration - a.duration;
		}
	}
}
