package solved.s1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Concave {
    static ArrayList<Integer> vtd = new ArrayList<>();
    static int[][] board;
    // 상, 하, 좌, 우, 왼쪽 (위, 아래), 오른쪽 (위, 아래)
    static int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
    static int[] dy = { 0, 0, -1, 1, -1, -1, 1, 1 };

    public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("Test5.txt"));
        // 여기에 코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean flag = true;
        int n = 20;
        board = new int[n+1][n+1];

        int stackOfBlack = 1, stackOfWhite = 1;
        int result = 0, numX = 0, numY = 0;

        // 보드 초기화
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 답 도출
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {

                if (board[i][j] == 1) { // 검은색 돌
                    for (int d = 0; d < dx.length; d++) {
                        int tempI = i;
                        int tempJ = j;
                        stackOfBlack = 1;

                        while(tempI + dx[d] < n && tempI + dx[d] > 0 && tempJ + dy[d] > 0 && tempJ + dy[d] < n) {
                            if (board[tempI + dx[d]][tempJ + dy[d]] == 1 && board[i - dx[d]][j - dy[d]] != 1 ) {
                                stackOfBlack++;

                                if(d == 7) {

                                }
                                tempI += dx[d];
                                tempJ += dy[d];
                            }
                            else break;
                        }

                        if(stackOfBlack == 5) {
                            result = 1;
                            if(tempJ < j){
                                numX = tempI;
                                numY = tempJ;
                            } else{
                                numX = i;
                                numY = j;
                            }
                            flag = false;
                            break;
                        }
                    }
                }

                if (board[i][j] == 2) {

                    for (int d = 0; d < dx.length; d++) {
                        int tempI = i;
                        int tempJ = j;
                        stackOfWhite = 1;
                        while(tempI + dx[d] < n && tempI + dx[d] > 0 && tempJ + dy[d] > 0 && tempJ + dy[d] < n) {
                            if (board[tempI + dx[d]][tempJ + dy[d]] == 2 && board[i - dx[d]][j - dy[d]] != 2) {
                                stackOfWhite++;
                                tempI += dx[d];
                                tempJ += dy[d];
                            }
                            else break;
                        }
                        if(stackOfWhite == 5) {
                            result = 2;
                            if(tempJ < j){
                                numX = tempI;
                                numY = tempJ;
                            } else{
                                numX = i;
                                numY = j;
                            }
                            flag = false;
                            break;
                        }
                    }
                }
                if(!flag) break;
            }
            if(!flag) break;
        }

        System.out.println(result);
        if(result != 0) System.out.println(numX + " " + numY);

    }
}
