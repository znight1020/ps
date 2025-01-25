import java.util.*;
import java.io.*;

public class Main {

  static int[] arr;
  static boolean[] vtd;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    arr = new int[N];
    vtd = new boolean[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

    int iter = 0, idx = 0;
    boolean flag;

    while(iter < N) {
      vtd[idx] = true;
      sb.append(idx+1).append(" ");
      if(iter == N-1) break;

      int newIdx = idx;
      int cnt = arr[idx];
      if(cnt < 0) {
        while(cnt < 0){
          newIdx--;
          if(newIdx < 0) while(newIdx < 0) newIdx += N;
          if(vtd[newIdx]) continue;
          cnt++;
        }
      }
      else {
        while(cnt > 0) {
          newIdx++;
          if(newIdx >= N) while(newIdx >= N) newIdx -= N;
          if(vtd[newIdx]) continue;
          cnt--;
        }
      }

      flag = newIdx > idx;

      if(flag && vtd[newIdx]) {
        while(vtd[newIdx]) {
          newIdx++;
          if(newIdx >= N) newIdx -= N;
        }
      }
      else if(!flag && vtd[newIdx]) {
        while(vtd[newIdx]) {
          newIdx--;
          if(newIdx < 0) newIdx += N;
        }
      }

      if(newIdx < 0) while(newIdx < 0) newIdx += N;
      else if(newIdx >= N) while(newIdx >= N) newIdx -= N;

      idx = newIdx;
      iter++;
    }

    System.out.print(sb);
  }

}
