import java.util.*;
import java.io.*;

public class Main {

	static Set<Character> set = new HashSet<>();
	static Set<Character> ans = new HashSet<>();
	static int answer = 0;
	static String[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new String[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = st.nextToken();
			set.add(arr[i].charAt(0));
			set.add(arr[i].charAt(1));
		}

		Arrays.sort(arr);

		int max = set.size();
		for(int i = 0; i < arr.length; i++) {
			solution(i, arr.length);
			answer = ans.size();
			if(answer == max) break;
		}
		sb.append(answer).append("\n");
		List<Character> a = new ArrayList<>(ans);
		Collections.sort(a);
		for(char c : a) sb.append(c).append(" ");
		System.out.print(sb);
	}

	static void solution(int idx, int size) {
		String s1 = arr[idx];
		for(int i = 0; i < size; i++) {
			if(i == idx) continue;
			String s2 = Character.toString(s1.charAt(0)) + arr[i].charAt(1);
			if(s2.charAt(0) > s2.charAt(1)) ans.add(s2.charAt(0));
			else ans.add(s2.charAt(1));
		}
	}
}
