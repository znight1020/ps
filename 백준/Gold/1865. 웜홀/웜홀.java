import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static ArrayList<Edge>[] edgeList;
    static int[] dis;
    static int N,M,W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            edgeList = new ArrayList[N+1];
            for(int i = 0; i <= N; i++) edgeList[i] = new ArrayList<>();
            matrix = new int[N+1][N+1];
            dis = new int[N+1];


            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edgeList[S].add(new Edge(E, T));
                edgeList[E].add(new Edge(S, T));
            }

            for(int i = 0; i < W; i++){
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edgeList[S].add(new Edge(E, -T));
            }
            if(BellmanFord()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.print(sb);

    }

    static boolean BellmanFord(){
        dis = new int[N+1];
        boolean flag = false;

        for(int i = 1; i <= N; i++){
            flag = false;

            for(int j = 1; j <= N; j++){
                for(Edge e : edgeList[j]){
                    if(dis[e.to] > dis[j] + e.cost){
                        dis[e.to] = dis[j] + e.cost;
                        flag = true;
                    }
                }
            }
            if(!flag) break;
        }
        return flag;
    }

    static class Edge{
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
