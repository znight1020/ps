package solved.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point2 {
    int x;
    int y;
    int z;
    public Point2(int z, int x, int y){
        this.z = z;
        this.x = x;
        this.y = y;

    }
}
public class Tomato_3dArray {
    // 상 하 좌 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // 아래, 위
    static int[] dz = {-1, 1};
    static int[][][] box, distance;
    static int N, M, H;

    static Queue<Point2> q = new LinkedList<>();

    static void BFS(){
        Point2 p;
        while(!q.isEmpty()){
            p = q.poll();
            int tempZ;
            int tempX;
            int tempY;

            for(int i = 0; i < dx.length; i++){
                tempZ = p.z;
                tempX = p.x + dx[i];
                tempY = p.y + dy[i];
                if(tempX < N && tempX >= 0 && tempY < M && tempY >= 0 && box[tempZ][tempX][tempY] == 0) { // 익은 토마토가 아닐 때
                    box[tempZ][tempX][tempY] = 1;
                    q.offer(new Point2(tempZ, tempX, tempY));
                    distance[tempZ][tempX][tempY] = distance[p.z][p.x][p.y] + 1;
                }
            }
            for(int j = 0; j < dz.length; j++){
                tempZ = p.z + dz[j];
                tempX = p.x;
                tempY = p.y;
                if(tempZ >= 0 && tempZ < H && box[tempZ][tempX][tempY] == 0){
                    box[tempZ][tempX][tempY] = 1;
                    q.offer(new Point2(tempZ, tempX, tempY));
                    distance[tempZ][tempX][tempY] = distance[p.z][p.x][p.y] + 1;
                }
            }

        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean flag = true;
        int answer = Integer.MIN_VALUE;

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        distance = new int[H][N][M];

        for(int h = 0; h < H; h++){
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++){
                    box[h][i][j] = Integer.parseInt(st.nextToken());
                    if(box[h][i][j] == 1) q.add(new Point2(h, i, j));
                }
            }
        }
        BFS();
        for(int h = 0; h < H; h++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(box[h][i][j] == 0) flag = false;
                    answer = Math.max(distance[h][i][j], answer);
                }
            }
        }


        if(flag) System.out.print(answer);
        else System.out.print(-1);
    }
}
