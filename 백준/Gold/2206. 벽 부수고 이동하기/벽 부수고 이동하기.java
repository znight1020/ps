import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] map;
    static int N, M, answer = Integer.MAX_VALUE;
    static boolean[][][] vtd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        vtd = new boolean[N][M][2];

        map = new int[N][M];

        for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        bfs();
        if(answer != Integer.MAX_VALUE) System.out.print(answer);
        else System.out.print(-1);
    }

    static void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1,1));

        while(!q.isEmpty()){
            Point p = q.poll();
            if(vtd[p.y][p.x][p.c]) continue;
            vtd[p.y][p.x][p.c] = true;
            if(p.y == N-1 && p.x == M-1){
                answer = p.d;
                return;
            }

            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                if(map[ny][nx] != 1) q.add(new Point(ny, nx, p.d + 1, p.c));
                if(map[ny][nx] == 1 && p.c == 1) q.add(new Point(ny, nx, p.d + 1, 0));
            }
        }
    }

    static class Point{
        int y, x, d, c;

        public Point(int y, int x, int d, int c) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.c = c;
        }
    }
}
