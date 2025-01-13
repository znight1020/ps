import java.util.*;
import java.io.*;

public class Main {

	static Stack<Integer> stack = new Stack<>();
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) stack.push(Integer.parseInt(br.readLine()));

		int point = stack.pop();
		while(N > 1) {
			int temp = stack.pop();
			while(temp >= point) {
				answer++;
				temp--;
			}
			point = temp;
			N--;
		}

		System.out.print(answer);
	}
}
