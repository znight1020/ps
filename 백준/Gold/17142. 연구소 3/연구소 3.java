import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int wallCnt = 0, safeCnt = 0, virusCnt;
    static int answer = Integer.MAX_VALUE;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] map;
    static int[][] dis;
    static boolean[][] vtd;
    static ArrayList<Point> availableVirusList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        vtd = new boolean[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    availableVirusList.add(new Point(i, j));
                    safeCnt++;
                    map[i][j] = 0;
                }
                else if(map[i][j] == 1) wallCnt++;
                else if(map[i][j] == 0) safeCnt++;
            }
        }

        ArrayList<Point> arr = new ArrayList<>();
        for(int i = 0; i < M; i++) arr.add(new Point());

        comb(0, 0, arr);

        if(answer == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(answer);

    }
    static void comb(int L, int startIdx, ArrayList<Point> virusList){
        if(L == M){
            int[][] tempMap = new int[N][N];
            boolean[][] tempVtd = new boolean[N][N];
            dis = new int[N][N];
            for(int i=0; i<map.length; i++) System.arraycopy(map[i], 0, tempMap[i], 0, map[i].length);
            for(int i=0; i<vtd.length; i++) System.arraycopy(vtd[i], 0, tempVtd[i], 0, vtd[i].length);
            BFS(tempMap, virusList, tempVtd);
            return;
        }

        for(int i = startIdx; i < availableVirusList.size(); i++){
            virusList.set(L, availableVirusList.get(i));
            comb(L+1, i+1, virusList);
        }
    }

    static void BFS(int[][] map, ArrayList<Point> virusList, boolean[][] vtd){
        virusCnt = availableVirusList.size();
        int temp = 0;
        for(int i = 0; i < availableVirusList.size(); i++) map[availableVirusList.get(i).y][availableVirusList.get(i).x] = 9;
        for(int i = 0; i < virusList.size(); i++) map[virusList.get(i).y][virusList.get(i).x] = 2;
        Queue<Point> q = new LinkedList<>(virusList);

        while(!q.isEmpty()){
            Point p = q.poll();

            if(vtd[p.y][p.x]) continue;
            vtd[p.y][p.x] = true;

            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(0 > ny || ny >= N || 0 > nx || nx >= N) continue;

                if(map[ny][nx] == 9){ // 비활성 바이러스면
                    map[ny][nx] = 2;
                    q.add(new Point(ny, nx));
                    dis[ny][nx] = dis[p.y][p.x] + 1;
                }
                if(map[ny][nx] != 0) continue; // 공기가 아니면 continue
                map[ny][nx] = 2;
                q.add(new Point(ny, nx));
                virusCnt++;

                dis[ny][nx] = dis[p.y][p.x] + 1;
                temp = Math.max(dis[ny][nx], temp);
            }
        }
        if(virusCnt == safeCnt) answer = Math.min(temp, answer);
    }



    static class Point{
        int y, x;
        public Point(){}

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
