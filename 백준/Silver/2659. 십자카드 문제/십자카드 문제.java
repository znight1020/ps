import java.util.*;
import java.io.*;

public class Main {
    static int answer = 1;
    static List<Integer> clockNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String clockNumber = "";
        while(st.hasMoreTokens()) clockNumber += Integer.parseInt(st.nextToken());
        int min = findClockNumber(clockNumber);

        for(int i = 1111; i < min; i++)
            if(!String.valueOf(i).contains("0") && i == findClockNumber(String.valueOf(i)))
                answer++;

        System.out.println(answer);
    }

    static int findClockNumber(String numbers) {
        clockNumbers = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            int temp = 0;
            for (int j = 0; j < 4; j++) {
                int idx = (i + j) % 4;
                temp = temp * 10 + Character.getNumericValue(numbers.charAt(idx));
            }
            clockNumbers.add(temp);
        }

        return clockNumbers.stream().min(Comparator.naturalOrder()).orElseThrow();
    }
}
