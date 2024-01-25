package s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOneDP {
    
    static int[] DP = new int[1001];
    static int[] vtd = new int[1001];
    static int answer;
    void DP(int num, int cnt){
        if(num == 1){
            answer = Math.min(cnt, answer);
        } else{
            if(vtd[num] != 0 || num < 1) return;
            else{
                if(num % 3 == 0) DP(num / 3, cnt++);
                if(num % 2 == 0) DP(num / 2, cnt++);
                DP(num - 1, cnt++);
            }
        }
        
        
    }
    public static void main(String[] args) throws IOException{
        MakeOneDP m = new MakeOneDP();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        m.DP(num, 0);
        
    }
    

}
