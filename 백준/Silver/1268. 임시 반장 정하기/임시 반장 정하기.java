import java.util.*;
import java.io.*;

public class Main {

  static int N, answer = 1, max = 0;
  static int[][] classrooms;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    classrooms = new int[N][5];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) classrooms[i][j] = Integer.parseInt(st.nextToken());
    }

    int[] classmateCount = new int[N];

    for (int i = 0; i < N; i++) {
      boolean[] visited = new boolean[N];

      for (int j = 0; j < 5; j++) {
        int standard = classrooms[i][j];
        for (int k = 0; k < N; k++) if (i != k && classrooms[k][j] == standard) visited[k] = true;
      }

      for (boolean isClassmate : visited) if (isClassmate) classmateCount[i]++;
    }

    for (int i = 0; i < N; i++) {
      if (classmateCount[i] > max) {
        max = classmateCount[i];
        answer = i + 1;
      }
    }

    System.out.println(answer);
  }
}