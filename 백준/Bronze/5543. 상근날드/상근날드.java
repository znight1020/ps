import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] burgers = new int[3];
    int[] beverage = new int[2];
    for(int i = 0; i < 3; i++) burgers[i] = Integer.parseInt(br.readLine());
    for(int i = 0; i < 2; i++) beverage[i] = Integer.parseInt(br.readLine());
    System.out.print(Arrays.stream(burgers).min().getAsInt() + Arrays.stream(beverage).min().getAsInt() - 50);
  }
}
