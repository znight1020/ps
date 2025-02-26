import java.util.*;
import java.io.*;

public class Main {

	static int total, win, z, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		total = Integer.parseInt(st.nextToken());
		win = Integer.parseInt(st.nextToken());
		z = getRate(total, win);
		if(z >= 99) System.out.print(-1);
		else {
			search(0, 1_000_000_000);
			System.out.print(min);
		}
	}

	static void search(int start, int end) {
		while(start <= end) {
			int mid = (start+end) / 2;
			if(getRate(total+mid, win+mid) != z) {
				min = mid;
				end = mid-1;
			} else start = mid+1;
		}
	}

	static int getRate(int x, int y) {
		return (int) ((long) y * 100 / x);
	}
}
