package solved.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Point{
    int r, c;
    Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}
public class Bakery {

    // 오른쪽 위, 가운데, 아래
    static char[][] map;
    static int[] dr = {-1,0,1};
    static int[] dc = {1,1,1};
    static int R;
    static int C;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C]; // R 세로, C 가로

        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < R; i++){
            BFS(i);

            System.out.println("==========");
            for(int m = 0; m < R; m++){
                for(int j = 0; j < C; j++){
                    System.out.print(map[m][j]);
                }
                System.out.println();
            }
            System.out.println("==========");
        }
        System.out.print(answer);


    }

    static void BFS(int start){
        int oldAnswer = answer;
        Queue<Point> tempQ = new LinkedList<>();

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start, 0));
        Point p;
        while(!q.isEmpty()){
            p = q.poll();
            tempQ.add(p);
            if(p.c == C-1) {
                answer++;
                break;
            }
            for(int i = 0; i < dr.length; i++){
                int nr = p.r + dr[i]; // 위 아래
                int nc = p.c + dc[i]; // 오른쪽으로만 이동

                if(0 <= nr && nr < R && nc < C){
                    if(map[nr][nc] == '.'){
                        map[nr][nc] = 'x';
                        q.add(new Point(nr, nc));
                        break;
                    }
                    else continue;
                }
            }
        }
        if(oldAnswer != answer) {
            Point tp;
            while(!tempQ.isEmpty()){
                tp = tempQ.poll();
                map[tp.r][tp.c] = 'x';
            }
        }
    }
}
