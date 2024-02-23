package solved.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConveyorBeltSushi {

    static int N, d, k, c;
    static int[] sushi;
    static int answer = 0;
    static int max = Integer.MIN_VALUE;
    static int[] sushiDiversity;
    public static void solution(){
        for(int i = 0; i < k; i++) {
            if(sushiDiversity[sushi[i]]++ == 0) answer++;
        }
        max = answer;
        int start = 1;

        while(start <= N){
            for(int x : sushiDiversity){
                System.out.print(x + " ");
            }

            if(--sushiDiversity[sushi[start-1]] == 0) answer--;
            if(sushiDiversity[sushi[start+k-1]]++ == 0) answer++;

            if(max <= answer){
                max = answer;
                if(sushiDiversity[c] == 0) max++;
            }
            if(max == k+1) break;
            start++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 접시의 수 N, 초밥의 가짓 수 d, 연속해서 먹는 접시 수 k, 쿠폰 번호 c

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushiDiversity = new int[d+1];
        sushi = new int[N + k+1];
        for(int i = 0; i < N; i++) sushi[i] = Integer.parseInt(br.readLine());
        for(int i = N; i < N + k; i++) sushi[i] = sushi[i - N];
        solution();
        System.out.print(max);
    }
}
