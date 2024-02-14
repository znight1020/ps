package solved.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WorldCup {
    static int[][] arr = new int[6][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 4; i++){
            int sum = 0;
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 6; j++){
                for(int k = 0; k < 3; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    sum += arr[j][k];
                }
            }
            if(sum != 30) {
                System.out.print(0 + " ");
                continue;
            }
            if(solution()) System.out.print(1 + " ");
            else System.out.print(0 + " ");
        }
    }

    static boolean solution(){
        int victorySum = 0, loseSum = 0, drawSum = 0;
        for(int i = 0; i < 6; i++){ // 승
            victorySum += arr[i][0];

            if(drawSum <= 0) drawSum += arr[i][1];
            else drawSum -= arr[i][1];

            loseSum += arr[i][2];
        }

        for(int i = 0; i < 6; i++){
            int countrySum = 0;
            for(int j = 0; j < 3; j++){
                countrySum += arr[i][j];
            }
            if(countrySum != 5) return false; // 각 나라의 승, 무, 패가 5가 아닌 경우
        }

        if(victorySum != loseSum) return false; // 승 Count != 패 Count
        if(drawSum % 2 == 1) return false; // 무승부의 개수가 홀수
        if(drawSum != 0) return false; // 각 나라의 무승부 페어가 맞지않을 때

        // 승, 패가 맞아 떨어져야 함, 예) A나라가 5승이면 B나라는 5승일 수 없음 최대 4승

        return true;
    }
}
