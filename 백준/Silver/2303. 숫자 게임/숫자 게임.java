import java.util.*;
import java.io.*;

public class Main {

  static int N, max = 0;
  static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      Person person = new Person();
      person.num = i+1;
      person.max = 0;

      while(st.hasMoreTokens()) person.cards.add(Integer.parseInt(st.nextToken()));
      comb(person, new int[3], 0, 0);
      if(person.max >= max) {
        max = person.max;
        answer = person.num;
      }
    }

    System.out.print(answer);
  }

  static void comb(Person person, int[] arr, int start, int depth) {
    if(depth == 3) {
      int sum = Arrays.stream(arr).sum();
      if(person.max < (sum % 10)) person.max = sum % 10;
      return;
    }

    for(int i = start; i < person.cards.size(); i++) {
      arr[depth] = person.cards.get(i);
      comb(person, arr, i+1, depth+1);
    }
  }

  static class Person {
    int num, max;
    List<Integer> cards = new ArrayList<>();
  }
}
