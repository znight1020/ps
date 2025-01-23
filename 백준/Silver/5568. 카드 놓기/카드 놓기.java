import java.io.*;
import java.util.*;

public class Main {
	static int[] src;
	static int n, k;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		src = new int[n];

		for(int i = 0; i < n; i++) src[i] = Integer.parseInt(br.readLine());
		comb(0, new String[k], new boolean[n]);
		System.out.print(set.size());
	}

	static void comb(int depth, String[] arr, boolean[] vtd) {
		if(depth == k) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < k; i++) sb.append(arr[i]);
			set.add(sb.toString());
			return;
 		}

		for(int i = 0; i < n; i++) {
			if(vtd[i]) continue;

			vtd[i] = true;
			arr[depth] = String.valueOf(src[i]);
			comb(depth+1, arr, vtd);
			vtd[i] = false;
		}
	}
}
