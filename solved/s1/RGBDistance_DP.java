package solved.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGBDistance_DP {
    static int N;
    static int[][] colorCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        colorCost = new int[N][3];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                colorCost[i][j] = Integer.parseInt(st.nextToken());
                int temp = Integer.MAX_VALUE;
                for(int k = 0; k < 3; k++){
                    if(j == k) continue;
                    if (i > 0 && colorCost[i][j] + colorCost[i-1][k] < temp) temp = colorCost[i][j] + colorCost[i-1][k];
                }
                if(i > 0)colorCost[i][j] = temp;
            }
        }

        System.out.print(Arrays.stream(colorCost[N-1]).min().getAsInt());
    }
}
