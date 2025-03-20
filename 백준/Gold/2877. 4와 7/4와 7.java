import java.util.*;
import java.io.*;
class Main {

  static int a = 4, b = 7, cnt = 1;
  static long N;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Long.parseLong(br.readLine());
    while(true) {
      double sub = Math.pow(2, cnt);
      if(N - sub <= 0) {
        break;
      }
      N -= sub;
      cnt++;
    }

    while(cnt > 1) {
      double mid = Math.pow(2, cnt) / 2;
      if(N > mid) {
        N -= mid;
        sb.append(b);
      }
      else {
        sb.append(a);
      }
      cnt--;
    }

    if(N == 1) sb.append(a);
    else sb.append(b);
    System.out.print(sb);
  }
}
