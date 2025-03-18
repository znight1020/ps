import java.util.*;
import java.io.*;

public class Main {

  static List<List<Edge>> edgeList;
  static int max, cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for(int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      max = 0;
      cnt = 1;

      edgeList = new ArrayList<>();
      for(int i = 0; i <= n; i++) {
        edgeList.add(new ArrayList<>());
      }

      for(int i = 0; i < d; i++) {
        st = new StringTokenizer(br.readLine());
        int to = Integer.parseInt(st.nextToken());
        int from = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
        edgeList.get(from).add(new Edge(to, cost));
      }
      bfs(c, n);
      sb.append(cnt).append(" ").append(max).append("\n");
    }
    System.out.print(sb);
  }

  static void bfs(int start, int size) {
    boolean[] vtd = new boolean[size+1];
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.addAll(edgeList.get(start));
    vtd[start] = true;

    while(!pq.isEmpty()) {
      Edge e = pq.poll();
      if(vtd[e.to]) continue;
      cnt++;
      vtd[e.to] = true;
      max = Math.max(max, e.cost);

      for(Edge temp : edgeList.get(e.to)) {
        int cost = e.cost + temp.cost;
        pq.add(new Edge(temp.to, cost));
      }
    }
  }

  static class Edge implements Comparable<Edge> {
    int to, cost;
    Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
      return this.cost - o.cost;
    }
  }
}
