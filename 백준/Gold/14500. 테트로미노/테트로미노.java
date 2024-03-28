import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] poly = {
            
            {{0,0,1,1},{0,1,0,1}},  // ㅁ

            {{0,1,2,3},{0,0,0,0}},
            {{0,0,0,0},{0,1,2,3}}, // ㅡ

            {{0,1,2,2},{0,0,0,1}},
            {{0,0,0,1},{0,1,2,0}},
            {{0,0,1,2},{0,1,1,1}},
            {{0,0,0,-1},{0,1,2,2}}, // L

            {{0,0,-1,-2},{0,1,1,1}},
            {{0,1,1,1},{0,0,1,2}},
            {{0,0,1,2},{0,1,0,0}},
            {{0,0,0,1},{0,1,2,2}}, // L 대칭

            {{0,1,1,1},{1,0,1,2}},
            {{0,0,0,1},{0,1,2,1}}, // ?
            {{0,1,1,2},{0,0,1,0}},
            {{1,0,1,2},{0,1,1,1}}, // ㅗ

            {{0,1,1,2},{0,0,1,1}},
            {{1,1,0,0},{0,1,1,2}},
            {{0,1,1,2},{1,1,0,0}},
            {{0,0,1,1},{0,1,1,2}} // 계단
    };


    static int[][] map;
    static int N, M, answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int h = 0; h < N; h++) for(int w = 0; w < M; w++) calculatePoint(h, w);
        System.out.println(answer);
    }

    static void calculatePoint(int h, int w){
        for(int i = 0; i < poly.length; i++){
            int sum = 0;
            for(int k = 0; k < 4; k++){
                int ny = h + poly[i][0][k];
                int nx = w + poly[i][1][k];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    sum = 0;
                    break;
                }
                sum += map[ny][nx];
            }
            if(answer < sum) answer = sum;
        }
    }
}
