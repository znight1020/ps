package solved.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class CourierColoring {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[][] boxes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long sum = 0;

        boxes = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) boxes[i][j] = Integer.parseInt(st.nextToken());
        }


        for(int i = 1; i < N-1; i++){
            for(int j = 1; j < M-1; j++){
                int min = Integer.MAX_VALUE;
                if(boxes[i][j] > 0) {
                    for(int d = 0; d < 4; d++){
                        int ny = i + dy[d];
                        int nx = j + dx[d];
                        min = Math.min(min, boxes[ny][nx]);
                    }
                    if(boxes[i][j] <= min) sum += boxes[i][j]-1;
                    else sum += min;
                }
            }
        }
        System.out.print(sum);
    }
}
