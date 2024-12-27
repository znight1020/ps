import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    int[] arr = new int[31];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(int i = 0; i < 28; i++) arr[Integer.parseInt(br.readLine())] = 1;
    for(int i = 1; i <= 30; i++) if (arr[i] == 0) System.out.println(i);
  }
}
