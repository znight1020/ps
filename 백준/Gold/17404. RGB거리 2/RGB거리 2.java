import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] colorCost;
    static int[][] dp;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        colorCost = new int[N][3];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) colorCost[i][j] = Integer.parseInt(st.nextToken());
        }

        // 첫 집의 색깔 지정하고, 나머지 후보 집은 쳐다보지도 않는다. 시작 0: 빨강, 1: 초록, 2: 파랑 || 첫 집을 빨간색으로 칠했다면 colorCost[0][0], else 1001
        for(int selectColor = 0; selectColor < 3; selectColor++){

            // dp row 0 채우기
            for(int iter = 0; iter < 3; iter++){
                if(selectColor == iter) dp[0][iter] = colorCost[0][iter]; // 색 칠하기
                else dp[0][iter] = 1001;
            }

            // dp row 1부터는
            for(int i = 1; i < N; i++){
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + colorCost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + colorCost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + colorCost[i][2];

                if(i == N-1){ // 마지막 집
                    if(selectColor == 0) dp[i][0] = Math.min(dp[N-1][1],dp[N-1][2]);
                    if(selectColor == 1) dp[i][1] = Math.min(dp[N-1][0],dp[N-1][2]);
                    if(selectColor == 2) dp[i][2] = Math.min(dp[N-1][0],dp[N-1][1]);
                }
            }

            for(int i = 0; i < 3; i++) if(min > dp[N-1][i]) min = dp[N-1][i];
        }

        System.out.print(min);
    }

}
