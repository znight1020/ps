package solved.s3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class TaskNeverEnd {
    static int pointAmount = 0;
    static Stack<Task> stack = new Stack<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            if(Integer.parseInt(st.nextToken()) == 1) {
                int point = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                stack.add(new Task(point, time));
            }

            if(!stack.isEmpty()) {
                stack.peek().time -= 1;
                if(stack.peek().time == 0) {
                    pointAmount += stack.peek().point;
                    stack.pop();
                }
            }

        }

        System.out.print(pointAmount);

    }

    static class Task {
        int point, time;
        public Task(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }

}
