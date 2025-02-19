import java.util.*;
import java.io.*;

public class Main {

	static int[] answer = new int[2];
	static int[] arr;
	static int n, diff = Integer.MAX_VALUE, firstPositive = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n-1; i++) {
			if(diff == 0) break;
			int start = i+1, end = n-1;

			while(start <= end) {
				int mid = (start+end) / 2;
				int cal = arr[i] + arr[mid];

				if(Math.abs(cal) < diff) {
					answer[0] = arr[i];
					answer[1] = arr[mid];
					diff = Math.abs(cal);
				}

				if(cal < 0) start = mid+1;
				else end = mid-1;
			}
		}

		System.out.print(answer[0] + " " + answer[1]);
	}
}
