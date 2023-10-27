package lecture.section6_sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 문제 의도 모르겠음
public class Double_check {
    public char solution(int[] arr){
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] == arr[i]){
                    return 'D';
                }
            }
        }

        return 'U';
    }
    public static void main(String[] args) throws IOException {
        Double_check d = new Double_check();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(d.solution(arr));

    }
}
