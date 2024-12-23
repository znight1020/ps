import java.io.*;
import java.util.*;

public class Main {

  static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int max;

    int n1 = Integer.parseInt(st.nextToken());
    int n2 = Integer.parseInt(st.nextToken());
    int n3 = Integer.parseInt(st.nextToken());

    if(n1 == n2 && n2 == n3) answer = 10000 + n1 * 1000;
    else if(n1 == n2 || n2 == n3 || n1 == n3) {
      if(n2 == n3) answer = 1000 + n2 * 100;
      else answer = 1000 + n1 * 100;
    }
    else if(n1 != n2 && n2 != n3 && n3 != n1) {
      max = Math.max(n1, n2);
      max = Math.max(max, n3);
      answer = 100 * max;
    }

    System.out.print(answer);
  }
}
