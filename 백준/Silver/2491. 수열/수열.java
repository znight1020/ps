import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

		int plusMax = 0, subMax = 0, plusCnt = 0, subCnt = 0, idx = 0, old = -1;
		while(idx < n) {
			int current = arr[idx];
			if(old <= current) {
				plusCnt++;
				plusMax = Math.max(plusMax, plusCnt);
			}
			else plusCnt = 1;

			if(old >= current) {
				subCnt++;
				subMax = Math.max(subMax, subCnt);
			}
			else subCnt = 1;

			old = arr[idx];
			idx++;
		}
		System.out.print(Math.max(plusMax, subMax));
	}
}
