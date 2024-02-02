package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 암호생성기 {
    static ArrayDeque<Integer> dq;
    static int[] ans = new int[8];

    static void solution(){
        int temp, cnt = 1;
        while(!dq.contains(0)){
            if(cnt > 5) cnt = 1;

            temp = dq.poll() - cnt;
            if(temp < 0) temp = 0;
            dq.addLast(temp);

            cnt++;
        }
        for(int i = 0; i < 8; i++){
            ans[i] = dq.poll();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int t = 1; t <= 10; t++){
            dq = new ArrayDeque<>();

            br.readLine();
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                dq.addLast(Integer.parseInt(st.nextToken()));
            }

            solution();
            System.out.print("#" + t + " ");
            for(int x : ans){
                System.out.print(x + " ");
            }
            System.out.println();

        }
    }
}
