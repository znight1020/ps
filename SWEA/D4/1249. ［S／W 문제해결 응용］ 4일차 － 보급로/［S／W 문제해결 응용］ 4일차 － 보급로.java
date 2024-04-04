import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static final int INF = 987654321;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] dis;
    static int N, answer;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dis = new int[N][N];
            for(int i = 0; i < N; i++) Arrays.fill(dis[i], INF);
            for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            dijkstra();
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static void dijkstra(){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        Point start = new Point(0,0,0);

        pq.add(start);

        while(!pq.isEmpty()){
            Point p = pq.poll();
            if(p.x == N-1 && p.y == N-1) {
                answer = p.time;
                return;
            }

            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= N || dis[ny][nx] != INF) continue;
                dis[ny][nx] = p.time + map[ny][nx];
                pq.add(new Point(ny, nx, dis[ny][nx]));
            }
        }
    }

    static class Point implements Comparable<Point> {
        int y, x, time;

        public Point(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
        @Override
        public int compareTo(Point o){
            return this.time - o.time;
        }
    }
}
