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
    static char[][] map;
    static boolean[][] vtd;
    static Point out;
    static int R, C, answer = Integer.MAX_VALUE;
    static Queue<Point> waterList = new LinkedList<>();
    static Queue<Point> gosumList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        vtd = new boolean[R][C];
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S') gosumList.add(new Point(i, j, 0));
                else if(map[i][j] == 'D') out = new Point(i, j);
                else if(map[i][j] == '*') waterList.add(new Point(i, j));
            }
        }
        while(!gosumList.isEmpty()){
            flow();
            move();
        }

        if(answer == Integer.MAX_VALUE) System.out.print("KAKTUS");
        else System.out.print(answer);
    }
    static void move(){
        int size = gosumList.size();


        for(int i = 0; i < size; i++){
            Point gosum = gosumList.poll();
            if(vtd[gosum.y][gosum.x]) continue;
            vtd[gosum.y][gosum.x] = true;

            if(Math.abs(gosum.y - out.y) + Math.abs(gosum.x - out.x) <= 1){
                gosumList.add(new Point(out.y, out.x, gosum.d+1));
            }

            if(gosum.y == out.y && gosum.x == out.x){
                answer = gosum.d;
                gosumList.clear();
                return;
            }

            for(int j = 0; j < 4; j++){
                int ny = gosum.y + dy[j];
                int nx = gosum.x + dx[j];
                if(ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == 'X' || map[ny][nx] == '*' || vtd[ny][nx]) continue;
                gosumList.add(new Point(ny, nx, gosum.d+1));
            }
        }

    }
    static void flow(){
        int size = waterList.size();
        for(int s = 0; s < size; s++){
            if(!waterList.isEmpty()) {
                Point water = waterList.poll();
                for(int i = 0; i < 4; i++){
                    int ny = water.y + dy[i];
                    int nx = water.x + dx[i];

                    if(ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == 'X' || map[ny][nx] == 'D' || map[ny][nx] == '*') continue;
                    map[ny][nx] = '*';
                    waterList.add(new Point(ny, nx));
                }
            }
        }
    }
    static class Point{
        int y, x, d;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
        public Point(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
}
