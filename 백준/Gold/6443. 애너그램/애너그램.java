import java.util.*;
import java.io.*;

public class Main {
	static char[] src;
	static List<String> strList;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int t = 0; t < N; t++) {
			sb = new StringBuilder();
			src = br.readLine().toCharArray();
			int[] vtd = new int[26];
			for (char c : src) vtd[c-'a']++;
			strList = new ArrayList<>();
			int size = src.length;
			anagram(size, 0, new char[size], vtd);
			strList.stream().sorted().forEach((s) -> sb.append(s).append("\n"));
			System.out.print(sb);
		}
	}

	static void anagram(int size, int depth, char[] arr, int[] vtd) {
		if(depth == size) strList.add(String.valueOf(arr));
		for(int i = 0; i < 26; i++) {
			if(vtd[i] == 0) continue;
			vtd[i]--;
			arr[depth] = (char)(i+'a');
			anagram(size, depth+1, arr, vtd);
			vtd[i]++;
		}
	}
}
