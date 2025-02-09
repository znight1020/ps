import java.util.*;
import java.io.*;

public class Main {

	static int[] result = new int[10];
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < 10; i++) result[i] = Integer.parseInt(st.nextToken());
		dfs(0, new int[10]);
		System.out.println(answer);
	}

	static void dfs(int depth, int[] test) {
		if(depth == 10) {
			if(pass(test)) answer++;
			return;
		}

		for(int i = 1; i < 6; i++) {
			if(depth > 1 && test[depth-2] == i && test[depth-1] == i) continue;
			test[depth] = i;
			dfs(depth+1, test);
		}
	}

	static boolean pass(int[] test) {
		int point = 0;
		for(int i = 0; i < 10; i++) if(test[i] == result[i]) point++;
		return point > 4;
	}
}
