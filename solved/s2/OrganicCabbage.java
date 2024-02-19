package solved.s2;

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
public class OrganicCabbage {
    static int[][] map;
    static boolean[][] vtd;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    static int M,N,K,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 배추 밭 가로길이
            N = Integer.parseInt(st.nextToken()); // 배추 밭 세로길이
            K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치 개수
            answer = 0;

            map = new int[M][N];
            vtd = new boolean[M][N];

            for(int k = 0; k < K; k++){
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] == 1 && !vtd[i][j]) BFS(i, j);
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static void BFS(int start, int end){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start, end));
        while(!q.isEmpty()){
            Point p = q.poll();
            if(vtd[p.y][p.x]) continue;
            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(0 <= ny && ny < M && 0 <= nx && nx < N && map[ny][nx] == 1){
                    q.add(new Point(ny, nx));
                    vtd[p.y][p.x] = true;
                }
            }
        }
        answer++;
    }
}
