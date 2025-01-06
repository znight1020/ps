import java.util.*;
import java.io.*;

public class Main {
    static List<Double> numList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double sum = 0.0;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            double num = Double.parseDouble(br.readLine());
            numList.add(num);
            sum += num;
        }
        Collections.sort(numList);

        for(int i = 0; i < K; i++) sum -= numList.get(i) + numList.get(numList.size()-1-i);
        double truncation = (sum + 0.0000001) / (N - K * 2);

        for(int i = 0; i < K; i++) sum += numList.get(K) + numList.get(N-K-1);
        double correction = (sum + 0.0000001) / N;

        System.out.printf("%.2f\n", truncation);
        System.out.printf("%.2f", correction);
    }
}