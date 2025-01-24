import java.util.*;
import java.io.*;

public class Main {

	static int[] arr;
	static int max = 0, count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		arr = new int[n];
		int sum = 0, end = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i < x) {
				sum += arr[i];
				end = i;
			}
		}
		max = sum;
		count = 1;

		for(int i = 1; i < n-x+1; i++) {
			sum = sum - arr[i-1] + arr[end+1];
			end++;
			if(sum > max) {
				max = sum;
				count = 1;
			} else if(sum == max) count++;
		}

		if(max != 0)System.out.print(max + "\n" + count);
		else System.out.print("SAD");
	}
}
