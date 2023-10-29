package lecture.section7_recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Finding_a_subset {
    static int n;
    static int[] check;

    public void DFS(int level){
        String subset = "";
        if(level == n + 1){
            for(int i = 1; i <= n; i++){
                if(check[i] == 1) subset += (i + " "); // 해당 숫자를 포함하면 check[index] 값은 1
            }
            if(check.length > 0) System.out.println(subset);
        } else{
            check[level] = 1; // 해당 숫자를 포함한다.
            DFS(level+1);
            check[level] = 0; // 해당 숫자를 포함하지 않는다
            DFS(level+1);
        }
    }
    public static void main(String[] args) throws IOException {
        Finding_a_subset f = new Finding_a_subset();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        check = new int[n+1];
        f.DFS(1);
    }
}
