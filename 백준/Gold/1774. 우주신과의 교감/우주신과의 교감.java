import java.util.*;
import java.io.*;

public class Main {

	static int[] parent;
	static Vertex[] vertexes;
	static List<Edge> edgeList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		vertexes = new Vertex[N+1];
		for(int i = 1; i <= N; i++) parent[i] = i;

		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			vertexes[i] = new Vertex(x, y);
		}

		for(int i = 1; i <= N; i++) {
			for(int j = i+1; j <= N; j++) {
				if(i == j) continue;
				double dis = getDistance(vertexes[i], vertexes[j]);
				edgeList.add(new Edge(i, j, dis));
			}
		}
		Collections.sort(edgeList);

		boolean[][] vtd = new boolean[N+1][N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			union(v1, v2);
			vtd[v1][v2] = true;
			vtd[v2][v1] = true;
		}

		double answer = 0;
		for(Edge e : edgeList) {
			int from = e.from, to = e.to;
			if(!vtd[from][to]) {
				if(find(from) != find(to)) {
					answer += e.cost;
					vtd[from][to] = true;
					vtd[to][from] = true;
					union(from, to);
				}
			}
		}
		System.out.printf("%.2f", answer);
	}

	static double getDistance(Vertex v1, Vertex v2) {
		return Math.sqrt(Math.pow(v1.x - v2.x, 2) + Math.pow(v1.y - v2.y, 2));
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if(x != y) parent[y] = x;
	}

	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	static class Vertex {
		int x, y;
		Vertex(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	static class Edge implements Comparable<Edge>{
		int from, to;
		double cost;
		Edge(int from, int to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o){
			if(this.cost < o.cost) return -1;
			return 1;
		}
	}
}
