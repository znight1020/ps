package solved.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alphabet {
    static char[][] board;
    static int R, C;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for(int i = 0; i < R; i++) board[i] = br.readLine().toCharArray();
        if(R == 1 && C == 1) answer = 1;
        else{
            boolean[] check = new boolean[26];
            DFS(check, 0, 0, 0);
        }
        System.out.print(answer);
    }

    static void DFS(boolean[] check, int cnt, int r, int c){
        if(r<0 || r>=R || c<0 || c>=C) return;
        if(check[ board[r][c] - 'A' ]) {
            answer = Math.max(answer, cnt);
            return;
        }

        check[ board[r][c] - 'A' ] = true;
        DFS(check, cnt+1, r+1, c);
        DFS(check, cnt+1, r-1, c);
        DFS(check, cnt+1, r, c+1);
        DFS(check, cnt+1, r, c-1);
        check[ board[r][c] - 'A' ] = false;
    }
}
