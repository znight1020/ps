import java.util.*;
import java.io.*;

public class Main {

	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static char[][] map = new char[10][10];
	static boolean[][] vtd = new boolean[10][10];
	static int answer = 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Point lake = null;

		for(int i = 0; i < 10; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < 10; j++) if(map[i][j] == 'L') lake = new Point(i, j, 0);
		}
		findBrigade(lake);
		System.out.print(answer);
	}

	static void findBrigade(Point lake) {
		Queue<Point> q = new LinkedList<>();
		q.add(lake);

		while(!q.isEmpty()) {
			Point p = q.poll();

			for(int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];

				if(ny < 0 || ny >= 10 || nx < 0 || nx >= 10 || vtd[ny][nx] || map[ny][nx] == 'R') continue;

				if(map[ny][nx] == 'B') {
					answer = Math.min(answer, p.count);
					return;
				}

				vtd[ny][nx] = true;
				q.add(new Point(ny, nx, p.count + 1));
			}
		}
	}

	static class Point {
		int y, x, count;
		Point(int y, int x, int count) {
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}
}
