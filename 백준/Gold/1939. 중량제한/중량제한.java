import java.util.*;
import java.io.*;

public class Main {

	static int[] parent;
	static int N, M, start, end;
	static PriorityQueue<Edge> edgeList = new PriorityQueue<>();
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) parent[i] = i;

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long cost = Long.parseLong(st.nextToken());
			edgeList.add(new Edge(from, to, cost));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		while(!checkConnection()) {
			Edge e = edgeList.poll();
			if(union(e.from, e.to)) min = Math.min(min, e.cost);
		}
		System.out.print(min);
	}

	static boolean checkConnection() {
		return find(start) == find(end);
	}

	static int find(int x) {
		if(parent[x] != x) return parent[x] = find(parent[x]);
		return parent[x];
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if(x != y) {
			if(y > x) parent[y] = x;
			else parent[x] = y;
			return true;
		}
		return false;
	}

	static class Edge implements Comparable<Edge> {
		int from, to;
		long cost;

		Edge(int from, int to, long cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o1) {
			if(this.cost - o1.cost > 0) return -1;
			else if(this.cost - o1.cost == 0) return 0;
			else return 1;
		}
	}
}
