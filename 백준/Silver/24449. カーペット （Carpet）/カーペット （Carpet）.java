import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] vtd;
    static int H, W, answer = Integer.MAX_VALUE;
    static Point startPoint = new Point(0,0);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        vtd = new boolean[H][W];
        for(int i = 0; i < H; i++) map[i] = br.readLine().toCharArray();

        DFS(startPoint, 0, new boolean[H][W]);
        vtd[0][0] = true;
        if(answer == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(answer);
    }

    static void DFS(Point p, int cnt, boolean[][] vtd){
        char current = map[p.y][p.x];
        if(cnt >= answer) return;
        if(p.y == H-1 && p.x == W-1) {
            answer = Math.min(answer, cnt);
            return;
        }

        for(int i = 0; i < 4; i++){
            int ny = p.y + dy[i];
            int nx = p.x + dx[i];

            if(ny < 0 || ny >= H || nx < 0 || nx >= W || vtd[ny][nx] || map[ny][nx] == current) continue;
            vtd[ny][nx] = true;
            DFS(new Point(ny, nx), cnt + 1, vtd);
            vtd[ny][nx] = false;
        }
    }

    static class Point{
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
