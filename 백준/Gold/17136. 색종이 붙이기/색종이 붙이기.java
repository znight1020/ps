import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] paper = {5,5,5,5,5};
    static int[][] board = new int[10][10];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }
        DFS(0, new Point(0,0));
        if(answer == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(answer);
    }

    static void DFS(int cnt, Point p){
        if(p.y == 10 && p.x == 0){
            answer = Math.min(cnt, answer);
            return;
        }
        if(cnt >= answer) return;

        if(board[p.y][p.x] == 1){
            for(int i = 5; i >= 1; i--){
                if(check(p, i)) {
                    attachOrDetach(p, i, 0);
                    paper[i-1]--;

                    if(p.x + 1 == 10) DFS(cnt+1, new Point(p.y+1, 0));
                    else DFS(cnt+1, new Point(p.y, p.x+1));

                    attachOrDetach(p, i, 1);
                    paper[i-1]++;
                }
            }
        }
        else{
            if(p.x + 1 == 10) DFS(cnt, new Point(p.y+1, 0));
            else DFS(cnt, new Point(p.y, p.x+1));
        }
    }

    static void attachOrDetach(Point p, int len, int x){
        for(int i = p.y; i < p.y + len; i++){
            for(int j = p.x; j < p.x + len; j++){
                board[i][j] = x;
            }
        }
    }

    static boolean check(Point p, int len){
        if(p.y + len > 10 || p.x + len > 10) return false;

        for(int i = p.y; i < p.y + len; i++) {
            for(int j = p.x; j < p.x + len; j++) {
                if(board[i][j] == 0) return false;
            }
        }
        return paper[len-1] > 0;
    }
    static class Point{
        int y, x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
