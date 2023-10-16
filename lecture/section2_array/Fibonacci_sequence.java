package lecture.section2_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci_sequence {
    public int[] solution(int num){
        int[] solArr = new int[num];
        int i = 0;
        solArr[0] = 1;
        while(i < num){
            if(i < 2) solArr[i] = 1;
            else solArr[i] = solArr[i-1] + solArr[i-2];
            i++;
        }
        return solArr;
    }

    public static void main(String[] args) throws IOException {
        Fibonacci_sequence f = new Fibonacci_sequence();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] solArr;
        solArr = f.solution(num);

        for(int i = 0; i < num; i++){
            System.out.print(solArr[i] + " ");
        }
    }
}
