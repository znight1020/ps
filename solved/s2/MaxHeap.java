package s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {

    public static void main(String[] args) throws IOException{
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()), temp;
        for(int i = 0; i < n; i++){
            temp = Integer.parseInt(br.readLine());

            if(temp != 0) maxHeap.add(temp);
            else {
                if(maxHeap.isEmpty()) sb.append(0);
                else sb.append(maxHeap.poll());

                sb.append("\n");
            }
        }

        System.out.print(sb);

    }
}