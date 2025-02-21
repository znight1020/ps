import java.util.*;
import java.io.*;
public class Main {

	static int L, N, T;
	static List<Ball> balls = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int pos = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			balls.add(new Ball(pos, d));
		}

		int answer = solution();
		System.out.print(answer);
	}

	static int solution() {
		int t = 1, cnt = 0;
		while(t <= T) {
			boolean[] crash = new boolean[L+1];
			List<Integer> crashPoints = new ArrayList<>(List.of(0, L));

			for(Ball b : balls) {
				if(b.d == 'R') b.pos += 1;
				else b.pos -= 1;

				if(crash[b.pos]) {
					cnt++;
					crashPoints.add(b.pos);
				}
				crash[b.pos] = true;
			}

			for(int p : crashPoints) {
				for(Ball b : balls) {
					if(b.pos == p) {
						if(b.d == 'R') b.d = 'L';
						else b.d = 'R';
					}
				}
			}
			t++;
		}
		return cnt;
	}

	static class Ball {
		int pos;
		char d;

		Ball(int pos, char d) {
			this.pos = pos;
			this.d = d;
		}
	}
}
