import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static char[] W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = st.nextToken().toCharArray();
            int answer = findMaxMCS();

            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    public static int findMaxMCS(){
        HashMap<Long, Integer> mcs = new HashMap<>();
        int[] count = new int[4];
        for(int i = 0; i < W.length-N+1; i++){
            for(int j = i; j < i+N; j++) {
                if(W[j] == 'A') count[0]++;
                else if(W[j] == 'T') count[1]++;
                else if(W[j] == 'G') count[2]++;
                else if(W[j] == 'C') count[3]++;
            }
            long hash = 0;
            for(int idx = 0; idx < 4; idx++) {
                if(idx == 0) hash += 601*601*601*count[idx];
                else if(idx == 1) hash += 601*601*count[idx];
                else if(idx == 2) hash += 601*count[idx];
                else if(idx == 3) hash += count[idx];
                count[idx] = 0;
            }
            mcs.put(hash, mcs.getOrDefault(hash, 0)+1);
        }

        int max = Integer.MIN_VALUE;
        for (Integer value : mcs.values()) max = Math.max(max, value);
        return max;
    }
}
