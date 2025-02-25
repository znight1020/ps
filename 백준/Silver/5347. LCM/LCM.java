import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for(int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long a = Integer.parseInt(st.nextToken());
      long b = Integer.parseInt(st.nextToken());
      long lcm = gcd(a, b);
      sb.append(a*b / lcm).append("\n");
    }
    System.out.print(sb);
  }

  static long gcd(long a, long b) {
    if(b == 0) return a;
    return gcd(b, a % b);
  }
}
