package lecture.section6_sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삽입정렬은 2번째 index를 시작으로하여 key를 ++ 시키며 key 이전의 데이터들을 비교하며 자리를 찾아간다. (key보다 큰 값은 한 칸 뒤로 이동시킴)
public class Insertion_sort {
    public int[] solution(int[] arr){
        int key = 1, p, temp;
        while(key < arr.length){
            temp = arr[key];
            p = -1;
            for(int i = key-1; i >= 0; i--){
                if(temp < arr[i]){ // key 값이 i 값보다 작을경우 arr[i]를 한칸뒤로 이동
                    arr[i+1] = arr[i];
                    p = i;
                }
            }
            if(p != -1) arr[p] = temp;

            key++;
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        Insertion_sort in = new Insertion_sort();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : in.solution(arr)){
            System.out.print(x + " ");
        }
    }
}
