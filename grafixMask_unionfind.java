import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @author antonio081014
 * @time Sep 28, 2012, 9:16:47 PM
 */
public class grafixMask {

	public int[] sortedAreas(String[] rectangles) {
		UnionFind set = new UnionFind(400 * 600);

		for (int i = 0; i < rectangles.length; i++) {
			String[] str = rectangles[i].split(" ");
			int r1 = Integer.parseInt(str[0]);
			int c1 = Integer.parseInt(str[1]);
			int r2 = Integer.parseInt(str[2]);
			int c2 = Integer.parseInt(str[3]);
			for (int p = r1; p <= r2; p++)
				for (int q = c1; q <= c2; q++) {
					set.avai[mapping(p, q)] = true;
				}
		}

		for (int p = 0; p < 400; p++)
			for (int q = 0; q < 600; q++) {
				int m1 = mapping(p, q);
				int m2 = mapping(p - 1, q);
				int m3 = mapping(p, q - 1);
				if (p > 0 && !set.avai[m1] && !set.avai[m2])
					set.union(m1, m2);
				if (q > 0 && !set.avai[m1] && !set.avai[m3])
					set.union(m1, m3);
			}

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 400; i++)
			for (int j = 0; j < 600; j++) {
				int m1 = mapping(i, j);
				if (!set.avai[m1] && set.rank[m1] != 0)
					list.add(set.rank[m1]);
			}
		int[] array = new int[list.size()];
		for (int i = 0; i < array.length; i++)
			array[i] = list.get(i);
		Arrays.sort(array);
		return array;
	}

	public int mapping(int x, int y) {
		return x * 600 + y;
	}

}

class UnionFind {
	int N;
	int[] parent;
	int[] rank;
	boolean[] avai;

	public UnionFind(int n) {
		this.N = n;
		parent = new int[n];
		rank = new int[n];
		avai = new boolean[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}

	public int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	public void union(int x, int y) {
		int r1 = find(x);
		int r2 = find(y);
		if (r1 == r2)
			return;
		if (rank[r1] >= rank[r2]) {
			parent[r2] = r1;
			rank[r1] += rank[r2];
			rank[r2] = 0;
		} else {
			parent[r1] = r2;
			rank[r2] += rank[r1];
			rank[r1] = 0;
		}
	}
}
