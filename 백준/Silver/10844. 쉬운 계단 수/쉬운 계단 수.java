import java.io.*;

public class Main {

  static final long MOD = 1_000_000_000;
  static long[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    dp = new long[N+1][10];
    for(int i = 0; i < 10; i++) dp[1][i] = 1L;

    long answer = 0;
    for(int i = 1; i < 10; i++) answer += dfs(N, i);
    System.out.print(answer % MOD);
  }

  static long dfs(int digit, int v) {
    if(digit == 1) return dp[digit][v];

    if(dp[digit][v] == 0) {
      if(v == 0) dp[digit][v] = dfs(digit-1, v+1);
      else if(v == 9) dp[digit][v] = dfs(digit-1, v-1);
      else dp[digit][v] = dfs(digit-1, v+1) + dfs(digit-1, v-1);
    }

    return dp[digit][v] % MOD;
  }
}
