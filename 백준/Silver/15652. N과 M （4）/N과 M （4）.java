import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] src;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        src = new int[N];
        for(int i = 0; i < src.length; i++) src[i] = i+1;
        comb(0, 0, new int[M]);
        System.out.print(sb);
    }
    static void comb(int L, int startIdx, int[] ans){
        if(L == M){
            for(int x : ans) sb.append(x + " ");
            sb.append("\n");
            return;
        }
        if(startIdx >= N) return;
        for(int i = startIdx; i < N; i++){
            ans[L] = src[i];
            comb(L+1, i, ans);
        }
    }
}
