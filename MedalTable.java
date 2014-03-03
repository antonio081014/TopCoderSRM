import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class MedalTable
{
	public String[] generate(String[] res)
	{
		Map<String, Country> map = new HashMap<String, Country>();
		for(int i=0; i<res.length; i++) {
			String[] str = res[i].split("\\s");
			if(map.get(str[0]) != null) map.get(str[0]).gold++;
			else {
				Country c = new Country(str[0]);
				c.gold = 1;
				map.put(str[0], c);
			}
			if(map.get(str[1]) != null) map.get(str[1]).silver++;
			else {
				Country c = new Country(str[1]);
				c.silver = 1;
				map.put(str[1], c);
			}
			if(map.get(str[2]) != null) map.get(str[2]).bronze++;
			else {
				Country c = new Country(str[2]);
				c.bronze = 1;
				map.put(str[2], c);
			}
		}
		ArrayList<Country> list = new ArrayList<Country>();
		for(Country c : map.values()) list.add(c);
		Collections.sort(list);
		String[] ret = new String[list.size()];
		for(int i=0; i<list.size(); i++) ret[i] = list.get(i).toString();
		return ret;
	}
	
	class Country implements Comparable<Country>{
		public String name;
		public int gold;
		public int silver;
		public int bronze;
		
		public Country(String n){
			name = n;
			gold = 0;
			silver = 0;
			bronze = 0;
		}
		
		public int compareTo(Country c){
			//Country c = (Country)o;
			if(gold != c.gold) return c.gold - gold;
			if(silver != c.silver) return c.silver - silver;
			if(bronze != c.bronze) return c.bronze - bronze;
			return name.compareTo(c.name);
		}
		
		public String toString(){
			return String.format("%s %d %d %d", name, gold, silver, bronze);
		}
	}
	
	public static void main(String[] args)
	{
		long time;
		String[] answer;
		boolean errors = false;
		String[] desiredAnswer;
		
		boolean same;
		
		time = System.currentTimeMillis();
		answer = new MedalTable().generate(new String[]{"ITA JPN AUS", "KOR TPE UKR", "KOR KOR GBR", "KOR CHN TPE"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{ "KOR 3 1 0",  "ITA 1 0 0",  "TPE 0 1 1",  "CHN 0 1 0",  "JPN 0 1 0",  "AUS 0 0 1",  "GBR 0 0 1",  "UKR 0 0 1" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new MedalTable().generate(new String[]{"USA AUT ROM"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{ "USA 1 0 0",  "AUT 0 1 0",  "ROM 0 0 1" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new MedalTable().generate(new String[]{"GER AUT SUI", "AUT SUI GER", "SUI GER AUT"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{ "AUT 1 1 1",  "GER 1 1 1",  "SUI 1 1 1" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
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
