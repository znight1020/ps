import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static long answer = 0;
  static int[] students;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    students = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    int iter = 0;
    while(st.hasMoreTokens()) {
      students[iter] = Integer.parseInt(st.nextToken());
      iter++;
    }
    Arrays.sort(students);

    for(int i = 0; i < N-2; i++) {
      int standard = students[i];
      if(standard > 0) break;

      int start = i+1;
      int end = N-1;

      while(start < end) {
        int p1 = students[start];
        int p2 = students[end];
        int sum = standard + p1 + p2;

        if(sum == 0) {
          if(p1 == p2) {
            answer += nC2(end - start + 1);
            break;
          }

          int startCnt = 1;
          while(p1 == students[start+1]) {
            startCnt++;
            start++;
          }

          int endCnt = 1;
          while(p2 == students[end-1]) {
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
