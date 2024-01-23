package s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Minecraft {
    static int N, M;
    static final int INF = 1000000000;
    static int[][] ground;
    static int[] ans; // ans[0] = time; ans[1] = height;
    static boolean flag = false;

    public int[] solution(int B, int aver){ // 블록, 높이 평균
        int[][] copyGround = new int[N][M];
        
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copyGround[i][j] = ground[i][j];
			}
		}


        /// 블록이 남는다면 땅의 높이를 높인다.
        
        ans = new int[2];
        int[] temp = new int[2];
        temp[1] = aver;
        
        while(B > - 1){
            System.out.println("땅 높이 평균: " + aver);
            System.out.println("남은 블록: " + B);
            int diff;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(copyGround[i][j] > aver){ //12 10 땅이 평균보다 높은 경우
                        diff = copyGround[i][j] - aver;
                        copyGround[i][j] += diff;
                        temp[0] += 2*diff;
                        B += diff;
                        
                    } else if(copyGround[i][j] < aver){ // 땅이 평균보다 낮은 경우
                        diff = aver - copyGround[i][j];
                        copyGround[i][j] += diff;
                        temp[0] += diff;
                        B -= diff;
                    }
                }
            }

            if(B >= N*M) aver++;
            else flag = true;
        }
        

        if(B < 0) flag = true;
        temp[1] = aver;

        return temp;
    }

    public static void main(String[] args) throws IOException{
        Minecraft m = new Minecraft();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        int B = Integer.parseInt(st.nextToken()); // 인벤토리 블록 개수

        ground = new int[N][M];
        int sum = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                ground[i][j] = Integer.parseInt(st.nextToken());
                sum += ground[i][j]; // 
            }
        }
        double aver = (double)sum / (N * M); // ground의 평균높이
        double floorAver = Math.floor(aver);
        int intAver;

        
        // 0.33 보다 작으면 땅을 파는게 더 적은 시간
        if(aver - floorAver < 1.0 / 3.0){
            intAver = (int)(Math.floor(aver));
            ans = m.solution(B, intAver);
        }
        // 0.33 보다 크면 땅을 심는게 더 이득
        else{ 
            intAver = (int)(Math.ceil(aver));
            ans = m.solution(B, intAver);

            // 땅을 심으려 했지만 블록이 충분하지 못한 경우
            if(flag == true) {
                intAver = (int)(Math.floor(aver));
                ans = m.solution(B, intAver);
            }
        }
        
        for(int x : ans) System.out.print(x + " ");


        // 355 32  통과 XXXXXX
        // 4 4 36
        // 15 43 61 21
        // 19 33 31 55
        // 48 63 1 30
        // 31 28 3 8

        // 357 31


        // // 평균이 x.5 이상인 상황에서 블록이 충분하지만 땅을 파면 더 시간이 적게 걸리는 경우
        // if(B >= needsB) ans = m.solution(B, intAver-1);
        // System.out.print("\n\n평균 땅의 높이 : " + (intAver-1) + ",  ");
        // System.out.print("평균이 x.5 이상인 상황에서 블록이 충분하지만 땅을 파면 더 시간이 적게 걸리는 경우: ");
        // for(int x : ans) System.out.print(x + " ");

        // // 평균이 x.5 이상인 상황에서 블록이 충분하지 않은 경우 
        // if(B <= needsB) ans = m.solution(B, intAver-1);
        // System.out.print("\n\n평균 땅의 높이 : " + (intAver-1) + ",  ");
        // System.out.print("평균이 x.5 이상인 상황에서 블록이 충분하지 않은 경우: ");
        // for(int x : ans) System.out.print(x + " ");

        // // 평균이 x.5 미만인 경우 땅을 파고, 평균이 x.5 이상인 경우 땅을 메꾼다, 블록이 충분
        // ans = m.solution(B, intAver);
        // System.out.print("\n\n평균 땅의 높이 : " + intAver + ",  ");
        // System.out.print("평균이 x.5 이하여서 땅을 파야 더 시간이 적게 걸리는 경우: ");
        // for(int x : ans) System.out.print(x + " ");
    }
}
