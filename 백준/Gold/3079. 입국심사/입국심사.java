import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] passport;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		passport = new int[N];

		for(int i = 0; i < N; i++) passport[i] = Integer.parseInt(br.readLine());

		long end = 1_000_000_000L * 1_000_000_000L;
		System.out.print(pass(0, end));
	}

	static long pass(long start, long end){
		long result = end;
		while(start <= end) {
			long mid = (start + end) / 2, sum = 0;
			for(int i = 0; i < passport.length; i++) {
				sum += mid / passport[i];
				if(sum >= M) break;
			}

			if(sum < M) start = mid+1;
			else {
				result = mid;
				end = mid-1;
			}
		}
		return result;
	}
}
