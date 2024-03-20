import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] vtd;
    static int N, K;
    static double answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        vtd = new boolean[N][N];

        for(int i = 0; i < N; i++)
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        if(K >= 1) answer = map[0][1] / 2.0;
        else answer = map[0][1];
        BFS();
        System.out.print(answer);
    }
    static void BFS(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0, K, 0));

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.y == 0 && p.x == 1){
                answer = Math.min(p.time, answer);
                continue;
            }

            if (vtd[p.y][p.x] && p.time >= answer) continue;
            vtd[p.y][p.x] = true;

            for(int j = 0; j < N; j++){
                for(int m = 0; m < N; m++){
                    if(p.y == j || p.x == m || vtd[j][m]) continue;
                    q.add(new Point(j, m, p.potion, p.time + map[m][p.x]));

                    if(p.potion == 0) continue;
                    q.add(new Point(j, m, p.potion-1, p.time + map[m][p.x] / 2.0));
                }
            }
        }
    }
    static class Point{
        int y, x, potion;
        double time;
        public Point(int y, int x, int potion, double time) {
            this.y = y;
            this.x = x;
            this.potion = potion;
            this.time = time;
        }
    }
}