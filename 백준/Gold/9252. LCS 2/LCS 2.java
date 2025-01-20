import java.util.*;
import java.io.*;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();

		System.out.println(findLcsLength(s1, s2));
		System.out.print(findLcsString(s1, s2));
	}

	static int findLcsLength(String s1, String s2) {
		int n = s1.length(), m = s2.length();
		dp = new int[n+1][m+1];

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[n][m];
	}

	static StringBuilder findLcsString(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		int i = s1.length(), j = s2.length();

		while(i > 0 && j > 0) {
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				sb.append(s1.charAt(i-1));
				i--;
				j--;
			}
			else if(dp[i-1][j] > dp[i][j-1]) i--;
			else j--;
		}
		return sb.reverse();
	}
}
