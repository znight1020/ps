import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			sb.append("Data Set ").append(i+1).append(":").append("\n");
			char[] arr = br.readLine().toCharArray();
			boolean flag;
			if(arr.length % 2 == 1) flag = false;
			else flag = isCorrect(arr);

			if(flag) sb.append("Yes");
			else sb.append("No");

			if(i != N-1) sb.append("\n\n");
		}

		System.out.print(sb);
	}

	static boolean isCorrect(char[] arr) {
		Stack<Character> s = new Stack<>();
		int size = arr.length;

		for(int i = 0; i < size; i++) {
			if(s.isEmpty()) {
				s.push(arr[i]);
				continue;
			}

			char temp = s.peek();
			if(temp == 'u' && arr[i] == 'd') s.pop();
			else if(temp == 'l' && arr[i] == 'r') s.pop();
			else if(temp == 'r' && arr[i] == 'l') s.pop();
			else if(temp == 'd' && arr[i] == 'u') s.pop();
			else s.push(arr[i]);
		}

		return s.isEmpty();
	}
}
