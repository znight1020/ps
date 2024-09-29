import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static long answer = 0;
	static final int MAX_NAME_LENGTH = 20;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Queue<Integer>[] qList = new LinkedList[MAX_NAME_LENGTH + 1];
		for (int i = 2; i <= MAX_NAME_LENGTH; i++) qList[i] = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			int nameLength = br.readLine().length();

			while (!qList[nameLength].isEmpty() && i - qList[nameLength].peek() > K) {
				qList[nameLength].poll();
			}

			answer += qList[nameLength].size();
			qList[nameLength].add(i);
		}

		System.out.print(answer);
	}
}
