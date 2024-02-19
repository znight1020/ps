package solved.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Point{
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class EasyShortestPath {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] map;
    static int[][] dis;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 세로의 크기
        m = Integer.parseInt(st.nextToken()); // 가로의 크기

        Point start = null;
        map = new int[n][m];
        dis = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) start = new Point(i, j);
            }
        }

        BFS(start);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dis[i][j] == 0 && map[i][j] == 1) dis[i][j] = -1;
                sb.append(dis[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void BFS(Point start){
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            Point temp = q.poll();
            for(int i = 0; i < 4; i++){
                int ny = temp.y + dy[i];
                int nx = temp.x + dx[i];

                if(0 <= ny && ny < n && 0 <= nx && nx < m && map[ny][nx] == 1){
                    map[ny][nx] = 0;
                    dis[ny][nx] = dis[temp.y][temp.x] + 1;
                    q.add(new Point(ny, nx));
                }
            }
        }
    }
}
