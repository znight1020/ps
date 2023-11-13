package lecture.section8_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maze_navigation {
    static int[][] maze = new int[7][7];
    static int[][] check = new int[7][7];
    static int answer = 0;
    public void solution(int x, int y){
        if(x == 6 && y == 6) {
            answer++;
            return;
        }

        if(maze[x][y] == 1 || check[x][y] == 1){
            return;
        }
        else if(check[x][y] == 0 && maze[x][y] == 0){
            check[x][y] = 1;
            if(y > 0)solution(x, y-1);
            if(y < 6)solution(x, y+1);
            if(x < 6)solution(x+1, y);
            if(x > 0)solution(x-1, y);
            check[x][y] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        Maze_navigation m = new Maze_navigation();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int temp;
        for(int i = 0; i < 7; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 7; j++){
                temp = Integer.parseInt(st.nextToken());
                maze[i][j] = temp;
                check[i][j] = temp;
            }
        }
        m.solution(0,0);

        System.out.println(answer);
    }
}
