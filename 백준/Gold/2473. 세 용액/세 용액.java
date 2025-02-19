import java.util.*;
import java.io.*;

public class Main {

  static long diff = Long.MAX_VALUE;
  static int n;
  static int[] answer = new int[3];
  static List<Integer> arr = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) arr.add(Integer.parseInt(st.nextToken()));
    Collections.sort(arr);

    for(int i = 0; i < n-2; i++) {
      if(diff == 0) break;

      int n1 = arr.get(i);
      for(int j = i+1; j < n-1; j++) {
        int n2 = arr.get(j);
        int start = j+1, end = n-1;

        while(start <= end) {
          int mid = (start+end) / 2, n3 = arr.get(mid);
          long cal = (long) n1 + n2 + n3;
          if(Math.abs(cal) < diff) {
            answer[0] = n1;
            answer[1] = n2;
            answer[2] = n3;
            diff = Math.abs(cal);
          }
          if(cal < 0) start = mid+1;
          else if(cal == 0) break;
          else end = mid-1;
        }
      }
    }
    System.out.print(answer[0] + " " + answer[1] + " " + answer[2]);
  }
}
