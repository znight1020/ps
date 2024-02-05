package solved.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Top {
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<int[]> stack  = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 6 9 5 7 4
        for(int i = 1; i <= N; i++){
            int height = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if(stack.peek()[1] >= height) {
                    sb.append(stack.peek()[0]).append(" ");
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty()) sb.append(0).append(" ");
            stack.push(new int[] {i, height});
        }

        System.out.print(sb);
    }
}
