import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long answer = 0;

    long[] loss = new long[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) loss[i] = Long.parseLong(st.nextToken());

    Arrays.sort(loss);
    if(loss.length % 2 == 0) for(int i = 0; i < loss.length / 2; i++) answer = Math.max(answer, loss[i] + loss[loss.length-1-i]);
    else {
      for(int i = 0; i < loss.length / 2; i++) answer = Math.max(answer, loss[i] + loss[loss.length-2-i]);
      answer = Math.max(answer, loss[loss.length-1]);
    }
    System.out.print(answer);
  }
}
