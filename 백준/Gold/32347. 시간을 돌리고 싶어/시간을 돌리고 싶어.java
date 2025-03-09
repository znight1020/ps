import java.util.*;
import java.io.*;

public class Main {

	static int N, K, min, size;
	static List<Integer> pos = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		min = N-1;

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) if(Integer.parseInt(st.nextToken()) == 1) pos.add(i);
		size = pos.size();
		
		binarySearch(N / K, N-1);
		System.out.print(min);
	}

	static void binarySearch(int start, int end) {
		while(start <= end) {
			int mid = (start+end) / 2;
			boolean flag = check(mid);
			if(flag) {
				min = Math.min(min, mid);
				end = mid-1;
			} else start = mid+1;
		}
	}

	static boolean check(int T) {
		int idx = N-1, cnt = 0;
		while(idx > 0) {
			if(cnt >= K && (K-cnt) * T < idx) return false;
			idx -= T;
			if(idx > 0) idx = setIdx(idx);
			cnt++;
		}
		return true;
	}

	static int setIdx(int idx) {
		int left = 0, right = size-1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (pos.get(mid) >= idx) right = mid;
			else left = mid + 1;
		}
		return pos.get(left);
	}
}
