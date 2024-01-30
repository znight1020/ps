package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder1 {

    // 하 좌 우
    static int[] dx = {1, 0, 0};
    static int[] dy = {0, -1, 1};
    static final int N = 101;
    static int[][] map = new int[N+1][N+1];
    static int answer = 0;
    static int target;
    static void solution(){
        int j, i, tempAnswer;
        for(j = 1; j < N; j++){ // j = x, i = y
            tempAnswer = j;
            if(map[1][j] == 1){
                i = 1;
                while(i < N-1){

                    if(0 <= i + dx[0] && i + dx[0] < N){
                        if(j + dy[1] < N && 0 <= j + dy[1] && map[i][j + dy[1]] == 1) { // 왼쪽 길이 있는 경우
                            while(map[i][j + dy[1]] == 1) {
                                j += dy[1];
                            }
                        } else if (0 <= j + dy[2] && j + dy[2] < N && map[i][j + dy[2]] == 1) {  // 오른쪽 길이 있는 경우
                            while(map[i][j + dy[2]] == 1) {
                                j += dy[2];
                                System.out.println(j);
                            }
                            i+=1;
                        } else i += dx[0]; // 밑으로
                    }

                }
                if(map[i][j] == 2) answer = tempAnswer;
            }
            j = tempAnswer;

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int t = 1; t < 2; t++){
            int testNum = Integer.parseInt(br.readLine());
            // map 초기화
            for(int i = 1; i < 101; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j < 101; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solution();
            System.out.println("#" + t + " " + answer);
        }
    }
}
