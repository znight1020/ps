package lecture.section6_sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 바로 다음값과 비교하여 정렬, 1회전마다 1개의 데이터 제외(회전 데이터의 끝값이 제일 큰값으로 가고 다음 회전부터 제외됨)
public class Bubble_sort {
    public int[] solution(int[] arr){
        int iter = 1, temp;
        while(iter <= arr.length){
            for(int i = 0; i< arr.length-iter; i++){
                if(arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            iter++;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        Bubble_sort b = new Bubble_sort();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : b.solution(arr)){
            System.out.print(x + " ");
        }
    }
}
