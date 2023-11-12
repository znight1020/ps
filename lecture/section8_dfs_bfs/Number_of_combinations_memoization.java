package lecture.section8_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number_of_combinations_memoization {
    public int DFS(int n, int r){
        if(n == r) return 1;
        else if(r == 1) return n;

        else{
            return DFS(n-1, r-1) + DFS(n-1, r);
        }
    }

    public static void main(String[] args) throws IOException {
        Number_of_combinations_memoization numberOfCombinationsMemoization = new Number_of_combinations_memoization();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        System.out.println(numberOfCombinationsMemoization.DFS(n,r));
    }
}
