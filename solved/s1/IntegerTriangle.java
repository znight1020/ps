package solved.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntegerTriangle {
    static int[][] triangle;
    static int N;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        triangle = new int[N][];
        triangle[0] = new int[1];
        triangle[0][0] = Integer.parseInt(br.readLine());

        for(int i = 1; i < N; i++){
            triangle[i] = new int[i+1];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++) {
                triangle[i][j] = triangle[i-1][j] + Integer.parseInt(st.nextToken());
                // triangle[i][j] = triangle[i-1][j-1] + Integer.parseInt(st.nextToken());

            }
        }
        DFS(0, 0,0);
        System.out.print(answer);
    }

    static void DFS(int index, int depth, int sum){
        if(depth == N){
            answer = Math.max(sum, answer);
            return;
        }

        DFS(index, depth+1, sum + triangle[depth][index]);
        DFS(index+1, depth+1, sum + triangle[depth][index]);
    }
}
