import java.io.*;
import java.util.*;

public class Main {

	static int N, cnt = 0;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			String chat = br.readLine();
			if("ENTER".equals(chat)) {
				cnt += set.size();
				set = new HashSet<>();
				continue;
			}
			set.add(chat);
		}
		cnt += set.size();
		System.out.print(cnt);
	}
}