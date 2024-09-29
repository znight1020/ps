import java.util.*;
import java.io.*;

public class Main {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static char[][] map;
	static int r, c, k;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new char[r][c];

		for(int i = 0; i < r; i++) {
			String rowValue = br.readLine();
			for(int j = 0; j < c; j++) map[i][j] = rowValue.charAt(j);
		}

		Point startPoint = new Point(r-1, 0, 1);

		boolean[][] vtd = new boolean[r][c];
		vtd[r-1][0] = true;
		goHome(vtd, startPoint);

		System.out.println(answer);
	}

	static void goHome(boolean[][] vtd, Point p) {
		if(p.r == 0 && p.c == c-1) {
			if(p.value == k) answer++;
			return;
		}

		for(int i = 0; i < 4; i++) {
			int nr = p.r + dy[i];
			int nc = p.c + dx[i];
			int nv = p.value + 1;
			if(validator(vtd, nr, nc, nv)) {
				vtd[p.r][p.c] = true;
				goHome(vtd, new Point(nr, nc, nv));
				vtd[p.r][p.c] = false;
			}
		}
	}

	static boolean validator(boolean[][] vtd, int nr, int nc, int nv) {
		if(nr < 0 || nr >= r || nc < 0 || nc >= c) {
			return false;
		}

		if(vtd[nr][nc]) {
			return false;
		}

		if(map[nr][nc] == 'T') {
			return false;
		}

		if(nv > k) {
			return false;
		}

		return true;
	}

	static class Point {
		int r;
		int c;
		int value;

		Point(int r, int c, int value) {
			this.r = r;
			this.c = c;
			this.value = value;
		}
	}
}
