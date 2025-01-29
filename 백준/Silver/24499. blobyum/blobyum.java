import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

		System.out.print(solve());
	}

	static int solve() {
		int max = 0;
		for(int i = 0; i < K; i++) max += arr[i];

		int sum = max;
		for(int i = 1; i < N; i++) {
			int start = i-1, end = i+K-1;
			if(end >= N) end -= N;
			sum = sum - arr[start] + arr[end];
			max = Math.max(max, sum);
		}

		return max;
	}
}
