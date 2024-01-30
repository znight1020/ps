package solved.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class HanoiTop {
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(getCount(N));
        if(N <= 20){
            hanoi(N, 1,2,3); // 1번 기둥, 2번 기둥, 3번 기둥
            System.out.println(sb.toString());
        }

    }
    
    static void hanoi(int N, int start, int empty, int target){
        if(N == 0) return;

        hanoi(N-1, start, target, empty);
        sb.append(start).append(" ").append(target).append("\n");
        hanoi(N-1, empty, start, target);
    }

    static BigInteger getCount(int N){ // 하노이의 탑 이동 횟수는 (2^n-1) 개
        BigInteger base = new BigInteger("2");

        return base.pow(N).subtract(BigInteger.ONE);
    }
}
