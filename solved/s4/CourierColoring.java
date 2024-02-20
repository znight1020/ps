package solved.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CourierColoring {
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
            for(int j = 0; j < M; j++){
                boxes[i][j] = Integer.parseInt(st.nextToken());
                if(0 < i && i < N-1 && 0 < j && j < M-1 && boxes[i][j] > 0) sum += boxes[i][j]-1;
            }
        }
        System.out.print(sum);
    }
}
