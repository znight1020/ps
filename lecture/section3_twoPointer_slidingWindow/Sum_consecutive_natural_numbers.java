package lecture.section3_twoPointer_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum_consecutive_natural_numbers {
    public int solution(int num){
        int i, temp, p, sol = 0;
        int[] arr = new int[num - 1];

        for(i = 0; i < num - 1; i++){
            arr[i] = i + 1;
        }

        for(i = 0; i < num - 1; i++){
            temp = 0;
            p = i;
            while(temp < num && p < (num-1)){
                temp += arr[p];
                p++;
            }

            if(temp == num) sol++;
        }

        return sol;
    }
    public static void main(String[] args) throws IOException {
        Sum_consecutive_natural_numbers s = new Sum_consecutive_natural_numbers();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        System.out.println(s.solution(num));
    }
}
