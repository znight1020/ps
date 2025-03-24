import java.io.*;
import java.util.*;

public class Main {

  static int N, M, T;
  static int[][] map;
  static int[] dy = {-1,1,0,0};
  static int[] dx = {0,0,-1,1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        int v = Integer.parseInt(st.nextToken());
        map[i][j] = v;
      }
    }

    int n1 = toGram();
    int n2 = toPrincess();

    int answer = Math.min(n1, n2);
    if (answer <= T) System.out.print(answer);
    else System.out.print("Fail");
  }

  static int toGram() {
    boolean[][] vtd = new boolean[N][M];
    PriorityQueue<Point> pq = new PriorityQueue<>();
    Point start = new Point(0,0, 0);
    pq.add(start);

    while(!pq.isEmpty()) {
      Point p = pq.poll();
      if(p.t > T) return Integer.MAX_VALUE;
      if(map[p.y][p.x] == 2) return p.t + getDistance(p);

      if(vtd[p.y][p.x]) continue;
      vtd[p.y][p.x] = true;

      addPoint(pq, p);
    }
    return Integer.MAX_VALUE;
  }

  static int toPrincess() {

    boolean[][] vtd = new boolean[N][M];
    PriorityQueue<Point> pq = new PriorityQueue<>();
    Point start = new Point(0,0, 0);
    pq.add(start);

    while(!pq.isEmpty()) {
      Point p = pq.poll();
      if(p.t > T) return Integer.MAX_VALUE;

      if(vtd[p.y][p.x]) continue;
      vtd[p.y][p.x] = true;

      boolean flag = addPoint(pq, p);
      if(flag) return p.t+1;
    }

    return Integer.MAX_VALUE;
  }

  static boolean addPoint(PriorityQueue<Point> pq, Point p) {
    for(int i = 0; i < 4; i++) {
      int ny = p.y + dy[i];
      int nx = p.x + dx[i];

      if(ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] == 1) continue;
      pq.add(new Point(ny, nx, p.t+1));
      if(ny == N-1 && nx == M-1) return true;
    }
    return false;
  }

  static int getDistance(Point p) {
    return N - p.y + M - p.x - 2;
  }

  static class Point implements Comparable<Point> {
    int y, x, t;

    Point(int y, int x, int t) {
      this.y = y;
      this.x = x;
      this.t = t;
    }

    public int compareTo(Point o) {
      return this.t - o.t;
    }
  }
}
