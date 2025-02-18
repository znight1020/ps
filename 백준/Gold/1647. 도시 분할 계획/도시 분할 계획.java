import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static int[] parent;
	static List<Edge> edgeList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int[n+1];
		for(int i = 1; i <= n; i++) parent[i] = i;

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(from, to, cost));
		}

		Collections.sort(edgeList);
		long answer = 0;
		int max = 0;
		for(Edge e : edgeList) {
			if(union(e.from, e.to)) {
				answer += e.cost;
				max = Math.max(max, e.cost);
			}
		}
		System.out.print(answer-max);
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
		int from, to, cost;
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
}
