package today_algorithm.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs {

    public int solution(int[] stairPoint){
        
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int stairs = Integer.parseInt(br.readLine());
        int[] stairPoint = new int[stairs];
        for(int i = 0; i < stairs; i++){
            stairPoint[i] = Integer.parseInt(br.readLine());
        }
    }
    
    
}
