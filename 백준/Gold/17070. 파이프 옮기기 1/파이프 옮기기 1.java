import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Point target;
    static int[][] map;
    static int currentPosition = 0;
    static int[] dy = {0, 1, 1};

    static int[] dx = {1, 1, 0};
    static int count = 0;
    static boolean[][] vtd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        vtd = new boolean[N+1][N+1];
        vtd[1][1] = true;
        vtd[1][2] = true;

        target = new Point(N, N);
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) vtd[i][j] = true;
            }
        }

        DFS(1, 2, currentPosition);
        System.out.print(count);
    }

    static void DFS(int y, int x, int currentPosition){
        if(y == target.y && x == target.x){
            count++;
            return;
        }

        for(int i = 0; i < 3; i++){
            if(Math.abs(i - currentPosition) == 2) continue;

            int ny = y + dy[i];
            int nx = x + dx[i];
            if(!check(ny, nx)) continue;
            if(i == 1 && !diagonalCheck(ny, nx)) continue;
            vtd[ny][nx] = true;
            DFS(ny, nx, i);
            vtd[ny][nx] = false;
        }
    }
    static boolean check(int y, int x){
        return y >= 1 && y <= N && x >= 1 && x <= N && !vtd[y][x];
    }
    static boolean diagonalCheck(int y, int x){
        return 1 <= y - 1 && y - 1 <= N && 0 <= x - 1 && x - 1 <= N && map[y - 1][x] == 0 && map[y][x - 1] == 0;
    }

    static class Point{
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
