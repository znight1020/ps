import java.util.*;
import java.io.*;

public class Main {
	static int N, THRESHOLD, answer = 1;
	static Integer[] arr;
	static Deque<Integer> dq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		THRESHOLD = Integer.parseInt(br.readLine());
		arr = new Integer[N];

		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr, new Comparator<>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		dq = new ArrayDeque<>(List.of(arr));

		int sum = 0, size = 0;
		while(!dq.isEmpty()) {
			sum += dq.pollFirst();
			size++;
			if(!dq.isEmpty() && size <= 1 && sum + dq.getLast() <= THRESHOLD) {
				sum += dq.pollLast();
				size++;
			}
			if(dq.isEmpty()) break;

			if(size == 2 || sum + dq.getLast() > THRESHOLD) {
				sum = 0;
				size = 0;
				answer++;
			}
		}

		System.out.println(answer);
	}
}
