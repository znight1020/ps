package lecture.section7_recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary_output {
    public void DFS(int num){
        if(num == 1) {
            System.out.print(1);
            return;
        }
        else {
            DFS(num / 2);
            System.out.print(num % 2);
        }
    }
    public static void main(String[] args) throws IOException {
        Binary_output b = new Binary_output();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        b.DFS(num);
    }
}
