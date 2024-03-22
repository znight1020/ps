import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cash, sum = 0;
        while(true){
            cash = Integer.parseInt(br.readLine());
            if(cash == -1) break;
            sum += cash;
        }

        System.out.print(sum);
    }
}
