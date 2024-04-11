import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static final int INF = 987654321;
    static int[][] dis;
    static int[][] path;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dis = new int[N+1][N+1];
        path = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dis[i], INF);
            for (int j = 1; j <= N; j++)
                if(i == j){
                    dis[i][j] = 0;
                    path[i][j] = 0;
                }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dis[from][to] = cost;
            dis[to][from] = cost;
            path[from][to] = to;
            path[to][from] = from;
        }
        floyd();
        for (int i = 1; i <= N; i++) {
            for(int j = 1 ; j <= N; j++) {
                if(path[i][j] == 0) sb.append("-").append(" ");
                else sb.append(path[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void floyd(){
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(dis[i][j] > dis[i][k] + dis[k][j]) {
                        path[i][j] = path[i][k];
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }
    }
}
