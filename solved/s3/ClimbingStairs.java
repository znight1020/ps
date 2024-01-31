package solved.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs {
    static int[] arr;
    static int[] dp;
    static int answer;
    static void bottomUp(int[] arr){
        dp = new int[301];

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
        for(int i = 4; i < arr.length; i++){ // dp[2] = 30
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }
    }

    static int topDown(int stair){
        if(stair < 0) return 0;
        else if(stair == 0 || stair == 1) return dp[stair];

        if(dp[stair] == 0) return dp[stair] = Math.max(topDown(stair-3) + arr[stair-1], topDown(stair-2)) + arr[stair];
        else return dp[stair];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr = new int[T+1];
        /*for(int t = 1; t <= T; t++){
            arr[t] = Integer.parseInt(br.readLine());
        }*/

        // top-down 전용 arr 초기화 문
        for(int t = 0; t < T; t++){
            arr[t] = Integer.parseInt(br.readLine());
        }

        //bottomUp(arr);
        dp = new int[T];
        dp[0] = arr[0];
        if(T > 1) dp[1] = arr[0] + arr[1];
        topDown(T-1);

        System.out.print(dp[T-1]);
    }
}
