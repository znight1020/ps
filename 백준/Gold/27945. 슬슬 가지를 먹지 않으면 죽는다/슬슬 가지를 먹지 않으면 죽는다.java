import java.util.*;
import java.io.*;

public class Main {

	static int[] parent;
	static int n, m, answer = 0;
	static List<Edge> edgeList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		makeSet();

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(from, to, day));
		}
		Collections.sort(edgeList);

		for(Edge e : edgeList) {
			int today = e.day;

			if(today < answer+1) continue;
			else if(today > answer+1) break;

			if(union(e.from, e.to)) answer++;
		}

		System.out.print(answer+1);
	}

	static void makeSet() {
		for(int i = 1; i <= n; i++) parent[i] = i;
	}
	static int find(int x) {
		if(parent[x] != x) return parent[x] = find(parent[x]);
		return parent[x];
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			if(x < y) parent[y] = x;
			else parent[x] = y;
			return true;
		}
		return false;
	}

	static class Edge implements Comparable<Edge> {
		int from, to, day;
		Edge(int from, int to, int day) {
			this.from = from;
			this.to = to;
			this.day = day;
		}

		@Override
		public int compareTo(Edge o) {
			return this.day - o.day;
		}
	}
}
