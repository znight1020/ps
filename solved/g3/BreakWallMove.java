package solved.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Point{
    int y, x;
    Point(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class BreakWallMove {
    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N,M;
    static int[][] map;
    static int[][] map2;
    static int min = Integer.MAX_VALUE;
    static int[][] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        map2 = new int[N+1][M+1];
        dis = new int[N+1][M+1];

        for(int i = 1; i <= N; i++){
            int[] temp = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            if (M >= 0) {
                System.arraycopy(temp, 0, map[i], 1, M);
                System.arraycopy(temp, 0, map2[i], 1, M);
            }
        }

        int temp1 = solution1(1,1,0); // 벽 안뚫
//        if(N == 1 && M == 1) System.out.println(1);
//        else{
//            if(dis[N][M] != 0) System.out.println(dis[N][M] + 1);
//            else System.out.println(-1);
//        }

        int temp2 = solution2(1,1,1); // 벽 안뚫
//        if(N == 1 && M == 1) System.out.println(1);
//        else{
//            if(dis[N][M]  != 0) System.out.println(dis[N][M] + 1);
//            else System.out.println(-1);
//        }

        if(N == 1 && M == 1) System.out.println(1);
        else if(temp1 != 0 && temp2 != 0) System.out.println(Math.min(temp1, temp2));
        else if(temp1 == 0 && temp2 != 0) System.out.println(temp2);
        else if(temp1 != 0 && temp2 == 0) System.out.println(temp1);
        else System.out.println(-1);


    }

    static int solution1(int y, int x, int chance){ // 벽 안뚫
        dis = new int[N+1][M+1];
        dis[1][1] = 1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(y, x));
        Point p;
        while(!q.isEmpty()){
            p = q.poll();

            for(int i = 0; i < dx.length; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(0 < ny && ny <= N && 0 < nx && nx <= M && map[ny][nx] == 0){
                    map[ny][nx] = 2;
                    q.offer(new Point(ny, nx));
                    dis[ny][nx] = dis[p.y][p.x] + 1;
                }
            }
        }
        return dis[N][M];
    }
    static int solution2(int y, int x, int chance){
        dis = new int[N+1][M+1];
        dis[1][1] = 1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(y, x));
        Point p;
        while(!q.isEmpty()){
            p = q.poll();
            System.out.println(chance);
            for(int i = 0; i < dx.length; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(0 < nx && nx <= M && 0 < ny && ny <= N &&  map2[ny][nx] == 0){
                    map2[ny][nx] = 2;
                    q.offer(new Point(ny, nx));
                    dis[ny][nx] = dis[p.y][p.x] + 1;
                }
                else if(chance == 1 && 0 < ny && ny <= N && 0 < nx && nx <= M &&  map2[ny][nx] == 1){
                    // 무한루프
                    map2[ny][nx] = 0;
                    map2[p.y][p.x] = 1; // 벽을 부수었던 곳은 벽으로 막는다.
                    chance--;

                    if(0 < nx+dx[i] && nx+dx[i] <= M && 0 < ny+dy[i] && ny+dy[i] <= N && map2[ny+dy[i]][nx+dx[i]] == 1){ // 한번 더 나아간 곳이 벽인 경우
                        map2[p.y][p.x] = 0;
                        map2[ny][nx] = 1; // 벽을 허문 곳은 다시 벽을 친다.
                        chance++;
                    }
                    else if(0 < nx+dx[i] && nx+dx[i] <= M && 0 < ny+dy[i] && ny+dy[i] <= N && map2[ny+dy[i]][nx+dx[i]] == 0){
                        q.offer(new Point(ny+dy[i], nx+dx[i]));
                        System.out.println("else 여기?");
                        dis[ny][nx] = dis[p.y][p.x] + 1;
                        dis[ny+dy[i]][nx+dx[i]] = dis[ny][nx] + 1;
                    }

                }
            }
        }
        return dis[N][M];
    }

}
