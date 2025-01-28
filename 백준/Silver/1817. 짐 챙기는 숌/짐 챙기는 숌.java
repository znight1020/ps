import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), box = 1, sum = 0;

    if(N == 0) box = 0;
    else {
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++) {
        int weight = Integer.parseInt(st.nextToken());
        if(sum + weight > M) {
          box++;
          sum = 0;
        }
        sum += weight;
      }
    }
    System.out.print(box);
  }
}
