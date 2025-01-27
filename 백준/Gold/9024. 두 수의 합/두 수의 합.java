import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int S = Integer.parseInt(br.readLine());

		for(int iter = 0; iter < S; iter++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
			sb.append(findAnswer(arr, K)).append("\n");
		}
		System.out.print(sb);
	}

	static int findAnswer(int[] arr, int target) {
		Arrays.sort(arr);
		int cnt = 0, min = Integer.MAX_VALUE, startIdx = 0, endIdx = arr.length-1;
		while(startIdx < endIdx) {
			int sum = arr[startIdx] + arr[endIdx], current = Math.abs(target - sum);
			if(min > current) {
				min = current;
				cnt = 1;
			} else if(min == current) cnt++;
			if(target < sum) endIdx--;
			else startIdx++;
		}
		return cnt;
	}
}
