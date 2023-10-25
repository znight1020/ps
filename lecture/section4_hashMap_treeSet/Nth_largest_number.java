package lecture.section4_hashMap_treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Nth_largest_number {
    public int solution(int[] arr, int num){
        TreeSet<Integer> set = new TreeSet(Collections.reverseOrder());
        int cnt = 0, sol = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                for(int k = j+1; k < arr.length; k++){
                    set.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }

        if(num < 0 || num > set.size()) return -1;
        else{
            for(int nth : set){
                cnt++;
                if(cnt == num) return nth;
            }
        }

        return sol;
    }
    public static void main(String[] args) throws IOException {
        Nth_largest_number n = new Nth_largest_number();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int i = 0;

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int[] arr = new int[size];

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        System.out.println(n.solution(arr, num));

    }
}
