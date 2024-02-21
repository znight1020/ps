package solved.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Watch {
    static int N,M;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    // 상 우 하 좌
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static ArrayList<Point> cctvArr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6) cctvArr.add(new Point(i, j, map[i][j]));
            }
        }

        solution(0, map);
        System.out.print(min);
    }

    static int[][] copyMap(int[][] origin){
        int[][] copy = new int[N][M];
        for(int i = 0; i < N; i++){
            if (M >= 0) System.arraycopy(origin[i], 0, copy[i], 0, M);
        }
        return copy;
    }
    static void solution(int index, int[][] map) {
        if (index == cctvArr.size()) {
            int temp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) temp++;
                }
            }
            min = Math.min(temp, min);
            return;
        }
        int y = cctvArr.get(index).y;
        int x = cctvArr.get(index).x;
        int cctv = cctvArr.get(index).n;


        int ny, nx;
        switch (cctv) {
            case 1:
                for (int i = 0; i < 4; i++) {
                    int[][] child = copyMap(map);

                    ny = y + dy[i];
                    nx = x + dx[i];
                    while (0 <= ny && ny < N && 0 <= nx && nx < M && child[ny][nx] != 6) {
                        child[ny][nx] = 9;
                        ny += dy[i];
                        nx += dx[i];
                    }
                    solution(index + 1, child);
                }
                break;
            case 2:
                for(int i = 0; i < 2; i++){
                    int[][] child = copyMap(map);
                    ny = y + dy[i];
                    nx = x + dx[i];
                    while (0 <= ny && ny < N && 0 <= nx && nx < M && child[ny][nx] != 6) {
                        child[ny][nx] = 9;
                        ny += dy[i];
                        nx += dx[i];
                    }
                    ny = y - dy[i];
                    nx = x - dx[i];
                    while (0 <= ny && ny < N && 0 <= nx && nx < M && child[ny][nx] != 6) {
                        child[ny][nx] = 9;
                        ny -= dy[i];
                        nx -= dx[i];
                    }

                    solution(index + 1, child);
                }

                break;
            case 3:
                for(int i = 0; i < 4; i++){
                    int[][] child = copyMap(map);
                    ny = y + dy[i];
                    nx = x + dx[i];
                    while (0 <= ny && ny < N && 0 <= nx && nx < M && child[ny][nx] != 6) {
                        child[ny][nx] = 9;
                        ny += dy[i];
                        nx += dx[i];
                    }

                    int tempIndex = i;
                    tempIndex += 1;
                    if (tempIndex == 4) tempIndex = 0;
                    ny = y + dy[tempIndex];
                    nx = x + dx[tempIndex];
                    while (0 <= ny && ny < N && 0 <= nx && nx < M && child[ny][nx] != 6) {
                        child[ny][nx] = 9;
                        ny += dy[tempIndex];
                        nx += dx[tempIndex];
                    }

                    solution(index + 1, child);
                }

                break;

            case 4:
                for(int i = 0; i < 4; i++){
                    int[][] child = copyMap(map);
                    ny = y + dy[i];
                    nx = x + dx[i];
                    while (0 <= ny && ny < N && 0 <= nx && nx < M && child[ny][nx] != 6) {
                        child[ny][nx] = 9;
                        ny += dy[i];
                        nx += dx[i];
                    }

                    int tempIndex = i;
                    tempIndex += 1;
                    if (tempIndex == 4) tempIndex = 0;
                    ny = y + dy[tempIndex];
                    nx = x + dx[tempIndex];
                    while (0 <= ny && ny < N && 0 <= nx && nx < M && child[ny][nx] != 6) {
                        child[ny][nx] = 9;
                        ny += dy[tempIndex];
                        nx += dx[tempIndex];
                    }

                    ny = y - dy[tempIndex];
                    nx = x - dx[tempIndex];
                    while (0 <= ny && ny < N && 0 <= nx && nx < M && child[ny][nx] != 6) {
                        child[ny][nx] = 9;
                        ny -= dy[tempIndex];
                        nx -= dx[tempIndex];
                    }

                    solution(index + 1, child);
                }
                break;

            case 5:
                int[][] child = copyMap(map);
                for (int i = 0; i < 4; i++) {
                    ny = y + dy[i];
                    nx = x + dx[i];

                    while (0 <= ny && ny < N && 0 <= nx && nx < M && child[ny][nx] != 6) {
                        child[ny][nx] = 9;
                        ny += dy[i];
                        nx += dx[i];
                    }
                }
                solution(index + 1, child);
                break;
        }
    }
    static class Point{
        int y, x, n;

        public Point(int y, int x, int n) {
            this.y = y;
            this.x = x;
            this.n = n;
        }
    }

}

