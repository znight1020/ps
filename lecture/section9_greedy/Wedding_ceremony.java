package lecture.section9_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Wedding_ceremony {
    public static void main(String[] args) throws IOException {
        Wedding_ceremony w = new Wedding_ceremony();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] check = new int[73];
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int j = start; j < end; j++){
                check[j] += 1;
                if(check[j] > max) max = check[j];
            }
        }
        System.out.println(max);
    }
}
