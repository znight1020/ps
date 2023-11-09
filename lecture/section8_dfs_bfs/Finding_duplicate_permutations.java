package lecture.section8_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Finding_duplicate_permutations {
    static int n, m;
    static int[] pm;
    public void DFS(int l){
        if(l == m){
            for(int x : pm){
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else{
            for(int i = 1; i <= n; i++){
                pm[l] = i;
                DFS(l+1);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Finding_duplicate_permutations f = new Finding_duplicate_permutations();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pm = new int[m];

        f.DFS(0);


    }
}
