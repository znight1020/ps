import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<String> alphaList = List.of("000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;
        int N = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            if(flag) break;

            String input = "";
            for (int j = 0; j < 6; j++) input += arr[6*i+j];

            int preSize = sb.length();
            for (int j = 0; j < alphaList.size(); j++) {
                String alpha = alphaList.get(j);
                int temp = 0;
                for (int idx = 0; idx < 6; idx++) {
                    if(input.charAt(idx) == alpha.charAt(idx)) temp++;
                }
                if(temp == 6) sb.append((char)(65+j));
                else if(temp == 5) sb.append((char)(65+j));
            }
            int currentSize = sb.length();

            if(preSize == currentSize) {
                sb = new StringBuilder();
                sb.append(i+1);
                flag = true;
            }
        }
        System.out.print(sb);
    }
}
