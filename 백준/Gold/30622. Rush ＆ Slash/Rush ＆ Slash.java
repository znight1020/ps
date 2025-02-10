import java.io.*;
import java.util.*;

public class Main {

  static long answer = 0;
  static int[] parent;
  static int[] dx = {0,0,-1,1,-1,1,-1,1};
  static int[] dy = {-1,1,0,0,-1,-1,1,1};
  static Map<Point, Integer> weeds = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    parent = new int[100001];

    for(int i = 0; i < N; i++) parent[i] = i;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      for(int j = 0; j < 8; j++) {
        int nx = x + dx[j];
        int ny = y + dy[j];
        Point current = new Point(nx, ny);
        if(weeds.containsKey(current)) union(weeds.get(current), i);
      }
      weeds.put(new Point(x, y), i);
    }

    Map<Integer, Integer> dis = new HashMap<>();
    for(Point p : weeds.keySet()) {
      int idx = find(weeds.get(p)), d = distance(p);
      dis.put(idx, Math.min(d, dis.getOrDefault(idx, d)));
    }

    long max = 0;
    for(long v : dis.values()) {
      answer += v * 2;
      max = Math.max(max, v);
    }
    answer -= max;

    System.out.print(answer);
  }

  static int distance(Point p) {
    return Math.abs(p.x) + Math.abs(p.y);
  }

  static void union(int x, int y) {
    int r1 = find(x);
    int r2 = find(y);
    if(r1 != r2) {
      if (r1 < r2) parent[r2] = r1;
      else parent[r1] = r2;
    }
  }

  static int find(int a) {
    if (parent[a] != a) parent[a] = find(parent[a]);
    return parent[a];
  }

  static class Point {
    int x, y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
      Point o = (Point) obj;
      return this.x == o.x && this.y == o.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}
