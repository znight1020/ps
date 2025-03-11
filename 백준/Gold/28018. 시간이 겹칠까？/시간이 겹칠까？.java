import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int[] attend = new int[1000002];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      attend[Integer.parseInt(st.nextToken())]++;
      attend[Integer.parseInt(st.nextToken())+1]--;
    }
    for(int i = 1; i <= 1000000; i++) attend[i] += attend[i-1];

    int Q = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < Q; i++) sb.append(attend[Integer.parseInt(st.nextToken())]).append("\n");
    System.out.print(sb);
  }
}
