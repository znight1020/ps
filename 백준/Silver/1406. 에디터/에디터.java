import java.util.*;
import java.io.*;

public class Main {

	static ArrayDeque<Character> left = new ArrayDeque<>();
	static ArrayDeque<Character> right = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		char[] arr = br.readLine().toCharArray();
		for(char c : arr) left.add(c);

		int cnt = Integer.parseInt(br.readLine()), point = left.size(), total = left.size();
		for(int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			char op = st.nextToken().charAt(0);
			if(op == 'P') {
				char c = st.nextToken().charAt(0);
				left.add(c);
				total++;
				point++;
			} else if(op == 'L') {
				point--;
				if(point < 0) {
					point = 0;
					continue;
				}
				right.addFirst(left.pollLast());
			} else if(op == 'D') {
				point++;
				if(point > total) {
					point = total;
					continue;
				}
				left.add(right.pollFirst());
			} else if(op == 'B') {
				if(point == 0) continue;
				total--;
				point--;
				left.pollLast();
			}
		}

		for(char c : left) sb.append(c);
		for(char c : right) sb.append(c);
		System.out.print(sb);
	}

}
