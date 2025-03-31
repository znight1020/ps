import java.io.*;
import java.util.*;

public class Main {

	static int N, S, min = Integer.MAX_VALUE;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

		int low = 0, high = 0, sum = arr[0];
		while(high < N) {
			if(sum >= S) {
				min = Math.min(min, high-low+1);
				sum -= arr[low];
				low++;
			} else {
				high++;
				if(high == N) break;
				sum += arr[high];
			}
		}
		System.out.print(min == Integer.MAX_VALUE ? 0 : min);
	}
}