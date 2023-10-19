package lecture.section3_twoPointer_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Continuous_subsequence {
    public int solution(int[] arr, int target){
        int p, sol = 0, temp = 0;
        for(int i = 0; i < arr.length; i++){
            temp = 0;
            p = i;
            while(temp < target && p < arr.length){
                temp += arr[p];
                p++;
            }
            if(temp == target) sol++;
        }

        return sol;
    }
    public static void main(String[] args) throws IOException {
        Continuous_subsequence c = new Continuous_subsequence();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringTokenizer st;

        str = br.readLine();
        st = new StringTokenizer(str);
        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[size];

        str = br.readLine();
        st = new StringTokenizer(str);
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(c.solution(arr, target));



    }
}
