package solved.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuildingBridge {
    static int[][] vtd;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N, M;


        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            vtd = new int[M+1][N+1];

            sb.append(getComb(M,N)).append("\n");
        }

        System.out.print(sb);
    }

    static int getComb(int n, int r){
        if(n == r || r == 0) return 1;

        if(vtd[n][r] == 0) {
            vtd[n][r] = getComb(n-1, r-1) + getComb(n-1, r);
        }
        else return vtd[n][r];

        return vtd[n][r];
    }
}
