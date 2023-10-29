package lecture.section7_recursive_tree_graph;

// 재귀를 사용하는 경우 StackFrame이 계속 쌓이게 되므로 성능이 안좋다
// -> 메모이제이션을 사용하면 성능이 개선 될 수 있지만(아래 ** 참고) main에서 결과를 도출하는 것이 훨씬 성능이 좋음

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 메모이제이션: 피보나치와 같은 재귀 호출에서 sol(5)를 구하는 경우 sol(3)을 두번 호출해야 하는데
 * 첫번재 sol(3) 호출 값을 미리 정의해둔 배열에 넣어둔 뒤
 * 두번째 호출에서 배열에서 값을 꺼내옴 */
public class Fibonacci_recursion {
    static int[] fibo;

    public int DFS(int n){
        //메모이제이션
        //if(fibo[n] > 0) return fibo[n]; 

        if(n == 1) return fibo[n] = 1;
        else if(n == 2) return fibo[n] = 1;
        else return fibo[n] = DFS(n - 2) + DFS(n - 1);
    }
    public static void main(String[] args) throws IOException {
        Fibonacci_recursion f = new Fibonacci_recursion();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        fibo = new int[num+1];

        f.DFS(num);

        for(int x : fibo){
            System.out.print(x + " ");
        }


    }
}
