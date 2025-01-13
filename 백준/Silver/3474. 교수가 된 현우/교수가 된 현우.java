import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    for(int i = 0; i < N; i++) {
      int n = Integer.parseInt(br.readLine()), answer = 0;
      for(int j = 5; j <= n; j*=5) answer += n / j;
      sb.append(answer).append("\n");
    }
    System.out.print(sb);
  }
}
