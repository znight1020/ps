import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static long answer = 0;
  static List<Integer> students = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    while(st.hasMoreTokens()) students.add(Integer.parseInt(st.nextToken()));
    Collections.sort(students);

    for(int i = 0; i < N-2; i++) {
      int standard = students.get(i);
      if(standard > 0) break;

      int start = i+1;
      int end = N-1;

      while(start < end) {
        int p1 = students.get(start);
        int p2 = students.get(end);
        int sum = standard + p1 + p2;

        if(sum == 0) {
          if(p1 == p2) {
            answer += nC2(end - start + 1);
            break;
          }

          int startCnt = 1;
          while(p1 == students.get(start+1)) {
            startCnt++;
            start++;
          }

          int endCnt = 1;
          while(p2 == students.get(end-1)) {
            endCnt++;
            end--;
          }
          answer += (startCnt * endCnt);
        }

        if(sum > 0) end--;
        else start++;
      }
    }
    System.out.print(answer);
  }

  static int nC2(int n) {
    return n * (n-1) / 2;
  }
}
