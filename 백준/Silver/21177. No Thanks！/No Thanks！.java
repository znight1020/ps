import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()), answer, pre = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1-o2);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) pq.add(Integer.parseInt(st.nextToken()));
        if(pq.size() > 0) pre = pq.poll();
        answer = pre;

        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(cur - pre != 1) answer += cur;
            pre = cur;
        }

        System.out.print(answer);
    }
}
