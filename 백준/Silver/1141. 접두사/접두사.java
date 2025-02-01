import java.util.*;
import java.io.*;

public class Main {
	static String[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N];
		for(int i = 0; i < N; i++) arr[i] = br.readLine();
		Arrays.sort(arr, new Comparator<>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});

		List<String> prefix = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String current = arr[i];

			if(prefix.isEmpty()) {
				prefix.add(current);
				continue;
			}

			boolean flag = true;
			for(String s : prefix) {
				if(s.startsWith(current)) {
					flag = false;
					break;
				}
			}

			if(flag) prefix.add(current);
		}
		System.out.print(prefix.size());
	}
}
