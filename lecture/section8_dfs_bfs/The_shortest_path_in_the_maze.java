package lecture.section8_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Point{
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class The_shortest_path_in_the_maze {

    // 상하좌우
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] maze = new int[7][7];
    static int[][] dis = new int[7][7];
    public void solution(int x, int y){
        Queue<Point> q = new LinkedList<>();
        Point temp;
        q.offer(new Point(x,y));
        maze[x][y] = 1;
        while(!q.isEmpty()){
            temp = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx >= 0 && nx <= 6 && ny >= 0 && ny <= 6 && maze[nx][ny] == 0){
                    maze[nx][ny] = 1;
                    q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[temp.x][temp.y] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        The_shortest_path_in_the_maze m = new The_shortest_path_in_the_maze();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int temp;
        for(int i = 0; i < 7; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 7; j++){
                temp = Integer.parseInt(st.nextToken());
                maze[i][j] = temp;
            }
        }
        m.solution(0,0);
        if(dis[6][6] == 0) System.out.println(-1);
        else System.out.println(dis[6][6]);
    }
}
