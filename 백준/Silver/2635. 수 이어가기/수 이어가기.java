import java.util.*;
import java.io.*;

public class Main {
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int decreaseNumber = N;
        while(decreaseNumber > N / 2) {
            List<Integer> numberList = new ArrayList<>(List.of(N));
            numberList.add(decreaseNumber);
            int idx = numberList.size() - 1;
            int nextNumber = 0;
            while(nextNumber >= 0){
                nextNumber = numberList.get(idx - 1) - numberList.get(idx);
                if (nextNumber >= 0) {
                    numberList.add(nextNumber);
                }
                idx++;
            }

            if(answer < numberList.size()) {
                answer = numberList.size();
                sb = new StringBuilder();
                for(int num : numberList) sb.append(num).append(" ");
            }
            decreaseNumber--;
        }

        System.out.println(answer);
        System.out.println(sb);
    }
}
