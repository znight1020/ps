package lecture.section3_twoPointer_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Find_common_elements {
    public ArrayList<Integer> solution(int[] arr1, int[] arr2){
        ArrayList<Integer> solArr = new ArrayList<>();
        int arr1_size = arr1.length, arr2_size = arr2.length;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1 = 0, p2 = 0;

        while(p1 < arr1_size && p2 < arr2_size){
            if(arr1[p1] == arr2[p2]) {
                solArr.add(arr1[p1]);
                p1++;
                p2++;
            } else{
                if(arr1[p1] < arr2[p2])
                    while(p1 < arr1_size && arr1[p1] < arr2[p2])
                        p1++;
                else
                    while(p2 < arr2_size && arr1[p1] > arr2[p2])
                        p2++;
            }
        }
        return solArr;
    }
    public static void main(String[] args) throws IOException {
        Find_common_elements f = new Find_common_elements();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr1, arr2;
        ArrayList<Integer> solArr;

        // arr1
        int i, num = Integer.parseInt(br.readLine());
        arr1 = new int[num];
        String str = br.readLine();
        st = new StringTokenizer(str);
        for(i = 0; i < num; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        // arr2
        num = Integer.parseInt(br.readLine());
        arr2 = new int[num];
        str = br.readLine();
        st = new StringTokenizer(str);
        for(i = 0; i < num; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        //

        solArr = f.solution(arr1, arr2);
        for(i = 0; i < solArr.size(); i++){
            System.out.print(solArr.get(i) + " ");
        }
    }
}
