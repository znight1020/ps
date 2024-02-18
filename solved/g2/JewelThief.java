package solved.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Jewel{
    int M, V; // 무게, 가치
    Jewel(int M, int V){
        this.M = M;
        this.V = V;
    }

}
public class JewelThief {
    static PriorityQueue<Jewel> jpq = new PriorityQueue<>((o1, o2) -> {
        return o1.M - o2.M;
    });
    static int[] back;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> tempQ = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        back = new int[K];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            jpq.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for(int i = 0; i < K; i++) back[i] = Integer.parseInt(br.readLine());
        Arrays.sort(back);

        for(int i = 0; i < back.length; i++){
            while(!jpq.isEmpty() && jpq.peek().M <= back[i]) tempQ.add(jpq.poll().V);
            if(!tempQ.isEmpty()) answer += tempQ.poll();
        }

        System.out.print(answer);
    }
}
