import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] area = new boolean[101][101];
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int col = y1; col < y2; col++) {
                for(int row = x1; row < x2; row++) area[col][row] = true;
            }
        }

        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < 101; j++) if(area[i][j]) answer++;
        }

        System.out.print(answer);
    }
}
