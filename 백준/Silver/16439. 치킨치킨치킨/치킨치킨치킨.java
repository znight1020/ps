import java.util.*;
import java.io.*;

public class Main {
	static int[][] person;
	static int N, M, answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		person = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				person[i][j] = Integer.parseInt(st.nextToken());
		}

		comb(0, 0, new int[3]);
		System.out.print(answer);
	}

	static void comb(int depth, int start, int[] arr) {
		if(depth == 3) {
			calculate(arr);
			return;
		}

		for(int i = start; i < M; i++) {
			arr[depth] = i;
			comb(depth+1, i, arr);
		}
	}

	static void calculate(int[] arr) {
		int sum = 0;
		for(int i = 0; i < N; i++) {
			int max = 0;
			for(int j = 0; j < 3; j++) max = Math.max(max, person[i][arr[j]]);
			sum += max;
		}
		answer = Math.max(answer, sum);
	}
}
