import java.util.*;
import java.io.*;

public class Main {

    static int N, answer = -10_000_001;
    static int interval;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        interval = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        int start = 0, end = start + interval - 1, sum = 0;
        for(int i = start; i <= end; i++) sum += nums[i];
        if(answer < sum) answer = sum;

        while(end < N - 1) {
            start++;
            end++;

            sum = sum - nums[start-1] + nums[end];
            if(answer < sum) answer = sum;
        }

        System.out.println(answer);
    }
}
