package swea.d4;

import javax.sound.sampled.Port;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int y, x, no, cnt;
    Point(int y, int x, int no, int cnt){
        this.y = y;
        this.x = x;
        this.no = no;
        this.cnt = cnt;
    }
}
public class 정사각형_방 {

    // 상 하 좌 우
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static int N;
    static Queue<Point> q;

    static int num = 0;
    static int move = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            num = 0;
            move = 1;
            q = new LinkedList<>();

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    // queue 초기화 queue.clear();는 현재 필요 x BFS() 에서 완전히 empty 처리
                    q.add(new Point(i, j, map[i][j], 1));
                    BFS();
                }
            }


            System.out.print("#" + t + " ");
            System.out.print(num + " " + move);
            System.out.println();
        }
    }

    static void BFS(){
        while(! q.isEmpty() ){
            Point p = q.poll();

            if( p.cnt > move ){
                move = p.cnt;
                num = p.no;
            } else if(p.cnt == move){
                num = Math.min(p.no, num);
            }

            for(int d = 0; d < 4; d++){
                int ny = p.y +dy[d];
                int nx = p.x +dx[d];

                if(ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] != map[p.y][p.x]){
                    q.offer(new Point(ny, nx, p.no, p.cnt + 1));
                    break;
                }
            }

        }
    }
}
