package lecture.section8_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Island_country_ireland_dfs {

    // 상 하 좌 우 대각선
    static int[] dx = {0,0,1,-1, -1,1,-1,1};
    static int[] dy = {1,-1,0,0, -1,-1,1,1};
    static int n;
    static int[][] land;
    static int answer = 0;

    public void DFS(int x, int y){
        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && land[nx][ny] == 1){
                land[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }

    public void solution(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 1){
                    answer++;
                    land[i][j] = 0;
                    DFS(i,j);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Island_country_ireland_dfs island = new Island_country_ireland_dfs();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        land = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        island.solution();

        System.out.println(answer);
    }
}
