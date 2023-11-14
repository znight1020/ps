package lecture.section8_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point2{
    int x,y;
    Point2(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Tomato {
    // 정수 1: 익은 토마토
    // 정수 0: 익지 않은 토마토
    // 정수 -1: 토마토가 없음
    // 익은 토마토는 상 하 좌 우에만 영향(대각선 X)
    static int[][] container, dis;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n, m;

    static Queue<Point2> q = new LinkedList<>();
    public void solution(){
        Point2 p;
        while(!q.isEmpty()){
            p = q.poll();
            for(int i = 0; i < 4; i++){
                int mx = p.x + dx[i];
                int my = p.y + dy[i];

                if(mx >= 0 && mx < n && my >= 0 && my < m && container[mx][my] == 0){
                    container[mx][my] = 1;
                    q.offer(new Point2(mx, my));
                    dis[mx][my] = dis[p.x][p.y] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Tomato t = new Tomato();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp;

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        container = new int[n][m];
        dis = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                temp = Integer.parseInt(st.nextToken());
                container[i][j] = temp;
                if(temp == 1) {
                    q.offer(new Point2(i, j));
                }
            }
        }

        t.solution();

        int answer = Integer.MIN_VALUE;
        boolean flag = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(container[i][j] == 0) flag = false;
            }
        }

        if(flag){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        } else System.out.println(-1);


    }
}
