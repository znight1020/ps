import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int answer = 0, N = Integer.parseInt(br.readLine());

    for(int i = 0; i < N; i++) {
      char[] arr = br.readLine().toCharArray();
      Stack<Character> s = new Stack<>();

      for(int idx = 0; idx < arr.length; idx++) {
        if(s.isEmpty()) {
          s.push(arr[idx]);
          continue;
        }
        if(s.peek() == arr[idx]) s.pop();
        else s.push(arr[idx]);
      }
      if(s.isEmpty()) answer++;
    }
    System.out.print(answer);
  }
}
