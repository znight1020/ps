import java.util.*;
import java.io.*;
public class Main {
	static int d, k;
	static int[] c1, c2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c1 = new int[d+1];
		c2 = new int[d+1];

		c1[3] = c2[3] = 1;
		if(d > 3) {
			c1[4] = 1;
			c2[4] = 2;
			for(int i = 5; i <= d; i++) {
				c1[i] = c1[i-1] + c1[i-2];
				c2[i] = c2[i-1] + c2[i-2];
			}
		}

		int n1 = 0, n2 = 0;
		for (int i = 1; ; i++) {
			// By = k - Ax
			int res = k - (c1[d] * i);
			if (res % c2[d] == 0) {
				n1 = i;
				n2 = res / c2[d];
				break;
			}
		}

		System.out.println(n1);
		System.out.print(n2);
	}
}
