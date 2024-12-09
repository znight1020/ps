import java.util.*;
import java.io.*;

public class Main {

  static int answer = 0;
  static List<Country> countries = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int target = Integer.parseInt(st.nextToken());
    Country targetCountry = null;

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      int gold = Integer.parseInt(st.nextToken());
      int silver = Integer.parseInt(st.nextToken());
      int bronze = Integer.parseInt(st.nextToken());
      Country country = new Country(num, gold, silver, bronze);
      countries.add(country);
      if(num == target) {
        targetCountry = country;
      }
    }

    Collections.sort(countries);
    int rank = 1;
    for(int i = 0; i < countries.size(); i++) {
      if(i > 0 && countries.get(i).compareTo(countries.get(i-1)) > 0) {
        rank++;
      }

      if(countries.get(i).num == targetCountry.num) {
        answer = rank;
        break;
      }
    }

    System.out.println(answer);
  }

  static class Country implements Comparable<Country> {
    int num, gold, silver, bronze;

    Country(int num, int gold, int silver, int bronze) {
      this.num = num;
      this.gold = gold;
      this.silver = silver;
      this.bronze = bronze;
    }

    @Override
    public int compareTo(Country o) {
      if (this.gold != o.gold) {
        return o.gold - this.gold;
      }
      if (this.silver != o.silver) {
        return o.silver - this.silver;
      }
      return o.bronze - this.bronze;
    }
  }
}
