package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파리_퇴치 {
    static int answer;
    static int n, m;

    // N = 5, M = 2
    public int solution(int[][] arr){
        int sum, i_x = 0, i_y = 0, max = Integer.MIN_VALUE;

        while(true){
            if(i_y + m > n) {
                i_y = 0;
                i_x++;
            }
            if(i_x + m > n) break;
            sum = 0;
            for(int i = i_x; i < m + i_x; i++){
                for(int j = i_y; j < m + i_y; j++){
                    sum += arr[i][j];

                }
                if(sum > max) max = sum;
            }
            i_y++;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        파리_퇴치 p = new 파리_퇴치();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr;

        int testCase = Integer.parseInt(br.readLine());
        for(int t = 1; t <= testCase; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n][n];

            answer = 0;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("#" + t + " " + p.solution(arr));
        }
    }
}
