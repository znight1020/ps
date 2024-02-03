package g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OrdinaryBackpack {
    static int answer = 0;
    static int N, K;

    static int[][] dp;

    // static List<Integer> weightList = new ArrayList<>();
    // static List<Integer> valueList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 개수
        K = Integer.parseInt(st.nextToken()); // 최대 무게
        int max = Integer.MIN_VALUE;

        dp = new int[N+1][K+1];

        int weight, value;
        for(int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            weight = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());

            // 현재 무게에서, 새로 들어온 물품의 무게가 K보다 작은경우, 새로운 물품의 가치가 추가 된 무게를 저장한다.
            // i(새로운 물품)이 갱신되면, dp[i][j]는 if 문에 의해 이전까지 새로운 들어온 물품들의 무게 합이 K보다 작은 경우의 최댓값이 들어있고, dp[i-1][j]와 비교하여 더 큰값을 집어넣는다.
            // 안넣어도 최댓값을 찾아낼 수는 있다..? -> 안 넣을 경우 마지막줄의 갱신이 이루어지지 않음
            for(int j = 0; j < K+1; j++){
                if(j + weight <= K) dp[i][j+weight] = dp[i-1][j] + value;
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
            }
        }


        System.out.print(Arrays.stream(dp[N]).max().getAsInt());

    }
    
}
