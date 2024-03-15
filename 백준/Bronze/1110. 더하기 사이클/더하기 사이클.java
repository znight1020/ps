import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0, start = 0;

        if(N == 0) System.out.print(1);
        else{
            while(start != N){
                if(cnt == 0) start = N;
                int p1 = start % 10;
                int sum = p1 + start / 10;
                if(sum >= 10) sum %= 10;
                start = p1 * 10 + sum;
                cnt++;
            }
            System.out.print(cnt);
        }
    }
}
