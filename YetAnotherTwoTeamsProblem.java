import java.util.Arrays;

public class YetAnotherTwoTeamsProblem {

	public long count(int[] skill) {
		int total = 0;
		for (int i = 0; i < skill.length; i++)
			total += skill[i];
		Arrays.sort(skill);
		long ret = 0;
		long[] dp = new long[total + 1];
		dp[0] = 1;
		for (int i = skill.length - 1; i >= 0; i--) {
			for (int j = total; j >= 0; j--) {
				if (j < skill[i])
					break;
				dp[j] += dp[j - skill[i]];
				if (j > total - j && j - skill[i] < total - j + skill[i])
					ret += dp[j - skill[i]];
			}
		}
		return ret;
		// return solve(skill, skill.length - 1, 0, total);
	}

	private long solve(int[] skill, int current, long team1, long total) {
		if (current < 0)
			return 0;
		if (current == 0 && team1 > total - team1)
			return 1;
		long sum = 0;
		if (team1 > total - team1
				&& team1 - skill[current] < total - team1 + skill[current])
			sum++;
		sum += solve(skill, current - 1, team1 + skill[current], total
				- skill[current]);
		sum += solve(skill, current - 1, team1, total - skill[current]);
		return sum;
	}
}
