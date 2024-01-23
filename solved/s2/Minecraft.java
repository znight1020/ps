package s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 출력 : ‘땅 고르기’ 작업에 걸리는 최소 시간과 그 경우 땅의 높이를 출력하시오.

public class Minecraft {
    static int N, M;
    public int[] solution(int[][] ground, int B, int min, int max){
        int[] answer = new int[2];
        answer[0] = Integer.MAX_VALUE; // 최소 시간을 출력해야 하기때문에 가장 적게 걸린 시간과, 땅의 높이 기록, 반복문 마지막

        for(int s = min; s <= max; s++){
            int tt = 0;
            int b = B;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if (ground[i][j] < s){ // 현재 땅 높이가 만들려는 층보다 낮을때, 땅을 심는다
                        tt += s - ground[i][j];
                        b -= s -ground[i][j];
                    } else { // 현재 땅 높이가 만들려는 층보다 클때, 땅을 판다
                        tt += 2 * (ground[i][j] - s);
                        b += ground[i][j] - s;
                    }
                }
            }
            if(b < 0) break; // 1층을 더 높이는데 블록이 남아있지 않다면 break를 시킨 후 answer 배열을 초기화 시키기 때문에 최대 층으로 쌓아올린 이전 값들을 기록한다
            if(answer[0] >= tt){
                answer[0] = tt;
                answer[1] = s;
            }
        }
        return answer;
    }


    public static void main(String[] args) throws IOException{
        Minecraft m = new Minecraft();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int[][] ground = new int[N][M];
        int[] answer;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                ground[i][j] = Integer.parseInt(st.nextToken());
                if(ground[i][j] > max) max = ground[i][j];
                if(ground[i][j] < min) min = ground[i][j];
            }
        }

        answer = m.solution(ground, B, min, max);
        System.out.print(answer[0] + " " + answer[1]);
    }
}
