package solved.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NAndM5 {
    static int[] src, ans;
    static boolean[] vtd;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        src = new int[N];
        ans = new int[M];
        vtd = new boolean[N];

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            src[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        Arrays.sort(src);
        perm(0, ans);
        System.out.print(sb);
    }

    static void perm(int L, int[] ans){
        if(L == M){
            for(int x : ans) sb.append(x).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < src.length; i++){
            if(vtd[i]) continue;
            vtd[i] = true;
            ans[L] = src[i];
            perm(L+1, ans);
            vtd[i] = false;
        }
    }
}
