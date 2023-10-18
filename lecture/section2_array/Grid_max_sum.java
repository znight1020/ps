package lecture.section2_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Grid_max_sum {
    public int solution(int num, int[][] grid){
        int i, j, r_max = 0, c_max = 0, d1 = 0, d2 = 0, sum, max;
        for(i = 0; i < num; i++){
            // r_max
            sum = 0;
            for(j = 0; j < num; j++){
                sum += grid[i][j];
                if(r_max < sum) r_max = sum;
            }
            // c_max
            sum = 0;
            for(j = 0; j < num; j++) {
                sum += grid[j][i];
                if(c_max < sum) c_max = sum;
            }
            // d1
            d1 += grid[i][i];
            // d2
            d2 += grid[i][grid.length-1-i];
        }

        max = Math.max(Math.max(r_max, c_max), Math.max(d1,d2));
        return max;
    }
    public static void main(String[] args) throws IOException {
        Grid_max_sum g = new Grid_max_sum();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, num = Integer.parseInt(br.readLine());
        int[][] grid = new int[num][num];
        String str;
        StringTokenizer st;
        for(i = 0; i < num; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            for(j = 0; j < num; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(g.solution(num, grid));
    }
}
