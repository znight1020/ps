import java.util.*;
import java.io.*;

public class Main {

	static PriorityQueue<Problem> pq = new PriorityQueue<>();
	static int amountPoint = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 1; i <= 8; i++) {
			int point = Integer.parseInt(br.readLine());
			Problem p = new Problem(i, point);
			pq.add(p);
		}

		List<Integer> numList = new ArrayList<>();

		for(int i = 0; i < 5; i++) {
			Problem p = pq.poll();
			amountPoint += p.point;
			numList.add(p.num);
		}

		Collections.sort(numList);

		System.out.println(amountPoint);
		for(int num : numList) {
			System.out.print(num + " ");
		}
	}

	static class Problem implements Comparable<Problem> {
		int num, point;

		Problem(int num, int point) {
			this.num = num;
			this.point = point;
		}

		@Override
		public int compareTo(Problem o) {
			return o.point - this.point;
		}
	}
}
