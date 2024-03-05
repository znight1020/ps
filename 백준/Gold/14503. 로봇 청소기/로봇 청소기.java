import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] room;
    static Robot r;
    static int N, M, answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        r = new Robot(y, x, d);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) room[i][j] = Integer.parseInt(st.nextToken());
        }
        DFS(r);
        System.out.print(answer);
    }

    static void DFS(Robot p){
        boolean flag = false;
        if(room[p.y][p.x] == 0) {
            room[p.y][p.x] = 2;
            answer++;
        }

        for(int i = 0; i < 4; i++){
            int ny = p.y + dy[i];
            int nx = p.x + dx[i];
            if(ny < 0 || ny >= N || nx < 0 || nx >= M || room[ny][nx] == 1 || room[ny][nx] == 2) continue;
            if(room[ny][nx] == 0) flag = true;
        }

        if(flag) { // 청소할 칸이 있는 경우
            do {
                p.direction -= 1;
                if (p.direction == -1) p.direction = 3;
            } while (room[p.y + dy[p.direction]][p.x + dx[p.direction]] != 0);
            p.y += dy[p.direction];
            p.x += dx[p.direction];
            DFS(p);
        }
        else{ // 청소할 칸이 없는 경우
            if(room[p.y-dy[p.direction]][p.x-dx[p.direction]] != 1){
                p.y -= dy[p.direction];
                p.x -= dx[p.direction];
                DFS(p);
            }
        }
    }

    static class Point{
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static class Robot extends Point{
        int direction;

        public Robot(int y, int x, int direction) {
            super(y, x);
            this.direction = direction;
        }
    }
}