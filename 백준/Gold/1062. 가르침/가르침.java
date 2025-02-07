import java.util.*;
import java.io.*;

public class Main {

	static int n, k, answer = 0;
	static String[] arr;
	static boolean[] learned = new boolean[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new String[n];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			str = str.replaceAll("[acnti]", "");
			arr[i] = str;

		}
		init();
		k -= 5;

		if(k == 21) System.out.print(n);
		else if(k < 0) System.out.println(0);
		else {
			dfs(0, 0);
			System.out.print(answer);
		}
	}

	static void dfs(int depth, int start) {
		if (depth == k) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				boolean flag = true;
				for (int j = 0; j < arr[i].length(); j++) {
					if(!learned[arr[i].charAt(j) - 'a']) {
						flag = false;
						break;
					}
				}
				if (flag) cnt++;
			}

			answer = Math.max(answer, cnt);
			return;
		}

		for(int i = start; i < 26; i++) {
			if(learned[i]) continue;

			learned[i] = true;
			dfs(depth+1, i+1);
			learned[i] = false;
		}
	}


	static void init() {
		learned[0] = true;
		learned[2] = true;
		learned['n'-'a'] = true;
		learned['t'-'a'] = true;
		learned['i'-'a'] = true;
	}
}
