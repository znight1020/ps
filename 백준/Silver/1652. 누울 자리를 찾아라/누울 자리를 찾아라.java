import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] room;
    static int width = 0, height = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        room = new char[N][N];
        for(int i = 0; i < N; i++) room[i] = br.readLine().toCharArray();
        
        for(int i = 0; i < N; i++){
            int wCnt = 0, hCnt = 0;
            for(int j = 0; j < N; j++){
                if(room[i][j] == '.') wCnt++;
                else wCnt = 0;

                if(room[j][i] == '.') hCnt++;
                else hCnt = 0;

                if(wCnt == 2) {
                    width++;
                    wCnt = -100;
                }
                if(hCnt == 2) {
                    height++;
                    hCnt = -100;
                }
            }
        }
        System.out.print(width + " " + height);
    }
}
