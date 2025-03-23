import java.io.*;
import java.util.*;

public class Main {

  static int[] src;
  static int K;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    while (true) {
      st = new StringTokenizer(br.readLine());
      K = Integer.parseInt(st.nextToken());
      if(K == 0) break;
      src = new int[K];

      for(int i = 0; i < K; i++) src[i] = Integer.parseInt(st.nextToken());
      comb(new int[6], 0, 0);
      sb.append("\n");
    }

    System.out.print(sb);
  }

  static void comb(int[] arr, int depth, int start) {
    if(start > K) return;

    if(depth == 6) {
      for(int n : arr) sb.append(n).append(" ");
      sb.append("\n");
      return;
    }

    for(int i = start; i < K; i++) {
      arr[depth] = src[i];
      comb(arr, depth+1, i+1);
    }
  }
}
