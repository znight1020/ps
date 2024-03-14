import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] src;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        src = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) src[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(src);
        perm(0, 0, new int[M]);
        System.out.print(sb);
    }

    static void perm(int L, int startIdx, int[] ans){
        if(L == M){
            for(int x : ans) sb.append(x).append(" ");
            sb.append("\n");
            return;
        }

        if(startIdx >= N) return;

        for(int i = startIdx; i < src.length; i++){
            ans[L] = src[i];
            perm(L+1, i, ans);
        }
    }
}
