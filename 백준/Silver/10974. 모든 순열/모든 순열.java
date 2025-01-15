import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[] src;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		src = new int[n];
		for(int i = 0; i < n; i++) src[i] = i+1;

		perm(0, new int[n], new boolean[n]);
		System.out.print(sb);
	}

	static void perm(int depth, int[] arr, boolean[] vtd) {
		if(depth == n) {
			for(int v : arr) sb.append(v).append(" ");
			sb.append("\n");
			return;
		}

		for(int i = 0; i < n; i++) {
			if(vtd[i]) continue;

			arr[depth] = i+1;
			vtd[i] = true;
			perm(depth+1, arr, vtd);
			vtd[i] = false;
		}
	}
}
