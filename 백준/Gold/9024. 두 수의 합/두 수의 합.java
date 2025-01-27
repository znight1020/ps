import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		for(int iter = 0; iter < S; iter++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
			findAnswer();
		}
		System.out.print(sb);
	}

	static void findAnswer() {
		Arrays.sort(arr);
		int cnt = 0, min = Integer.MAX_VALUE, startIdx = 0, endIdx = N-1;
		while(startIdx < endIdx) {
			int sum = arr[startIdx] + arr[endIdx], current = Math.abs(K - sum);
			if(min > current) {
				min = current;
				cnt = 1;
			} else if(min == current) cnt++;
			if(K < sum) endIdx--;
			else startIdx++;
		}
		sb.append(cnt).append("\n");
	}
}
