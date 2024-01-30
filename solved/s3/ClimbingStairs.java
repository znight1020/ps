package solved.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs {
    static int[] dp;
    static void bottomUp(int[] arr){
        int cnt = 0;
        dp[0] = 0;
        for(int i = 1; i < arr.length; i++){

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        dp = new int[T+1];
        for(int t = 0; t < T; t++){
            arr[t] = Integer.parseInt(br.readLine());
        }

        bottomUp(arr);
    }
}
