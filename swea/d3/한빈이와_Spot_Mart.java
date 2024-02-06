package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 한빈이와_Spot_Mart {
    static int[] arr;
    static int solution(int N, int M){
        int start = 0;
        int end = 1;


        int max = Integer.MIN_VALUE;
        while(start < N && end < N){

            while(end < N && arr[start] + arr[end] <= M){
                if(max < arr[start] + arr[end]) max = arr[start] + arr[end];
                end++;
            }

            start++;
            end = start+1;
        }
        if(max == Integer.MIN_VALUE) return -1;
        else return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken()); // 한빈이가 들 수 있는 과자 2개의 무게

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            System.out.println("#" + t + " " + solution(N, M));
        }
    }
}
