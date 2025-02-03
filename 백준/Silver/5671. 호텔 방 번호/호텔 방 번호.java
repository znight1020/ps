import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String in;
		while((in = br.readLine()) != null) {
			int answer = 0;
			st = new StringTokenizer(in);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			while(n <= m) {
				if(isPair(String.valueOf(n))) answer++;
				n++;
			}
			System.out.println(answer);
		}
	}

	static boolean isPair(String num) {
		for(int i = 0; i < num.length()-1; i++) {
			int temp = num.charAt(i) - '0';
			for(int j = i+1; j < num.length(); j++) {
				int digit = num.charAt(j) - '0';
				if(temp == digit) return false;
			}
		}
		return true;
	}
}
