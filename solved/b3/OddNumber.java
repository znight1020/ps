package solved.b3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[7];
        int sum = 0, min = Integer.MAX_VALUE, cnt = 0;
        for(int i = 0; i < 7; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] % 2 == 1) {
                cnt++;
                sum += arr[i];
                if(arr[i] < min) min = arr[i];

            }
        }

        if(cnt > 0){
            System.out.println(sum);
            System.out.println(min);
        } else System.out.println(-1);

    }
}
