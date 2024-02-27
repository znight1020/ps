package solved.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBDistance_DFS_Fail {
    static int[] rgb = {0,1,2};
    static int ans = Integer.MAX_VALUE, N;
    static int[] answer = new int[3];
    static int[][] colorCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        answer = new int[N];
        colorCost = new int[N][3];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) colorCost[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 3; i++) DFS(1, rgb[i], colorCost[0][i]);
        System.out.print(ans);
    }

    static void DFS(int L, int preColor, int sum){
        if(L == N || ans <= sum) {
            if(ans > sum) ans = sum;
            return;
        }

        for(int i = 0; i < 3; i++){
            if(i == preColor) continue;
            DFS(L+1, i, sum + colorCost[L][i]);
        }
    }
}
