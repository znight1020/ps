package solved.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class AbsHeap {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static HashMap<Integer, Integer> map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int x;
        map = new HashMap<>();

        for(int t = 0; t < T; t++){
            x = Integer.parseInt(br.readLine());

            if (x == 0) {
                printPQ();
            } else {
                putPQ(x);
            }
        }

        System.out.print(sb);

    }

    static void putPQ(int x){
        int m = Math.abs(x);
        if(x < 0) map.put(m , map.getOrDefault(m, 0) + 1 );
        else map.put(m, map.getOrDefault(m, 0));
        pq.add(m);
    }
    static void printPQ(){
        if(!pq.isEmpty()) {
            int tempNum = pq.poll();
            if(map.containsKey(tempNum) && map.get(tempNum) > 0) {
                map.put(tempNum, map.get(tempNum) - 1);
                if(map.get(tempNum) == 0) map.remove(tempNum);
                sb.append("-");
            }
            sb.append(tempNum).append("\n");
        }
        else sb.append(0).append("\n");
    }
}
