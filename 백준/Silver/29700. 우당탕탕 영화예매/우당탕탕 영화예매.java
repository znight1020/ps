import java.util.*;
import java.io.*;

public class Main {

  static int n, m, k, answer = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    for(int i = 0; i < n; i++) {
      String col = br.readLine();
      int cnt = 0;
      for(int j = 0; j < m; j++) {
        if(col.charAt(j) == '0') {
          cnt++;
          if(cnt == k) {
            answer++;
            cnt--;
          }
        } else cnt = 0;
      }
    }
    System.out.print(answer);
  }
}
