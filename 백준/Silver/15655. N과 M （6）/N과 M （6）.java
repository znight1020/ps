import java.io.*;
import java.util.*;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static int[] src;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    src = new int[N];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) src[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(src);
    perm(0, 0, new int[M], new boolean[N]);

    System.out.print(sb);
  }

  static void perm(int depth, int start, int[] arr, boolean[] vtd) {
    if(depth == M) {
      for(int n : arr) sb.append(n).append(" ");
      sb.append("\n");
      return;
    }

    for(int i = start; i < N; i++) {
      if(vtd[i]) continue;
      vtd[i] = true;
      arr[depth] = src[i];
      perm(depth+1, i+1, arr, vtd);
      vtd[i] = false;
    }
  }
}
