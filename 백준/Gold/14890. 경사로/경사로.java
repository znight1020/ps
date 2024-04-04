import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, answer = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) searchRow(i);
        for(int i = 0; i < N; i++) searchCol(i);

        System.out.println(answer);
    }

    static void searchRow(int row){
        boolean[] vtd = new boolean[N];
        for(int i = 0; i < N-1; i++){
            int diff = Math.abs(map[row][i+1] - map[row][i]);
            if(diff > 1) return; 

            if(diff == 1){
                if(map[row][i+1] > map[row][i]) { 
                    if(i - (L-1) < 0) return; 

                    int num = map[row][i]; 
                    for(int j = i; j >= i-(L-1); j--){
                        if(vtd[j]) return;
                        if(map[row][j] != num) return; 
                    }

                    for(int j = i; j >= i-(L-1); j--) vtd[j] = true; 
                }
                else {
                    if( (i+1) + (L-1) >= N) return; 

                    int num = map[row][i+1]; 
                    for(int j = i+1; j < (i+1) + L; j++){
                        if(vtd[j]) return;
                        if(map[row][j] != num) return; 
                    }
                    for(int j = i+1; j < (i+1) + L; j++) vtd[j] = true;
                }
            }
        }
        answer++;
    }

    static void searchCol(int col){
        boolean[] vtd = new boolean[N];
        for(int i = 0; i < N-1; i++){
            int diff = Math.abs(map[i+1][col] - map[i][col]);
            if(diff > 1) return; 

            if(diff == 1){
                if(map[i+1][col] > map[i][col]) { 
                    if(i - (L-1) < 0) return; 

                    int num = map[i][col]; 
                    for(int j = i; j >= i-(L-1); j--){
                        if(vtd[j]) return;
                        if(map[j][col] != num) return; 
                    }

                    for(int j = i; j >= i-(L-1); j--) vtd[j] = true;
                }
                else {
                    if( (i+1) + (L-1) >= N) return;

                    int num = map[i+1][col];
                    for(int j = i+1; j < (i+1) + L; j++){
                        if(vtd[j]) return;
                        if(map[j][col] != num) return;
                    }

                    for(int j = i+1; j < (i+1) + L; j++) vtd[j] = true;
                }
            }
        }
        answer++;
    }
}