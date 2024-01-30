package solved.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs {
    static int[] arr;
    static int[] dp;
    static void bottomUp(int[] arr){
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
        for(int i = 4; i < arr.length; i++){ // dp[2] = 30
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        arr = new int[301];
        dp = new int[301];
        for(int t = 1; t <= T; t++){
            arr[t] = Integer.parseInt(br.readLine());
        }

        bottomUp(arr);

        System.out.println(dp[T]);
    }
}
