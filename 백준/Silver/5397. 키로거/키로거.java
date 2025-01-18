import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			System.out.println(findPassword(arr));
		}
	}

	static StringBuilder findPassword(char[] arr) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		for(int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if(c == '<') {
				if(!left.isEmpty()) right.push(left.pop());
			}
			else if(c == '>') {
				if(!right.isEmpty()) left.push(right.pop());
			} else if (c == '-') {
				if(!left.isEmpty()) left.pop();
			} else left.push(c);
		}
		while(!right.isEmpty()) left.push(right.pop());
		for(char temp : left) sb.append(temp);
		return sb;
	}
}