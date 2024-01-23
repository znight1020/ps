package s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NonRepeatNum {

    int solution(int n){
        
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if(i % 10 == i % 100 || i % 100 == i % 1000)cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        NonRepeatNum m = new NonRepeatNum();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1;
        while(true){
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            System.out.println(m.solution(n));
            
        }
    }
}
