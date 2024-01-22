package s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// DP

class Fibonacci{
    static int[] fi;
    static int zero = 0;
    static int one = 0;
    void solution(int num){
        fibo(num);
    }

    int fibo(int num){

        if (num == 0) {
            fi[0] = 0;
            zero++;
            return 0;
            
        } else if (num == 1) {
            fi[1] = 1;
            one++;
            return 1;
        } else {
            return fibo(num-1) + fibo(num-2);
        }
    }

    public static void main(String[] args) throws IOException {
        
        Fibonacci f = new Fibonacci();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            zero = 0;
            one = 0;
            fi = new int[n+1];
            f.solution(n);
            System.out.print("value: " + fi[n] + ", " + "zero: " + zero + ", one: ");
            System.out.println(one);
        }
    }
}