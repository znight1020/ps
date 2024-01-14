package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자_배열_회전 {

    public void solution(int n, int[][] matrix) {
        int[][] angle90 = new int[n][n];
        int[][] angle180 = new int[n][n];
        int[][] angle270 = new int[n][n];

        // 90도 회전
        int k = 0, l;

        for(int i = 0; i < n; i++){
            l = 0;
            for(int j = n-1; j >= 0; j--){
                angle90[k][l] = matrix[j][i];
                l++;
            }
            k++;
        }
        k = 0;
        // 180도 회전
        for(int i = n-1; i >= 0; i--){
            l = 0;
            for(int j = n-1; j >= 0; j--){
                angle180[k][l] = matrix[i][j];
                l++;
            }
            k++;
        }
        k = 0;
        //270도 회전
        for(int i = n-1; i >= 0; i--){
            l = 0;
            for(int j = 0; j < n; j++){
                angle270[k][l] = matrix[j][i];
                l++;
            }
            k++;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(angle90[i][j]);
            }
            System.out.print(" ");
            for(int j = 0; j < n; j++){
                System.out.print(angle180[i][j]);
            }
            System.out.print(" ");
            for(int j = 0; j < n; j++){
                System.out.print(angle270[i][j]);
            }

            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        숫자_배열_회전 s = new 숫자_배열_회전();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int m = 1; m <= T; m++){
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#" + m);
            s.solution(n, matrix);
        }

    }
}
