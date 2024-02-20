package solved.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point3{
    int y, x;

    public Point3(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class ColorBlindness {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] vtd;
    static int N, bAns = 0, nAns = 0;
    static Queue<Point3> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = str.charAt(j);
            }
        }

        vtd = new boolean[N][N];
        for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) if(!vtd[i][j]) normal(i, j);

        vtd = new boolean[N][N];
        for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) if(!vtd[i][j]) blind(i, j, map[i][j]);

        System.out.print(nAns + " " + bAns);
    }

    static void normal(int y, int x){
        q.add(new Point3(y, x));
        vtd[y][x]= true;
        while(!q.isEmpty()){
            Point3 p = q.poll();
            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= N || vtd[ny][nx] ) continue;

                if(map[ny][nx] == map[p.y][p.x]) {
                    q.add(new Point3(ny, nx));
                    vtd[ny][nx] = true;
                }
            }
        }
        nAns++;
    }
    static void blind(int y, int x, char color){
        q.add(new Point3(y, x));
        vtd[y][x]= true;
        while(!q.isEmpty()){
            Point3 p = q.poll();

            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= N || vtd[ny][nx] ) continue;

                if(color != 'B' && map[ny][nx] != 'B') {
                    q.add(new Point3(ny, nx));
                    vtd[ny][nx] = true;
                }
                else if(color == 'B' && map[ny][nx] == 'B') {
                    q.add(new Point3(ny, nx));
                    vtd[ny][nx] = true;
                }
            }
        }
        bAns++;
    }
}
