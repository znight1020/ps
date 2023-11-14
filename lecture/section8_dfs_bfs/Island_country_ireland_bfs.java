package lecture.section8_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point3{
    int x, y;
    public Point3(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Island_country_ireland_bfs {
    static int[] dx = {0,0,1,-1, -1,1,-1,1};
    static int[] dy = {1,-1,0,0, -1,-1,1,1};
    static int n;
    static int[][] land;
    static int answer = 0;

    Queue<Point3> q = new LinkedList<>();
    public void BFS(int x, int y){
        q.offer(new Point3(x, y));
        Point3 p;
        while(!q.isEmpty()){
            p = q.poll();
            for(int i = 0; i < 8; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && land[nx][ny] == 1){
                    land[nx][ny] = 0;
                    q.offer(new Point3(nx, ny));
                }
            }
        }
    }
    public void solution(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 1) {
                    land[i][j] = 0;
                    BFS(i, j);
                    answer++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Island_country_ireland_bfs island = new Island_country_ireland_bfs();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        land = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        island.solution();

        System.out.println(answer);
    }
}
