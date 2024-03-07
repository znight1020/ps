import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 10_000_001;
    static int N, M;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];
        for(int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from][to] = Math.min(graph[from][to], cost);
        }

        floyd();

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(graph[i][j] != INF) sb.append(graph[i][j]).append(" ");
                else sb.append(0 + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void floyd(){
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                for(int k = 1; k <= N; k++)
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
    }
}
