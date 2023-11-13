package lecture.section8_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Finding_combinations {
    static int m, n;
    static int[] com;
    public void solution(int L, int s){
        if(L == n){
            for(int x : com){
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else{
            for(int i = s; i <= m; i++){
                com[L] = i;
                solution(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Finding_combinations f = new Finding_combinations();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        com = new int[n];

        f.solution(0, 1);

    }
}
