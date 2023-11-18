package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 달팽이_숫자 {
    public int[][] solution(int[][] map, int size){
        int value = 1;
        int left = 0, right = size; // 가로, x_index
        int bottom = size, top = 0; // 세로, y_index

        while(value < size*size + 1){
            for(int i = left; i < right; i++){
                map[top][i] = value;
                value++;
            }
            top++;

            for(int i = top; i < bottom; i++){
                map[i][right-1] = value;
                value++;
            }
            right--;

            for(int i = right-1; i >= left; i--){
                map[bottom-1][i] = value;
                value++;
            }
            bottom--;

            for(int i = bottom-1; i >= top; i--){
                map[i][left] = value;
                value++;
            }
            left++;

        }

        return map;
    }
    public static void main(String[] args) throws IOException {
        달팽이_숫자 d = new 달팽이_숫자();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int map[][];

        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1; t <= testCase; t++){
            int size = Integer.parseInt(br.readLine());
            map = new int[size][size];

            map = d.solution(map, size);

            System.out.println("#" + t);
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
