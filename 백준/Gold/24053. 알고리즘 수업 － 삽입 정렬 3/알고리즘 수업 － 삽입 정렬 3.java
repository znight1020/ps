import java.util.*;
import java.io.*;

public class Main {

	static boolean answer = false;
	static int n;
	static int[] A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		A = new int[n];
		B = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) B[i] = Integer.parseInt(st.nextToken());
		insertionSort(A);
		System.out.print(answer ? 1 : 0);
	}

	static void insertionSort(int[] arr) {
		for(int i = 1; i < n; i++) {
			int idx = i-1, current = arr[i];

			while(0 <= idx && current < arr[idx]) {
				arr[idx+1] = arr[idx];
				idx--;
				if(check(arr, B)) return;
			}

			if(idx + 1 != i) {
				arr[idx+1] = current;
				if(check(arr, B)) return;
			}
		}
	}

	static boolean check(int[] arr1, int[] arr2) {
		return answer = Arrays.equals(arr1, arr2);
	}
}
