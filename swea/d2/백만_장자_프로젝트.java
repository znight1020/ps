package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백만_장자_프로젝트 {
    public long solution(int[] arr){
        long sum = 0;
        int temp = arr[arr.length-1];
        for(int i = arr.length-1; i >= 0; i--){
            if(temp > arr[i]) {
                sum += temp - arr[i];
            }
            else{
                temp = arr[i];
            }
        }

        return sum;
    }
    public static void main(String[] args) throws IOException {
        백만_장자_프로젝트 b = new 백만_장자_프로젝트();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int day;
        int[] arr;

        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++){
            day = Integer.parseInt(br.readLine());
            arr = new int[day];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < day; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println("#" + (i+1) + " " + b.solution(arr));
        }
    }
}
