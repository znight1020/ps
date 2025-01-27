import java.util.*;
import java.io.*;

public class Main {

	static int[] check;
	static List<List<Integer>> edges = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken()) - 1;

		check = new int[N];
		for(int i = 0; i < N; i++) check[i] = -1;
		for(int i = 0; i < N; i++) edges.add(new ArrayList<>());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edges.get(u-1).add(v-1);
			edges.get(v-1).add(u-1);
		}

		bfs(start);
		StringBuilder sb = new StringBuilder();
		for(int n : check) sb.append(n).append("\n");
		System.out.print(sb);
	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;
		q.add(start);
		check[start] = cnt;
		while(!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for(int iter = 0; iter < size; iter++) {
				int v = q.poll();
				List<Integer> temp = edges.get(v);
				for(int n : temp) {
					if(check[n] != -1) continue;
					q.add(n);
					check[n] = cnt;
				}
			}
		}
	}
}
