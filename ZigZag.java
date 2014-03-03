public class ZigZag {

	/**
	 * count[i][0] represents the number of sequence numbers with ith number as the new peek.
	 * count[i][1] represents the number of sequence numbers with ith number as the new valley.
	 * */
	public int longestZigZag(int[] sequence) {
		int N = sequence.length;
		int[][] count = new int[N+1][2];
		for(int i=1; i<=N; i++){
			for(int j=i-1; j>=0; j--){
				if(j==0) {
					count[i][0] = Math.max(1, count[i][0]);
					count[i][1] = Math.max(1, count[i][1]);
				} else if(sequence[i-1]>sequence[j-1]){
					count[i][0] = Math.max(count[i][0], count[j][1]+1);
				}else if(sequence[i-1]<sequence[j-1]){
					count[i][1] = Math.max(count[i][1], count[j][0]+1);
				}
			}
		}
		return Math.max(count[N][0], count[N][1]);
	}

}
