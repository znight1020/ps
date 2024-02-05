package today_algorithm.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// Array (X), Stack => ArrayDeque
// 표준 출력 => StringBuilder
// 자료구조 (탑): 높이, 위치 int[]
// BufferedReader, Stack, 표준출력
public class Top_2 {
    static Stack<int[]> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N개의 탑을 입력 받으며 한 개씩 바로 처리
        // 유의미한 탑은 stack 에 넣고 (탑의 신호를 받을 수 있는...)
        // 무의미한 탑은 stack 에서 꺼낸다. (탑의 신호를 받을 수 없는...)
        for (int i = 1; i <= N; i++){
            int height = Integer.parseInt(st.nextToken());

            while( !stack.isEmpty() ) {
                if (stack.peek()[1] >= height) { // 현재 탑의 신호를 받을 수 있는 탑
                    System.out.print(sb.append(stack.peek()[0]).append(" "));
                    break;
                }
                // 이전(앞서 있는 탑)이 현재 탑보다 작으면 이후 탑에서 보내는 신호를 받을 수 없는 것들은 뺀다.
                stack.pop();
            }

            // 현재 기준 탑이 가장 높은 경우
            if( stack.isEmpty() ) {
                sb.append("0 ");
            }

            // 현재 탑을 stack에 넣고 다음 탑을 고려
            stack.push(new int[] {i, height});
        }

        System.out.println(sb)  ;

    }
}

