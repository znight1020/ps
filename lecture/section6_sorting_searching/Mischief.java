package lecture.section6_sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mischief {

    public int[] solution(int[] arr1){
        int[] solArr = new int[2];
        int[] arr2 = new int[arr1.length];
        int cnt = 0;

        for(int i = 0; i < arr1.length; i++) arr2[i] = arr1[i];
        Arrays.sort(arr1);

        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                solArr[cnt] = i + 1;
                cnt++;
            }

            if(cnt == 2) break;
        }
        return solArr;
    }
    public static void main(String[] args) throws IOException {
        Mischief m = new Mischief();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : m.solution(arr)){
            System.out.print(x + " ");
        }
    }
}
