import java.util.*;
import java.io.*;

public class Main {

	static int[] plan;
	static int[] parent;
	static List<List<Integer>> map = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		plan = new int[M];
		for(int i = 1; i <= N; i++) parent[i] = i;
		for(int i = 0; i <= N; i++) map.add(new ArrayList<>());

		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				if(Integer.parseInt(st.nextToken()) == 0) continue;
				union(i, j);
			}
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) plan[i] = Integer.parseInt(st.nextToken());

		int fv = plan[0], root = find(fv);
		boolean flag = true;
		for(int i = 1; i < plan.length; i++) if(root != find(plan[i])) flag = false;
		if(flag) System.out.print("YES");
		else System.out.print("NO");
	}

	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			if(x < y) parent[y] = x;
			else parent[x] = y;
		}
	}
}