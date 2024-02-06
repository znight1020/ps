package solved.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayTurn {
    static int N,M,R;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 풀이
        for(int i = 0; i < R; i++){
            rotate();
        }

        // 출력
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rotate() { // 1회 회전
        int sy = 0, ey = N - 1;  // 시작 y, 종료 y
        int sx = 0, ex = M - 1; // 시작 x, 종료 y

        while(true){
            // 종료 조건
            if( ey - sy < 1 || ex - sx < 1 ) return;

            // 복사
            int temp = map[sy][sx];
            // top <- <-
            for(int i = sx; i < ex; i++ ){
                map[sy][i] = map[sy][i+1];
            }
            // right ^
            for(int i = sy; i < ey; i++ ){
                map[i][ex] = map[i+1][ex];
            }
            // bottom -> ->
            for(int i = ex; i > sx; i-- ){
                map[ey][i] = map[ey][i-1];
            }
            // right ^
            for(int i = ey; i > sy; i-- ){
                map[i][sx] = map[i-1][sx];
            }
            // left v
            map[sy+1][sx] = temp;

            // sy, sx, ey, ex 안쪽으로 1칸 보정
            sy += 1;
            sx += 1;
            ey -= 1;
            ex -= 1;

        }
    }
}
