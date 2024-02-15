package solved.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bakery {
    // 오른쪽 위, 가운데, 아래
    static char[][] map;
    static int[] dr = {-1,0,1};
    static int[] dc = {1,1,1};
    static int R;
    static int C;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C]; // R 세로, C 가로
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < R; i++) DFS(i, 0);
        System.out.print(answer);
    }

    static boolean DFS(int r, int c){
        if(c == C-1) {
            answer++;
            return true;
        }
        for(int i = 0; i < 3; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(0 <= nr && nr < R && map[nr][nc] == '.') map[nr][nc] = 'x';
            else continue;

            if(DFS(nr, nc)) return true;
        }

        return false;
    }
}
