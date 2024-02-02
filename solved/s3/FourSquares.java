package solved.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class FourSquares {
    static int answer = 0;
    static void solution(int n){
        int root = (int) Math.sqrt(n);
        int square = root * root;

        System.out.println("N: " + n + "Math.sqrt(n): " + Math.sqrt(n) + ", root: " + root);

        if(n == root * root) {
            answer++;
            return;
        }
        else{
            answer++;
            solution(n- square);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution(n);
        System.out.print(answer);
    }
}
