package solved.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColorPaper {
    static int[][] square = new int[100][100];
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for(int t = 0; t < N; t++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = x1 + 10;
            int y2 = y1 + 10;

            for(int i = y1; i < y2; i++){
                for(int j = x1; j < x2; j++){
                    if(square[j][i] == 0){
                        square[j][i] = 1;
                        answer++;
                    }
                }
            }
        }
        System.out.print(answer);

    }
}
