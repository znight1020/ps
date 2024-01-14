package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파리_퇴치_3 {
    public int solution(int[][] section, int n, int m){
        int answer = 0;
        int sum_p, sum_x;
        for(int i = 0; i < n; i++){ // 중심으로부터 m번째 칸까지
            for(int j = 0; j < n; j++){
                // + 형태
                sum_p = section[i][j]; // 중심
                sum_x = section[i][j];

                for(int k = 1; k < m; k++){
                    // 상
                    if(i-k >= 0){
                        sum_p += section[i-k][j];
                    }
                    // 하
                    if(i+k < n){
                        sum_p += section[i+k][j];
                    }
                    // 좌
                    if(j-k >= 0){
                        sum_p += section[i][j-k];
                    }
                    // 우
                    if(j+k < n){
                        sum_p += section[i][j+k];
                    }
                }

                // x 형태
                for(int k = 1; k < m; k++){
                    // 왼쪽 위
                    if(i-k >= 0 && j-k >= 0){
                        sum_x += section[i-k][j-k];
                    }
                    // 오른쪽 위
                    if(i-k >= 0 && j+k < n){
                        sum_x += section[i-k][j+k];
                    }
                    // 왼쪽 아래
                    if(i+k < n && j-k >= 0){
                        sum_x += section[i+k][j-k];
                    }
                    // 오른쪽 아래
                    if(i+k < n && j+k < n){
                        sum_x += section[i+k][j+k];
                    }
                }
                answer = Math.max(answer, Math.max(sum_x, sum_p));
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        파리_퇴치_3 s = new 파리_퇴치_3();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] section = new int[n][n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    section[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.print("#" + t + " ");
            System.out.println(s.solution(section, n, m));
        }

    }
}
