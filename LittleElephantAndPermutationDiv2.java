import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class LittleElephantAndPermutationDiv2
{
	int[][] perm;
	public long getNumber(int N, int K)
	{
		int M = 1;
		int[] array = new int[N];
		for(int i=1; i<=N; i++) {M*=i; array[i-1] = i;}
		// Order doesn't matter that much, but the pair you compare matters.
		long count = 0;
		for(int i=0; i<M; i++){
			int sum = 0;
			for(int k=0; k<N; k++){
				sum += Math.max(array[k], k + 1);
			}
			count += sum >= K ? M : 0;
			next_permutation(array);
		}
		return count;
	}
	
	public void next_permutation(int[] array) {
 		int i, j;
		 for (i = array.length - 2; i >= 0; i--) {
		     if (array[i] < array[i + 1])
		  	break;
		 }
		 if (i < 0) {
		     return;
		 }
		
		 for (j = array.length - 1; j > i; j--) {
		     if (array[j] > array[i])
		 	 break;
		 }
		
		 swap(array, i++, j);

		 for (j = array.length - 1; j > i; i++, j--) {
		     swap(array, i, j);
		 }
    }

    public void swap(int[] array, int x, int y) {
		 array[x] ^= array[y];
		 array[y] ^= array[x];
		 array[x] ^= array[y];
    }
}
//Powered by [KawigiEdit] 2.0!
