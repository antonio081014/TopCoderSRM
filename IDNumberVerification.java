import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class IDNumberVerification
{
	// Nothing to say about this problem, just do whatever the problem asks you to do or check.
	public String verify(String id, String[] regionCodes)
	{
		String r = id.substring(0, 6);
		if(!vfRegion(r, regionCodes)) return "Invalid";
		String b = id.substring(6, 14);
		if(!vfBirth(b)) return "Invalid";
		String s = id.substring(14, 17);
		if(!vfSeq(s)) return "Invalid";
		String x = id.substring(17);
		if(!vfSum(id)) return "Invalid";
		
		return (id.charAt(16)-'0')%2==1?"Male":"Female";
	}
	
	private boolean vfSum(String s){
		int sum = s.charAt(17) == 'X' ? 10 : s.charAt(17)-'0';
		int s2 = 0;
		for(int i=0; i<17; i++){
			s2 = s2 * 2 + 2*(s.charAt(i)-'0');
		}
		return (sum + s2) % 11 == 1;
	}
	
	private boolean vfSeq(String s)
	{
		return s.compareTo("000") != 0;
	}
	
	private boolean vfBirth(String s)
	{
		int y = Integer.parseInt(s.substring(0,4));
		int m = Integer.parseInt(s.substring(4,6));
		int d = Integer.parseInt(s.substring(6,8));
		if(y <1900 || y>2011) return false;
		boolean leap = (y%400==0 || (y%4==0&&y%100!=0));
		switch(m){
		case 1:
			return d>=1 && d<=31;
		case 2:
			if(leap) return d>=1 && d<=29;
			else return d>=1 && d<=28;
		case 3:
			return d>=1 && d<=31;
		case 4:
			return d>=1 && d<=30;
		case 5:
			return d>=1 && d<=31;
		case 6:
			return d>=1 && d<=30;
		case 7:
			return d>=1 && d<=31;
		case 8:
			return d>=1 && d<=31;
		case 9:
			return d>=1 && d<=30;
		case 10:
			return d>=1 && d<=31;
		case 11:
			return d>=1 && d<=30;
		case 12:
			return d>=1 && d<=31;
		default:
		return false;
		}
	}
	
	private boolean vfRegion(String s, String[] r) {
		for(int i=0; i<r.length; i++) 
			if(s.compareTo(r[i]) == 0) return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new IDNumberVerification().verify("361101435707150182", new String[]{"130227", "510923", "141130", "361101", "360102", "131121", "370801", "141002", "500112", "431122", "340402", "360000", "433100", "513232", "110109", "411503", "330482", "441581", "430901", "210311", "530421", "610700"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Invalid";
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
		answer = new IDNumberVerification().verify("62012319240507058X", new String[]{"620123"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Female";
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
		answer = new IDNumberVerification().verify("321669197204300886", new String[]{"610111","659004"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Invalid";
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
		answer = new IDNumberVerification().verify("230231198306900162", new String[]{"230231"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Invalid";
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
		answer = new IDNumberVerification().verify("341400198407260005", new String[]{"341400"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Invalid";
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
		answer = new IDNumberVerification().verify("520381193206090891", new String[]{"532922","520381"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "Invalid";
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
