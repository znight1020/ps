import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int base = Integer.parseInt(st.nextToken());

		while(N >= base) {
			int mod = N % base;
			N /= base;

			if(mod >= 10) sb.append(convert(mod-10));
			else sb.append(mod);
		}

		if(N >= 10) sb.append(convert(N-10));
		else sb.append(N);

		System.out.println(sb.reverse());
	}

	static char convert(int n) {
		return (char)(n + 'A');
	}
}
