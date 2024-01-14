package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스도쿠_검증 {
    static int[][] matrix;
    static int[] check = new int[10];

    public int solution(int[][] matrix){
        boolean flag = true;
        check = new int[10];
        //가로
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(check[matrix[i][j]] == 0) check[matrix[i][j]]++;
                else {
                    return 0;
                }
            }
            check = new int[10];
        }
        check = new int[10];
        //세로
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(check[matrix[j][i]] == 0) check[matrix[j][i]]++;
                else{
                    return 0;
                }
            }
            check = new int[10];
        }
        //섹션
        int i = 0, j = 0;
        while(i < 9){
            check = new int[10];
            for(int m = i; m < i+3; m++){
                for(int n = j; n < j+3; n++){
                    if(check[matrix[m][n]] == 0) check[matrix[m][n]]++;
                    else return 0;
                }
            }
            j += 3;
            if(j == 9){
                j = 0;
                i += 3;
            }
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        스도쿠_검증 s = new 스도쿠_검증();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            matrix = new int[9][9];

            for(int i = 0; i < 9; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.print("#" + t + " ");
            System.out.println(s.solution(matrix));
        }
    }
}
