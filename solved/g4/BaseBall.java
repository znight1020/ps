package solved.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaseBall {
    static int[][] game;
    static boolean[] base;
    static int answer = 0;

    static int current = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int innings = Integer.parseInt(br.readLine());
        int cnt = 0;
        game = new int[innings][9];

        for(int i = 0; i < innings; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) game[i][j] = Integer.parseInt(st.nextToken());
        }

        current = 1;
        while(cnt < innings){
            int sum = 0;
            for(int i = 0; i < 9; i++) sum += game[cnt][i];
            if(sum >= 4) solution(game[cnt]);

            cnt++;
        }
    }

    static void solution(int[] inning){
        // 순번 정하기
        base = new boolean[4];
        int[] order = new int[9];
        int outCnt = 0;
        order[3] = inning[0]; // 1번 선수는 항상 4번타자
//
//        for(int i = 0; i < order.length; i++){
//            order[i] =
//        }
//        while(outCnt < 3){
//
//            if()
//        }

        current++;
        if(current == 10) current = 1;
    }
}
