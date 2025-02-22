import java.util.*;
import java.io.*;

public class Main {

	static int n, k, answer = 0;
	static PriorityQueue<Meeting> meetings = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings.add(new Meeting(start, end));
		}

		List<Integer> rooms = new ArrayList<>();
		while (!meetings.isEmpty()) {
			Meeting m = meetings.poll();
			int start = m.start;
			int end = m.end;

			rooms.sort(Collections.reverseOrder());
			boolean flag = false;
			int size = rooms.size();

			for (int i = 0; i < size; i++) {
				if (rooms.get(i) < start) {
					rooms.set(i, end);
					answer++;
					flag = true;
					break;
				}
			}

			if (!flag && size < k) {
				rooms.add(end);
				answer++;
			}
		}

		System.out.print(answer);
	}

	static class Meeting implements Comparable<Meeting>{
		int start, end;
		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Meeting o) {
			return this.end - o.end;
		}
	}
}
