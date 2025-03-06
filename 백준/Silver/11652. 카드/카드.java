import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), max = 0, cnt = 0;
		List<Long> arr = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			long n = Long.parseLong(br.readLine());
			arr.add(n);
		}
		Collections.sort(arr);

		long old = arr.get(0), ans = 0;
		cnt++;
		for(int i = 1; i < N; i++) {
			long current = arr.get(i);
			if(old == current) cnt++;
			else {
				if(max < cnt) {
					max = cnt;
					ans = old;
				}
				max = Math.max(max, cnt);
				old = current;
				cnt = 1;
			}
		}
		if(max < cnt) ans = old;

		System.out.print(ans);
	}
}
