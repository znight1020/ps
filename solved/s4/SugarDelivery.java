package solved.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SugarDelivery {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        while(N > 0){
            if(N % 5 == 0) {
                answer += N / 5;
                break;
            }

            N -= 3;
            answer++;
        }
        if(N < 0) System.out.println(-1);
        else System.out.println(answer);
    }
}
