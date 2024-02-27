package solved.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Tiling {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];


        // BottomUp 출력
        /*if(n > 2){
            dp[1] = 1;
            dp[2] = 2;
            bottomUp(n);
            System.out.print(dp[n]);
        } else{
            System.out.println(n);
        }*/


        // TopDown 출력
        System.out.println(topDown(n));
    }

    static void bottomUp(int n){
        for(int i = 3; i <= n; i++) dp[i] = (dp[i-2] + dp[i-1]) % 10007;
    }

    static int topDown(int n){
        if(n == 1) return 1;
        else if(n == 2) return 2;
        if(dp[n] != 0) return dp[n];

        return dp[n] = (topDown(n-2) + topDown(n-1)) % 10007;
    }
}
