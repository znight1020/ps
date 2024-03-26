import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int N, M;
    static char[][] map;
    static int[][] dis;
    static boolean[][] vtd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dis = new int[N][M];
        vtd = new boolean[N][M];

        for(int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        BFS();
        if(dis[N-1][M-1] != 0)System.out.print(dis[N-1][M-1]);
        else System.out.print(-1);
    }

    static void BFS(){
        Queue<Point> pointQueue = new LinkedList<>();
        pointQueue.add(new Point(0,0, map[0][0]));

        while(!pointQueue.isEmpty()){
            Point p = pointQueue.poll();
            if(p.y == N-1 && p.x == M-1) return;

            if(vtd[p.y][p.x]) continue;
            vtd[p.y][p.x] = true;

            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= M || p.value == map[ny][nx]) continue;
                dis[ny][nx] = dis[p.y][p.x] + 1;
                pointQueue.add(new Point(ny, nx, map[ny][nx]));
            }
        }
    }

    static class Point{
        int y, x;
        char value;

        public Point(int y, int x, char value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }
}
