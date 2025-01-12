import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken()) - 1;
    int[] arr = new int[N];
    boolean[] vtd = new boolean[N];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(arr);
    int answer = 0;

    for(int i = 0; i < N; i++) {
      if(!vtd[i]) answer++;
      else continue;

      vtd[i] = true;

      int start = arr[i];
      int end = start + L;

      int nextIdx = i+1;
      while(nextIdx < N && arr[nextIdx] <= end) {
        vtd[nextIdx] = true;
        nextIdx++;
      }
    }

    System.out.print(answer);
  }
}
