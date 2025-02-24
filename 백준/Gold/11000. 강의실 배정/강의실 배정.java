import java.util.*;
import java.io.*;

public class Main {

  static int N;
  static PriorityQueue<Lecture> pq = new PriorityQueue<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    for(int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      pq.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    PriorityQueue<Integer> rooms = new PriorityQueue<>();
    rooms.add(0);
    while(!pq.isEmpty()) {
      Lecture l = pq.poll();
      if(rooms.peek() <= l.s) rooms.poll();
      rooms.add(l.t);
    }

    System.out.print(rooms.size());
  }

  static class Lecture implements Comparable<Lecture> {
    int s, t;
    Lecture(int s, int t) {
      this.s = s;
      this.t = t;
    }

    @Override
    public int compareTo(Lecture o) {
      if(this.s == o.s) return this.t - o.t;
      return this.s - o.s;
    }
  }
}
