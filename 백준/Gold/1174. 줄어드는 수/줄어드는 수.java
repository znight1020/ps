import java.util.*;
import java.io.*;

public class Main {
	static Set<Long> arr = new TreeSet<>();
	static int[] src = {9,8,7,6,5,4,3,2,1,0};

	public static void main(String[] args) throws IOException {
		dfs(0, 0);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Long> ans = new ArrayList<>(arr);
		if(N <= ans.size()) System.out.print(ans.get(N-1));
		else System.out.print(-1);
	}

	static void dfs(long n, int idx) {
		arr.add(n);
		if(idx == 10) return;
		dfs(n, idx+1);
		n = n * 10 + src[idx];
		dfs(n, idx+1);
	}
}
