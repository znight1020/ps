package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최빈수_구하기 {
    public static void main(String[] args) throws IOException {
        최빈수_구하기 m = new 최빈수_구하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr;
        int max = Integer.MIN_VALUE, answer = 0;

        int testCase = Integer.parseInt(br.readLine());
        int n;
        for(int i = 0; i < testCase; i++){
            max = Integer.MIN_VALUE;
            arr = new int[101];
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                arr[Integer.parseInt(st.nextToken())]++;
            }
            for(int j = 0; j < arr.length; j++){
                if(max <= arr[j]) {
                    max = arr[j];
                    answer = j;
                }
            }
            System.out.println("#" + n + " " + answer);
        }


    }
}
