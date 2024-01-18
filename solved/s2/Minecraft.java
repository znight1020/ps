package s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 예제 입력 3 해결(반올림 공식 사용X)
// 반올림 되더라도 땅을 모두 채울만한 블록이 없다면 땅을 다 파야됨
public class Minecraft {
    static int N, M, time;
    public void solution1(int[][] ground, int B, int aver){ // 블록이 충분한경우
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
                    else{
                        // 2번 방법, 블록을 놓는다. 시간 1
                        current++;
                        B--;
                        time++;
                    }
                }
            }
        }

        System.out.print(time + " " + aver);
    }

    public void solution2(int[][] ground, int B, int aver){ // 블록이 충분한경우
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
                    else{
                        // 2번 방법, 블록을 놓는다. 시간 1
                        current++;
                        B--;
                        time++;
                    }
                }
            }
        }

        System.out.print(time + " " + aver);
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
        aver = sum / (N * M * 1.0);
        
        if(sum + B < aver)m.solution1(ground, B, (int)Math.round(aver)); // 블록이 충분한 경우
        else m.solution2(ground, B, (int)Math.round(aver)); // 블록이 부족한 경우
        
    }
    
}
