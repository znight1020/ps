package lecture.section5_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Save_the_princess {

    public int solution(int size, int iter){
        int i = 1, prince;
        Queue<Integer> q = new LinkedList<>();
        for(int j = 1; j <= size; j++){
            q.offer(j);
        }

        while(q.size() > 1){
            prince = q.poll();
            if(i != iter) {
                q.offer(prince);
                i++;
            } else i = 1;
        }

        return q.poll();
    }
    public static void main(String[] args) throws IOException {
        Save_the_princess s = new Save_the_princess();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int iter = Integer.parseInt(st.nextToken());

        System.out.println(s.solution(size, iter));
    }
}
