package solved.g4;

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
public class Cheese {
    static int time = 1;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int N, M;
    static int[][] cheese;
    static Queue<Point> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheese = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int checkNum = 0;
        q = new LinkedList<>();
        infect(0,0);

        while(checkNum != N*M){
            time++;
            melting();

            System.out.print("Time: " + time);
            System.out.println();
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    System.out.print(cheese[i][j] + "\t");
                }
                System.out.println();
            }

            checkNum = check();
        }


        System.out.println(time);


    }
    static void infect(int y, int x){
        if(cheese[y][x] != 0) return;

        cheese[y][x] = -1;
        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(0 > ny || ny >= N || 0 > nx || nx >= M) continue;

            if(cheese[ny][nx] == 0) infect(ny, nx);
            if(cheese[ny][nx] == 1) {
                q.add(new Point(ny, nx));
                cheese[ny][nx] = 2;
            }
        }
    }
    // 첫째 줄에는 치즈가 모두 녹아서 없어지는 데 걸리는 시간을 출력하고, 둘째 줄에는 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수를 출력한다.
    // default = 1; 공기가 지나간 자리는 -1; 치즈가 사라진 자리도 -1; 사라질 치즈면 2; 살아있는 치즈는 1;

    static void melting(){
        while(!q.isEmpty()){
            Point p = q.poll();
            cheese[p.y][p.x] = 0;

            infect(p.y, p.x);
        }
    }
    static int check(){
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                cnt++;
                if(cheese[i][j] != -1) break;
            }
        }
        return cnt;
    }
}
