import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    for(int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());
      sb.append("Case #").append(i).append(": ").append(n1+n2).append("\n");
    }

    System.out.print(sb);
  }
}
