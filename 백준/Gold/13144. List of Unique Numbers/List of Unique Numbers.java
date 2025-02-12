import java.util.*;
import java.io.*;

public class Main {

	static long answer = 0;
	static int[] arr = new int[100001];
	static boolean[] vtd = new boolean[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

		int l = 0, r = 0;
		while(r < N) {
			if(!vtd[arr[r]])  {
				vtd[arr[r]] = true;
				r++;
			}
			else {
				answer += r-l;
				vtd[arr[l]] = false;
				l++;
			}
		}

		answer += (long) (r-l) * (r-l+1) / 2;
		System.out.print(answer);
	}
}
