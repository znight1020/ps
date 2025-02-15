import java.util.*;
import java.io.*;

public class Main {

  static int n, m;
  static int[] parent;
  static boolean[] isCycle;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int t = 1;

    while(true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      if(n == 0 & m == 0) break;
      parent = new int[n+1];
      isCycle = new boolean[n+1];
      for(int i = 1; i <= n; i++) parent[i] = i;

      for(int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        union(from, to);
      }

      Set<Integer> s = new HashSet<>();
      for(int i = 1; i <= n; i++) {
        int root = find(i);
        if(!isCycle[root]) s.add(root);
      }

      sb.append("Case ").append(t).append(": ");
      int cnt = s.size();
      if(cnt == 0) sb.append("No trees.");
      else if(cnt == 1) sb.append("There is one tree.");
      else sb.append("A forest of ").append(cnt).append(" trees.");
      sb.append("\n");
      t++;
    }

    System.out.print(sb);
  }

  static void union(int x, int y) {
    x = find(x);
    y = find(y);
    if(x == y) {
      isCycle[x] = true;
      return;
    }

    if (x < y) {
      parent[y] = x;
      if (isCycle[y]) isCycle[x] = true;
    } else {
      parent[x] = y;
      if (isCycle[x]) isCycle[y] = true;
    }
  }

  static int find(int x) {
    if(parent[x] != x) parent[x] = find(parent[x]);
    return parent[x];
  }
}
