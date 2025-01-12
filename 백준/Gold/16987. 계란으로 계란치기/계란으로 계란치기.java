import java.util.*;
import java.io.*;

public class Main {

  static int N, answer = 0;
  static int[][] eggs;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    eggs = new int[N][2];
    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      eggs[i][0] = Integer.parseInt(st.nextToken());
      eggs[i][1] = Integer.parseInt(st.nextToken());
    }

    task(0, 0);
    System.out.print(answer);
  }

  static void task(int cnt, int idx) {
    if(idx == N) {
      answer = Math.max(answer, cnt);
      return;
    }

    if(eggs[idx][0] <= 0 || cnt == N-1) {
      task(cnt, idx+1);
      return;
    }

    int oldCnt = cnt;

    for(int i = 0; i < N; i++) {
      if(i == idx || eggs[i][0] <= 0) continue;
      hit(idx, i);
      if(eggs[idx][0] <= 0) cnt++;
      if(eggs[i][0] <= 0) cnt++;
      task(cnt, idx+1);
      rollback(idx, i);
      cnt = oldCnt;
    }
  }

  static void hit(int standard, int target) {
    eggs[standard][0] -= eggs[target][1];
    eggs[target][0] -= eggs[standard][1];
  }

  static void rollback(int standard, int target) {
    eggs[standard][0] += eggs[target][1];
    eggs[target][0] += eggs[standard][1];
  }
}
