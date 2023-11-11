package lecture.section8_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Coin_exchange {
    static int m, n;
    static int answer = Integer.MAX_VALUE;
    public void DFS(int L, int sum, Integer[] arr){
        if(sum > m) return;
        if(L >= answer) return;
        if(sum == m){
            answer = L;
        } else{
            for(int i = 0; i < n; i++){
                DFS(L+1, sum + arr[i], arr);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Coin_exchange c = new Coin_exchange();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Integer[] coins;

        n = Integer.parseInt(br.readLine());
        coins = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coins, Collections.reverseOrder());
        m = Integer.parseInt(br.readLine());

        c.DFS(0, 0, coins);

        System.out.println(answer);

    }
}
