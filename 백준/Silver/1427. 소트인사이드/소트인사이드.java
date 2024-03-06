import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] charArr = br.readLine().toCharArray();
        Integer[] charToInt = new Integer[charArr.length];
        for(int i = 0; i < charToInt.length; i++) charToInt[i] = charArr[i] - '0';
        Arrays.sort(charToInt, (x1, x2) -> x2- x1);
        for(int x : charToInt) sb.append(x);

        System.out.print(sb);
    }
}
