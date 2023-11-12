package lecture.section8_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Guess_the_sequence {
    static int N, F;
    static int[] cArr, aArr, check;
    static boolean flag;

    public int combination(int n, int r){
        if(r == 0 || r == n) return 1;
        else if(r == 1 ) return n;
        else{
             return combination(n-1,r-1) + combination(n-1, r);
        }
    }

    public void DFS(int L, int sum){
        if(flag) return;
        if(L == N){
            if(sum == F){
                for(int x : aArr) System.out.print(x + " ");
                flag = true;
            }
        }
        else{
            for(int i = 1; i <= N; i++){
                if(check[i] == 0){
                    check[i] = 1;
                    aArr[L] = i;
                    DFS(L+1, sum +(aArr[L] * cArr[L]));
                    check[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Guess_the_sequence g = new Guess_the_sequence();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        cArr = new int[N];
        aArr = new int[N];
        check = new int[N+1];

        for(int i = 0; i < N; i++){
            cArr[i] = g.combination(N-1, i);
        }

        g.DFS(0,0);

    }
}
