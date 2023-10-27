package lecture.section6_sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Binary_search {


    public int search(int[] arr, int start, int end, int target){
        int mid = (start + end) / 2;
        if(arr[mid] == target){
            return mid;
        } else if(arr[mid] < target){ // arr[mid] = 12, target = 32
            return search(arr, mid+1, end, target);
        } else {
            return search(arr, start, mid-1, target);
        }
    }
    public int solution(int[] arr, int target){
        Arrays.sort(arr);
        int start = 0, end = arr.length - 1;
        return search(arr, start, end, target);
    }

    public static void main(String[] args) throws IOException {
        Binary_search b = new Binary_search();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[size];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(b.solution(arr, target) + 1);
    }
}
