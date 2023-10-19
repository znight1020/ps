package lecture.section3_twoPointer_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maximum_sales {
    public int solution(int[] arr, int window){
        int i, temp, start = 0, max = 0;

        while((start + window) < arr.length){
            temp = 0;
            for(i = start; i < start + window; i++){
                temp += arr[i];
            }
            if(temp > max) max = temp;
            start++;
        }

        return max;
    }
    public static void main(String[] args) throws IOException {
        Maximum_sales m = new Maximum_sales();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;

        str = br.readLine();
        st = new StringTokenizer(str);

        int size = Integer.parseInt(st.nextToken());
        int window = Integer.parseInt(st.nextToken());
        int[] arr = new int[size];

        str = br.readLine();
        st = new StringTokenizer(str);
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(m.solution(arr, window));
    }
}
