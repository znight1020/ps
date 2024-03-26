import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] map;
    static int[][] dis;
    static int N;

    public static void main(String[] args) throws IOException {
        int cnt = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            map = new int[N][N];
            dis = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                Arrays.fill(dis[i], INF);
                for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }
            dijkstra();
            sb.append("Problem ").append(cnt).append(": ").append(dis[N-1][N-1]).append("\n");
            cnt++;
        }
        System.out.print(sb);
    }

    static void dijkstra(){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0,0, map[0][0]));

        while(!pq.isEmpty()){
            Point p = pq.poll();

            if(p.y == N-1 && p.x == N-1) return;

            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= N || dis[ny][nx] != INF) continue;
                if(dis[ny][nx] >= p.d + map[ny][nx]){
                    dis[ny][nx] = p.d + map[ny][nx];
                    pq.add(new Point(ny, nx, p.d + map[ny][nx]));
                }
            }
        }
    }

    static class Point implements Comparable<Point>{
        int y, x, d;

        public Point(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }

        @Override
        public int compareTo(Point o) {
            return this.d - o.d;
        }
    }
}
