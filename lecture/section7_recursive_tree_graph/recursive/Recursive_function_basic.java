package lecture.section7_recursive_tree_graph.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursive_function_basic {
    public void DFS(int n){
        if(n == 0) return;

        // etc 폴더 의 StackFrame 참고
        else{
            DFS(n - 1); // 오름차순
            System.out.print(n + " ");
            // DFS(n - 1); // 내림차순
        }
    }

    public static void main(String[] args) throws IOException {
        Recursive_function_basic r = new Recursive_function_basic();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        r.DFS(num);
    }
}
