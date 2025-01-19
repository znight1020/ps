import java.util.*;
import java.io.*;

public class Main {
	static List<Character> charset = List.of('a','e','i','o','u');
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
        
		while(!"end".equals(str)) {
			boolean flag = true;
			int firstCount = 0, moCount = 0, jaCount = 0;
			char old = '1';
			char[] arr = str.toCharArray();

			for(int i = 0; i < arr.length; i++) {
				char c = arr[i];

				if(charset.contains(c)) {
					firstCount++;
					moCount++;
					jaCount = 0;
				}
				else {
					moCount = 0;
					jaCount++;
				}

				if(moCount >= 3 || jaCount >= 3) {
					flag = false;
					break;
				}

				if(old == c) {
					if(!(c == 'e' || c == 'o')){
						flag = false;
						break;
					}
				}
				old = c;
				if(i == arr.length-1 && firstCount == 0) flag = false;
			}

			sb.append("<").append(str).append(">").append(" is");
			if(flag) sb.append(" acceptable.");
			else sb.append(" not acceptable.");
			sb.append("\n");
			str = br.readLine();
		}
		System.out.print(sb);
	}
}
