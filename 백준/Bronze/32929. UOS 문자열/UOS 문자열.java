import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    
    if (N % 3 == 1) {
      System.out.println("U");
    }
    else if (N % 3 == 2) {
      System.out.println("O");
    }
    else if (N % 3 == 0) {
      System.out.println("S");
    }
  }
}
