import java.io.*;
import java.util.*;

public class Main {

  static int N, M, K;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    findSequence();
    System.out.print(sb);
  }

  private static void findSequence() {
    int[] result = new int[N+1];
    int count = 0;

    HashSet<Integer> excludeNums = new HashSet<>();

    for (int num = 1; num <= M; num++) {
      if (excludeNums.contains(num)) continue;

      result[count++] = num;
      excludeNums.add(num ^ K);

      if (count == N) {
        for (int i = 0; i < N; i++) sb.append(result[i]).append(" ");
        return;
      }
    }

    sb.append(-1);
  }
}
