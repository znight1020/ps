package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

    void move(int dy, int dx) {
        this.y += dy;
        this.x += dx;
    }
}

public class 상호의배틀필드 {
    static char[][] map;
    static char[] command;
    static int tankIndex;
    static char[] tank = {'^', 'v', '<', '>'};
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int H, W;
    static Point p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];

            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i] = str.toCharArray();
                    for (int m = 0; m < 4; m++)
                        if (map[i][j] == tank[m]) {
                            tankIndex = m;
                            p = new Point(i, j);
                        }
                }
            }
            br.readLine();
            command = br.readLine().toCharArray();
            solution();

            sb.append("#" + t + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
    static void solution() {
        for(int i = 0; i < command.length; i++){
            int ny, nx;
            switch (command[i]) {
                case 'U':
                    tankIndex = 0;
                    moveTank();
                    break;
                case 'D':
                    tankIndex = 1;
                    moveTank();
                    break;
                case 'L':
                    tankIndex = 2;
                    moveTank();
                    break;
                case 'R':
                    tankIndex = 3;
                    moveTank();
                    break;
                case 'S':
                    ny = p.y + dy[tankIndex];
                    nx = p.x + dx[tankIndex];
                    while (true) {
                        if(ny < 0 || ny >= H || nx < 0 || nx >= W) break;
                        if (map[ny][nx] == '*') {
                            map[ny][nx] = '.';
                            break;
                        }
                        else if (map[ny][nx] == '#') break;
                        else {
                            ny += dy[tankIndex];
                            nx += dx[tankIndex];
                        }
                    }
                    break;
            }
        }
    }
    static void moveTank() {
        int ny = p.y + dy[tankIndex];
        int nx = p.x + dx[tankIndex];

        map[p.y][p.x] = tank[tankIndex];
        if (ny >= 0 && ny < H && nx >= 0 && nx < W && map[ny][nx] == '.') {
            map[p.y][p.x] = '.';
            p.move(dy[tankIndex], dx[tankIndex]);
            map[p.y][p.x] = tank[tankIndex];
        }
    }
}