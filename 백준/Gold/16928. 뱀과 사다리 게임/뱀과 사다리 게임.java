import java.io.*;
import java.util.*;

public class Main {

  static Map<Integer, Integer> snakes = new HashMap<>();
  static Map<Integer, Integer> ladders = new HashMap<>();
  static int[] board = new int[101];
  static int N, M, answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    int from, to;
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      from = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());
      ladders.put(from, to);
      board[from] = 2;
    }
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      from = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());
      snakes.put(from, to);
      board[from] = 3;
    }

    game();
    System.out.print(answer);
  }

  static void game() {
    PriorityQueue<Player> pq = new PriorityQueue<>();
    pq.add(new Player(1, 0));

    while(!pq.isEmpty()) {
      Player p = pq.poll();
      if(p.point >= 100) {
        answer = p.turn;
        return;
      }
      if(board[p.point] == 1) continue;
      board[p.point] = 1;

      for(int i = 1; i <= 6; i++) {
        int current = p.point + i;
        if(current < 100) {
          if(board[current] == 2) current = ladders.get(current);
          if(board[current] == 3) current = snakes.get(current);
        }
        pq.add(new Player(current, p.turn + 1));
      }
    }
  }

  static class Player implements Comparable<Player> {
    int point, turn;
    Player(int point, int turn) {
      this.point = point;
      this.turn = turn;
    }

    @Override
    public int compareTo(Player p) {
      return this.turn - p.turn;
    }
  }
}
