package s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class FindSumOfIntervals6 {
    static StringBuilder sb = new StringBuilder();
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 표의 크기
        int M = Integer.parseInt(st.nextToken()); // 연산 실행 횟수
        int x1, y1, x2, y2;
        matrix = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++)  matrix[i][j] = matrix[i][j-1]+ Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            solution(x1,y1,x2,y2);
        }
        System.out.print(sb);
    }

    static void solution(int x1, int y1, int x2, int y2){
        long sum = 0;
        for(int i = x1; i <= x2; i++) sum += matrix[i][y2] - matrix[i][y1-1];
        sb.append(sum).append("\n");
    }
}
