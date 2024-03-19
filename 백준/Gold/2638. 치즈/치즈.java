import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int time = 0;
    static int meltCnt = 0;
    static int N, M;
    static int[][] map;
    static boolean[][] vtd;
    static ArrayList<Point> cheeseList = new ArrayList<>();
    static Queue<Point> meltList = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        vtd = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cheeseList.add(new Point(i, j, 1));
            }
        }

        map[0][0] = 2;
        while(meltCnt != cheeseList.size()){
            infect();
            melt();
        }
        System.out.println(time);
    }

    static void infect(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0, 0));
        for(Point p : meltList){
            map[p.y][p.x] = 2;
            q.add(p);
        }

        while(!q.isEmpty()){
            Point p = q.poll();
            if(vtd[p.y][p.x]) continue;
            vtd[p.y][p.x] = true;

            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] == 1 || map[ny][nx] == 2) continue;
                q.add(new Point(ny, nx, 0));
                map[ny][nx] = 2;
            }
        }
    }

    static void melt(){
        meltList.clear();
        int cnt;
        for(Point cheese : cheeseList){

            if(cheese.status == 0) continue;
            cnt = 0;
            for(int i = 0; i < 4; i++){
                int ny = cheese.y + dy[i];
                int nx = cheese.x + dx[i];

                if(map[ny][nx] == 2) cnt++;
            }
            if(cnt >= 2) {
                cheese.status = 0;
                meltList.add(cheese);
                meltCnt++;
            }
        }
        time++;
    }

    static class Point{
        int y, x, status;

        public Point(int y, int x, int status) {
            this.y = y;
            this.x = x;
            this.status = status;
        }
    }
}
