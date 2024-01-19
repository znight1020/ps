package s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Minecraft {
    static int N, M;
    static final int INF = 1000000000;
    public int[] solution1(int[][] ground, int B, int aver){
        System.out.println(aver);
        int time = 0;
        int[] returnArr = {INF, INF};
        int[] answer = new int[2];
        int current;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                current = ground[i][j];

                while(current != aver){
                    if(current > aver){
                        // 1번 방법, 땅을 파고 인벤토리에 넣는다. 시간 2
                        current--;
                        B++;
                        time += 2;
                    }
                    else if(current < aver){
                        // 2번 방법, 블록을 놓는다. 시간 1
                        current++;
                        B--;
                        time++;
                    }
                }
            }
        }
        if(B < 0) return returnArr;

        answer[0] = time;
        answer[1] = aver;

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

        int[][] ground = new int[N][M];
        int sum = 0;
        double aver;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                ground[i][j] = Integer.parseInt(st.nextToken());
                sum += ground[i][j];
            }
        }
        int[] answer;
        int[] temp1;
        int[] temp2;

        aver = sum / (N * M);

        if(sum + B < aver * N * M) {
            answer = m.solution1(ground, B, (int)Math.round(aver  - 1.0)); // 블록이 모자라서 땅을 파야됨
        }
        else{
            temp1 = m.solution1(ground, B, (int)Math.round(aver)); // 블록이 충분, 땅 팜
            temp2 = m.solution1(ground, B, (int)Math.round(aver) + 1); // // 블록이 충분, 땅 안팜

            if(temp1[0] > temp2[0]) answer = temp2;
            else if(temp1[0] == temp2[0]){
                if(temp1[1] > temp2[1]) {
                    answer = temp1;
                }
                else {
                    answer = temp2;
                }
            }
            else {
                answer = temp1;
            }
        }

        System.out.print(answer[0] + " " + answer[1]);
    }
}
