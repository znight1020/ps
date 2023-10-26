package lecture.section6_sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 첫 데이터 값과 다음 데이터 값들 중 제일 작은 수와 교체하며 정렬되는 알고리즘
public class Selection_sort {
    public int[] solution(int[] arr){
        int min, index = 0, temp = 0;
        for(int i = 0; i < arr.length; i++){
             min = Integer.MAX_VALUE;
            for(int j = i+1; j < arr.length; j++){
                if(min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            if(arr[i] > min) {
                temp = arr[i];
                arr[i] = min;
                arr[index] = temp;
            }
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        Selection_sort s = new Selection_sort();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : s.solution(arr)){
            System.out.print(x + " ");
        }
    }
}
