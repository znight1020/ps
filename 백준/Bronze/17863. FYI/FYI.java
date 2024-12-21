import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    String str = "";
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] arr = br.readLine().toCharArray();
    for(int i = 0; i < 3; i++) str += arr[i];
    if (str.equals("555")) System.out.print("YES");
    else System.out.print("NO");
  }
}
