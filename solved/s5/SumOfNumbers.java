package solved.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfNumbers {
    static int answer = 1;
    static void solution(int num){
        int sum = 0;
        int start = 1, end = 1;
        int[] arr = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = i;
        }
        while(start < num){
            if(sum > num) sum -= arr[start++];
            else if(end == arr.length) break;
            else{
                sum += arr[end++];
            }

            if(sum == num) answer++;

        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        solution(num);
        System.out.print(answer);
    }
}
