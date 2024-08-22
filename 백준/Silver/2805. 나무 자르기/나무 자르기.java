import java.util.*;
import java.io.*;

public class Main {
    static long N, M, max = 0, answer = 0;
    static List<Long> trees = new ArrayList<>();
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Long.parseLong(st.nextToken());
      M = Long.parseLong(st.nextToken());
      
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++) {
        long tree = Long.parseLong(st.nextToken());
        trees.add(tree);
        if(tree > max) max = tree;
      }
      find();
      System.out.print(answer);
    }
    
    static void find() {
      long start = 0, mid = 0, sum;
      long end = max;
      while(start < end){
        mid = (start+end) / 2;
        sum = calc(mid);
        
        if(sum < M) end = mid;
        else if (sum == M) {
          answer = mid;
          break;
        }
        else {
          answer = mid;
          start = mid+1;
        }
      }
    }
    
    static long calc(long standard) {
      long sum = 0, cutLength;
      for(int i = 0; i < N; i++) {
        cutLength = trees.get(i) - standard;
        if(cutLength < 0) cutLength = 0;
        sum += cutLength;
      }
      
      return sum;
    }
}