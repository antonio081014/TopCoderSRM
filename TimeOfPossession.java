import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class TimeOfPossession
{
	public String getTime(String[] times)
	{
		int second = 0;
		boolean isA = times[0].charAt(0) == 'A';
		int last = timestamp(times[0].split("\\s")[1]);
		for(int i=1; i<times.length; i++){
			String[] s = times[i].split("\\s");
			if(s[0].compareTo("SWITCH")==0) {
				if(isA){
					second += timestamp(s[1]) - last;
				}
				isA = !isA;
				
				last = timestamp(s[1]);
			} else if(s[0].compareTo("END") ==0 ){
				if(isA){
					second += timestamp(s[1]) - last;
				}
			} else if(s[0].compareTo("B")==0) {
				if(isA){
					second += timestamp(s[1]) - last;
				}
				isA = false;
				last = timestamp(s[1]);
			} else if(s[0].compareTo("A")==0) {
				if(isA){
					second += timestamp(s[1]) - last;
				}
				isA = true;
				last = timestamp(s[1]);
			}
		}
		return String.format("%d:%02d", second/60, second%60);
	}
	
	private int timestamp(String s){
		String[] ss = s.split(":");
		return Integer.parseInt(ss[0]) * 60 + Integer.parseInt(ss[1]);
	}
	
	public static void main(String[] args)
	{
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new TimeOfPossession().getTime(new String[]{"A 0:00","SWITCH 1:23","END 3:00"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "1:23";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new TimeOfPossession().getTime(new String[]{"A 0:00","SWITCH 1:23","SWITCH 4:50","END 15:00"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "11:33";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new TimeOfPossession().getTime(new String[]{"A 0:00","SWITCH 0:00","END 15:00"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "0:00";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
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
