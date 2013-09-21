public class TheTree {

	/**
	 * First, check out the test case 1, we'll realize the diameter of the tree
	 * could be the height of left child tree + the height of right child tree +
	 * 1.<br />
	 * Then, we just find the diameter with the maximum.<br />
	 * Here, when some level has only one node, then the left and right of child
	 * tree have different height. That's what inner for loop checks for, trying
	 * to identify the closest node which stays at the level has only one node.
	 * */
	public int maximumDiameter(int[] cnt) {
		int max = 0;
		int N = cnt.length;
		for (int i = 0; i < N; i++) {
			boolean flag = true;
			for (int j = i; j < N; j++) {
				if (cnt[j] == 1) {
					flag = false;
					max = Math.max(max, N - i + j - i);
					break;
				}
			}
			if (flag)
				max = Math.max(max, 2 * (N - i));
		}
		return max;
	}

}
