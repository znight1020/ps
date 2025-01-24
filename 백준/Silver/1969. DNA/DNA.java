import java.io.*;
import java.util.*;

public class Main {

	static int[][] arr;
	static char[] src = {'A', 'C', 'G', 'T'};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[m][4];
		for(int i = 0; i < n; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				int idx = 0;
				if(temp[j] == 'C') idx = 1;
				else if(temp[j] == 'G') idx = 2;
				else if(temp[j] == 'T') idx = 3;
				arr[j][idx]++;
			}
		}

		int answer = 0;
		for(int i = 0; i < m; i++) {
			int max = 0, maxIdx = 0;

			for(int j = 0; j < 4; j++) {
				if(max < arr[i][j]) {
					max = arr[i][j];
					maxIdx = j;
				}
			}
			for(int j = 0; j < 4; j++) {
				if(j == maxIdx) continue;
				answer += arr[i][j];
			}

			sb.append(src[maxIdx]);
		}

		System.out.println(sb);
		System.out.print(answer);
	}
}
