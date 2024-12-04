import java.util.*;
import java.io.*;

public class Main {

  static int[] arr = new int[20000001];
  static int N, M, STANDARD = 10000000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      int v = Integer.parseInt(st.nextToken());
      arr[STANDARD + v] = 1;
    }

    M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int v = Integer.parseInt(st.nextToken());
      if (arr[STANDARD + v] == 1) {
        sb.append(1).append(" ");
        continue;
      }
      sb.append(0).append(" ");
    }

    System.out.println(sb);
  }
}
