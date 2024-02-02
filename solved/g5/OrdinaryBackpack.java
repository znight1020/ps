package g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class OrdinaryBackpack {
    static int answer = 0;
    static HashMap<Integer, Integer> map = new HashMap<>();

    static int[][] dp; // i = 가치, j = 무게

    static int solution(int K){
        // 선택된 요소들의 무게의 합이 총 무게를 넘지 않을 때
        dp[1][0] = 0;


        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int weight, value; // 무게, 가치
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 개수
        int K = Integer.parseInt(st.nextToken()); // 최대 무게

        dp = new int[N][K+1]; // i = 가치, j = 무게

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            weight = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());
            map.put(weight, value);
        }
        solution(K);
        
    }
    
}
