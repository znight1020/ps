import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    // 상 하 좌 우
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    // 왼쪽 위(위, 아래), 오른쪽 위(위, 아래), 왼쪽 아래(위, 아래), 오른쪽 아래(위, 아래)
    static int[] knightY = {-2,-1, -2,-1, 1,2, 1,2};
    static int[] knightX = {-1,-2, 1,2, -2,-1, 2,1};

    static int K, W, H;
    static int[][] map;
    static boolean[][][] vtd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H+1][W+1];
        vtd = new boolean[H+1][W+1][K+1];
        for(int i = 1; i <= H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) map[i][j] = -1;
            }
        }

        BFS();
    }

    static void BFS(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1, 0, K));
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.y == H && p.x == W) {
                System.out.print(p.d);
                return;
            }

            if(vtd[p.y][p.x][p.k]) continue;
            vtd[p.y][p.x][p.k] = true;


            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(check(ny, nx, p.k)) {
                    q.add(new Point(ny, nx, p.d+1, p.k));
                }

            }

            if(p.k == 0) continue;
            for(int i = 0; i < 8; i++){
                int ny = p.y + knightY[i];
                int nx = p.x + knightX[i];

                if(check(ny, nx, p.k)){
                    q.add(new Point(ny, nx, p.d + 1, p.k - 1));
                }

            }
        }
        System.out.print(-1);
    }

    static boolean check(int y, int x, int k){
        return (0 < y && y <= H && 0 < x && x <= W && map[y][x] != -1 && !vtd[y][x][k]);
    }

    static class Point{
        int y, x, d, k;

        public Point(int y, int x, int d, int k) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.k = k;
        }
    }
}
