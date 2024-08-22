import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Integer> numList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      numList.add(0);
      for(int i = 1; i <= N; i++){
        numList.add(numList.get(i-1) + Integer.parseInt(st.nextToken()));
      }
      
      N = Integer.parseInt(br.readLine());
      for(int i = 0; i < N; i++){
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        sb.append(numList.get(end) - numList.get(start-1) + "\n");
      }
      
      
      System.out.print(sb);
  }
}