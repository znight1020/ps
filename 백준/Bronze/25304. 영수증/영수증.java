import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int iter = Integer.parseInt(br.readLine());
    int sum = 0;
    for(int i = 0; i < iter; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());
      sum += n1 * n2;
    }

    if (N == sum) System.out.print("Yes");
    else System.out.print("No");
  }
}
