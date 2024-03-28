import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final int INF = 987654321;
    static int[][] network;
    static int N, answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            answer = 987654321;
            N = Integer.parseInt(st.nextToken());

            network = new int[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++) {
                    network[i][j] = Integer.parseInt(st.nextToken());
                    if(network[i][j] == 0 && i != j) network[i][j] = INF;
                }
            }
            floyd();

            for(int i = 0; i < N; i++){
                int sum = 0;
                for(int j = 0; j < N; j++) sum += network[i][j];
                answer = Math.min(answer, sum);
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
    static void floyd(){
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    network[i][j] = Math.min(network[i][j], network[i][k] + network[k][j]);
                }
            }
        }
    }
}
