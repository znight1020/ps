package lecture.section2_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Score_cal {
    public int solution(int[] arr){
        int score = 0, cnt = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1) {
                cnt++;
                score += cnt;
            } else {
                cnt = 0;
            }
        }

        return score;
    }

    public static void main(String[] args) throws IOException {
        Score_cal s = new Score_cal();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()), i = 0;
        int[] arr = new int[num];
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        System.out.println(s.solution(arr));
    }
}
