import java.util.*;
import java.io.*;

public class Main {
    static List<Double> numList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) numList.add(Double.parseDouble(br.readLine()));
        Collections.sort(numList);

        for(int i = 0; i < K; i++) {
            numList.remove(0);
            numList.remove(numList.size()-1);
        }

        double truncation = Math.round(numList.stream().mapToDouble(Double::doubleValue).average().getAsDouble() * 100) / 100.0;

        double first = numList.get(0);
        double last = numList.get(numList.size()-1);
        for(int i = 0; i < K; i++) {
            numList.add(first);
            numList.add(last);
        }

        double correction = Math.round(numList.stream().mapToDouble(Double::doubleValue).average().getAsDouble() * 100) / 100.0;

        System.out.printf("%.2f\n", truncation);
        System.out.printf("%.2f", correction);
    }
}