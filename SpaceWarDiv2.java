import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class SpaceWarDiv2
{
	public int minimalFatigue(int[] gs, int[] es, int[] cnt)
	{
		Arrays.sort(gs);
		// for(int i=0; i<es.length; i++) if(es[i] > gs[gs.length-1]) return -1;
		ArrayList<Integer> em = new ArrayList<Integer>();
		for(int i=0; i<cnt.length; i++) 
			for(int j=0; j<cnt[i]; j++) 
				em.add(es[i]);
		Collections.sort(em);
		if(em.get(em.size()-1) > gs[gs.length-1]) return -1;
		
		int lo = 0;
		int hi = em.size();
		System.out.println(p(92, es, em));
		while(lo < hi){
			int mid = (lo +hi)/2;
			if(p(mid, es, em)) hi = mid;
			else lo = mid+1;
		}
		
		return lo;
	}
	
	private boolean p(int f, int[] es, ArrayList<Integer> em){
		for(int i=es.length-1, j=em.size()-1;i>=0 ;i--){
			for(int k=0; k<f && j>=0; k++){
				if(es[i] >= em.get(j)) j--;
				else return false;
			}
			if(j<0) return true;
		}
		return false;
	}
	
	
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new SpaceWarDiv2().minimalFatigue(new int[]{2, 3, 5}, new int[]{1, 3, 4}, new int[]{2, 9, 4});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 7;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new SpaceWarDiv2().minimalFatigue(new int[]{2, 3, 5}, new int[]{1, 1, 2}, new int[]{2, 9, 4});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 5;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new SpaceWarDiv2().minimalFatigue(new int[]{14, 6, 22}, new int[]{8, 33}, new int[]{9, 1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new SpaceWarDiv2().minimalFatigue(new int[]{17, 10, 29, 48, 92, 60, 80, 100, 15, 69, 36, 43, 70, 14, 88, 12, 14, 29, 9, 40}, new int[]{93, 59, 27, 68, 48, 82, 15, 95, 61, 49, 68, 15, 16, 26, 64, 82, 7, 8, 92, 15}, new int[]{56, 26, 12, 52, 5, 19, 93, 36, 69, 61, 68, 66, 55, 28, 49, 55, 63, 57, 33, 45});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 92;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
