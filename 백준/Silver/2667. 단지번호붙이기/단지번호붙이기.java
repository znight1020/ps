import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int N, answer = 0;
    static ArrayList<Integer> numList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[][] vtd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        vtd = new boolean[N][N];

        for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(vtd[i][j] || map[i][j] == 0) continue;
                answer++;
                BFS(new Point(i, j));
            }
        }
        Collections.sort(numList);
        for(int x : numList) sb.append(x).append("\n");

        System.out.println(answer);
        System.out.print(sb);
    }

    static void BFS(Point p){
        Queue<Point> q = new LinkedList<>();
        int cnt = 0;

        q.add(p);
        while(!q.isEmpty()){
            Point temp = q.poll();
            if(vtd[temp.y][temp.x]) continue;
            cnt++;
            vtd[temp.y][temp.x] = true;

            for(int i = 0; i < 4; i++){
                int ny = temp.y + dy[i];
                int nx = temp.x + dx[i];

                if(0 > ny || ny >= N || 0 > nx || nx >= N || map[ny][nx] == 0) continue;
                q.add(new Point(ny, nx));
            }
        }
        numList.add(cnt);
    }

    static class Point{
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
