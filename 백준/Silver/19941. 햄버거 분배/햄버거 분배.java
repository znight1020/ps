import java.util.*;
import java.io.*;

public class Main {

	static boolean[] burgers, people;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		burgers = new boolean[N];
		people = new boolean[N];

		char[] table = br.readLine().toCharArray();
		for(int i = 0; i < N; i++) {
			if(table[i] == 'H') burgers[i] = true;
			if(table[i] == 'P') people[i] = true;
		}

		int answer = 0;
		for(int i = 0; i < N; i++) {
			if(!people[i]) continue;
			for(int j = i-K; j <= i+K; j++) {
				if(j < 0 || j >= N) continue;
				if(burgers[j]) {
					burgers[j] = false;
					answer++;
					break;
				}
			}
		}
		System.out.print(answer);
	}

}
