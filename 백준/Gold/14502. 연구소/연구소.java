import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int wallCnt = 0;
    static int answer = Integer.MIN_VALUE;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] map;
    static boolean[][] vtd;
    static ArrayList<Point> virusList = new ArrayList<>();
    static ArrayList<Point> safeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        vtd = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virusList.add(new Point(i, j));
                else if(map[i][j] == 1) wallCnt++;
                else if(map[i][j] == 0) safeList.add(new Point(i, j));
            }
        }
        perm(0, 0, new Point[3]);

        System.out.print(answer);

    }

    static void BFS(int[][] map, Point[] wall, boolean[][] vtd){
        int cnt = 0;
        for(int i = 0; i < 3; i++) map[wall[i].y][wall[i].x] = 1;
        Queue<Point> q = new LinkedList<>(virusList);
        cnt += virusList.size();
        cnt += wallCnt+ 3;

        while(!q.isEmpty()){
            if(N*M-cnt < answer) return;
            Point p = q.poll();

            if(vtd[p.y][p.x]) continue;
            vtd[p.y][p.x] = true;

            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(0 > ny || ny >= N || 0 > nx || nx >= M || map[ny][nx] != 0) continue;
                map[ny][nx] = 2;
                q.add(new Point(ny, nx));
                cnt++;
            }
        }
        answer = Math.max(N*M - cnt, answer);
    }

    static void perm(int L, int startIdx, Point[] permAns){
        if(L == 3){
            int[][] tempMap = new int[N][M];
            boolean[][] tempVtd = new boolean[N][M];
            for(int i=0; i<map.length; i++) System.arraycopy(map[i], 0, tempMap[i], 0, map[i].length);
            for(int i=0; i<vtd.length; i++) System.arraycopy(vtd[i], 0, tempVtd[i], 0, vtd[i].length);
            BFS(tempMap, permAns, tempVtd);
            return;
        }

        for(int i = startIdx; i < safeList.size(); i++){
            permAns[L] = safeList.get(i);
            perm(L+1, i+1, permAns);
        }
    }

    static class Point{
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
