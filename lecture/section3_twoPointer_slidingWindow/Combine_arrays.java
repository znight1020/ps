package lecture.section3_twoPointer_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combine_arrays {
    public int[] solution(int[] arr1, int[] arr2){
        int i = 0, p_arr1 = 0, p_arr2 = 0, size_arr1 = arr1.length, size_arr2 = arr2.length;
        int[] c_arr = new int[size_arr1 + size_arr2];

        while(i < c_arr.length){
            if(arr1[p_arr1] <= arr2[p_arr2]){
                c_arr[i] = arr1[p_arr1];
                p_arr1++;
            } else if(arr1[p_arr1] > arr2[p_arr2]){
                c_arr[i] = arr2[p_arr2];
                p_arr2++;
            }

            i++;

            if(p_arr2 >= size_arr2){
                for(int m = p_arr1; m < size_arr1; m++){
                    c_arr[i] = arr1[m];
                    i++;
                }
            } else if(p_arr1 >= size_arr1){
                for(int n = p_arr2; n < size_arr2; n++){
                    c_arr[i] = arr2[n];
                    i++;
                }
            }
        }
        return c_arr;
    }
    public static void main(String[] args) throws IOException {
        Combine_arrays c = new Combine_arrays();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        int[] c_arr;
        int num, i;

        num = Integer.parseInt(br.readLine());
        str = br.readLine();
        int[] arr1 = new int[num];
        st = new StringTokenizer(str);
        for(i = 0; i < num; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        num = Integer.parseInt(br.readLine());
        str = br.readLine();
        int[] arr2 = new int[num];
        st = new StringTokenizer(str);
        for(i = 0; i < num; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }


        c_arr = c.solution(arr1, arr2);
        for(i = 0; i < c_arr.length; i++){
            System.out.print(c_arr[i] + " ");
        }
    }
}
