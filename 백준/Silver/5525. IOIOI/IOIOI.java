import java.util.*;
import java.io.*;

public class Main {

	static Stack<Character> s = new Stack<>();
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int size = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();

		int cnt = 0;
		for(int i = 1; i < size-1; i++) {
			if(str[i-1] == 'I' && str[i] == 'O' && str[i+1] == 'I') {
				cnt++;
				i++;
				if(cnt == N) {
					cnt--;
					answer++;
				}
			} else cnt = 0;
		}
		System.out.print(answer);
	}
}
