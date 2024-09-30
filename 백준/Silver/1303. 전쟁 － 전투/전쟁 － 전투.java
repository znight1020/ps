import java.util.*;
import java.io.*;

public class Main {

	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};

	static int N, M, myPower = 0, enemyPower = 0;

	static char[][] map;
	static boolean[][] vtd;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[M][N];
		vtd = new boolean[M][N];

		for(int i = 0; i < M; i++) map[i] = br.readLine().toCharArray();

		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!vtd[i][j] && map[i][j] == 'W') {
					vtd[i][j] = true;
					myPower += getPower(map[i][j], new Point(i, j));
				}

				else if(!vtd[i][j] && map[i][j] == 'B') {
					vtd[i][j] = true;
					enemyPower += getPower(map[i][j], new Point(i, j));
				}
			}
		}

		System.out.print(myPower + " " + enemyPower);
	}

	static int getPower(char c, Point start) {
		int cnt = 1;

		Queue<Point> q = new LinkedList<>();
		q.add(start);

		while(!q.isEmpty()){
			Point p = q.poll();

			for(int iter = 0; iter < 4; iter++) {
				int ny = dy[iter] + p.y;
				int nx = dx[iter] + p.x;

				if(validate(ny, nx) && map[ny][nx] == c && !vtd[ny][nx]) {
					vtd[ny][nx] = true;
					q.add(new Point(ny, nx));
					cnt++;
				}
			}
		}

		return cnt * cnt;
	}

	static boolean validate(int ny, int nx) {
		if(0 > ny || M <= ny || N <= nx || 0 > nx) return false;

		return true;
	}

	static class Point {
		int y, x;
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
