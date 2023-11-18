package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class View {

    public int solution(int[] arr, int height){
        int answer = 0;
        int max1, max2, max;

        //0 0 225 214 82

        for(int i = 2; i < height-2; i++){
            max1 = Math.max(arr[i+1], arr[i+2]); // 3 4 번 인덱스 최댓값
            max2 = Math.max(arr[i-1], arr[i-2]);
            max = Math.max(max1, max2);

            if(max < arr[i]) answer += arr[i] - max;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        View v = new View();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr;
        int width;

        for(int i = 0; i < 10; i++){
            width = Integer.parseInt(br.readLine());
            arr = new int[width];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < width; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }


            System.out.println("#" + (i+1) + " " + v.solution(arr, width));

        }
    }
}
