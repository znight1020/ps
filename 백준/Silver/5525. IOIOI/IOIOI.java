import java.util.*;
import java.io.*;

public class Main {

	static Stack<Character> s = new Stack<>();
	static int answer = 0;

	static StringBuilder ioi = new StringBuilder("I");
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int temp = 1 + 2*N;
		ioi.append("OI".repeat(N));
		int size = Integer.parseInt(br.readLine());

		char[] str = br.readLine().toCharArray();
		for(int i = 0; i < size; i++) {
			char c = str[i];

			if (s.isEmpty() && c == 'I') s.push(c);
			else if (!s.isEmpty() && s.peek() == c) {
				s.clear();
				if(c == 'I') s.push(c);
			}
			else {
				if(!s.isEmpty()) {
					if ((s.peek() == 'I' && c == 'O') || (s.peek() == 'O' && c == 'I')) s.push(c);
				}
			}

			if(s.size() == temp) {
				answer++;
				s.clear();
				s.push('I');
				for(int j = 0; j < N-1; j++) {
					s.push('O');
					s.push('I');
				}
			}
		}
		System.out.print(answer);
	}
}
