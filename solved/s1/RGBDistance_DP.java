package solved.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBDistance_DP {
    static int[] rgb = {0,1,2};
    static int ans = Integer.MAX_VALUE, N;
    static int dp[][];
    static int[][] colorCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        colorCost = new int[N][3];
        dp = new int[3][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                colorCost[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = colorCost[i][j] + Math.min(dp[i-1][자신제외 값1], dp[자신제외 값2]) // 자신 idx를 제외한 다른 cost 값
            }
        }

        for(int i = 0; i < 3; i++) dp[i][0] = colorCost[i][0];
        solution();
    }

    static void solution(){
        for(int i = 1; i < N; i++){
            for(int j = 0; j < 3; j++){

            }
        }


    }
}
