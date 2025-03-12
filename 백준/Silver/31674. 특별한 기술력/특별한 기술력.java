import java.util.*;
import java.io.*;
public class Main {

	static final int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] A = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A, Collections.reverseOrder());
		
		long[] B = new long[N];
		B[0] = A[0];

		long sum = B[0];
		for(int i = 1; i < N; i++) {
			B[i] = (sum+A[i]) % MOD;
			sum = (sum + B[i]) % MOD;
		}
		System.out.print(sum);
	}
}
