package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Flatten {
    public int solution(int[] arr, int chance){
        int cnt = 0;
        for(int i = 0; i < chance; i++){
            Arrays.sort(arr);
            arr[0]++;
            arr[arr.length-1]--;
        }
        Arrays.sort(arr);
        return arr[arr.length-1] - arr[0];
    }

    public static void main(String[] args) throws IOException {
        Flatten f = new Flatten();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[100];

        for(int t = 1; t <= 10; t++){
            int chance = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < arr.length; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println("#" + t + " " + f.solution(arr, chance));
        }

    }

}
