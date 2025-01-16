import java.util.*;
import java.io.*;

public class Main {
	static Map<String, Integer> m = new HashMap<>();
	static List<Senior> seniors = new ArrayList<>();

	static boolean[][] vtd = new boolean[11][7];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int week = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());
			seniors.add(new Senior(name, week, day, money));
		}

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int cash = Integer.parseInt(st.nextToken());
			m.put(name, cash);
		}

		for(int i = 0; i < N; i++) {
			Senior s = seniors.get(i);
			if(m.get(s.name) >= s.payment) vtd[s.week][s.day] = true;
		}

		int answer = 0, count = 0;

		for(int i = 1; i < 11; i++) {
			for(int j = 0; j < 7; j++) {
				if(vtd[i][j]) {
					count++;
					answer = Math.max(answer, count);
				}
				else count = 0;
			}
		}

		System.out.print(answer);
	}

	static class Senior {
		String name;
		int week, day, payment;
		Senior(String name, int week, int day, int payment) {
			this.name = name;
			this.week = week;
			this.day = day;
			this.payment = payment;
		}
	}
}
