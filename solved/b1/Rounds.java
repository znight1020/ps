package solved.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rounds {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] N = br.readLine().toCharArray();

        for(int i = N.length-1; i >= 0; i--){
            if(i > 0 && Math.round((N[i]-'0') * 0.1) == 1) {
                N[i-1] = (char) (N[i-1] + 1);
                N[i] = '0';
            }
            else if(i > 0 && Math.round((N[i]-'0') * 0.1) == 0) N[i] = '0';
        }
        if(N[0] == ':') {
            N[0] = '0';
            System.out.print("1");
        }
        for(char x : N){
            System.out.print(x);
        }

    }
}
