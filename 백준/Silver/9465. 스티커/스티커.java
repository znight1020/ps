import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for(int t = 0; t < T; t++) {
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[2][n];
      int[][] dp = new int[2][n];

      for(int i = 0; i < 2; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j = 0; j < n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
      }

      dp[0][0] = arr[0][0];
      dp[1][0] = arr[1][0];
      if(n == 1) sb.append(Math.max(dp[0][0], dp[1][0])).append("\n");
      else {
        dp[0][1] = dp[1][0] + arr[0][1];
        dp[1][1] = dp[0][0] + arr[1][1];
        if(n == 2) sb.append(Math.max(dp[0][1], dp[1][1])).append("\n");
        else {
          for(int j = 2; j < n; j++) {
            dp[0][j] = arr[0][j] + Math.max(dp[1][j-1], dp[1][j-2]);
            dp[1][j] = arr[1][j] + Math.max(dp[0][j-1], dp[0][j-2]);
          }
          sb.append(Math.max(dp[1][n-1], dp[0][n-1])).append("\n");
        }
      }
    }

    System.out.print(sb);
  }
}
