import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

  static Integer[] cranes, boxes, cranesIdx;
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    cranes = new Integer[N];
    cranesIdx = new Integer[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      cranes[i] = Integer.parseInt(st.nextToken());
      cranesIdx[i] = 0;
    }

    int M = Integer.parseInt(br.readLine());
    boxes = new Integer[M];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < M; i++) boxes[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(boxes, Collections.reverseOrder());
    Arrays.sort(cranes, Collections.reverseOrder());

    if (boxes[0] > cranes[0]) System.out.print(-1);
    else {
      boolean[] vtd = new boolean[M];
      while(M > 0) {
        for(int i = 0; i < N; i++) {
          for(int j = cranesIdx[i]; j < boxes.length; j++) {
            if(vtd[j]) continue;
            if(cranes[i] < boxes[j]) cranesIdx[i]++;
            else {
              vtd[j] = true;
              M--; break;
            }
          }

          if(M == 0) break;
        }
        answer++;
      }
      System.out.print(answer);
    }
  }
}
