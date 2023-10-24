package lecture.section4_hashMap_treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Type_of_sales {
    public ArrayList<Integer> solution(int interval, int[] arr){
        ArrayList<Integer> solArr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int start, end;

        for(int i = 0; i < interval - 1; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        } // interval-1 만큼 map의 초기값 설정 -> 처음값, 끝값만 신경쓰면 돼서 연산횟수 감소
        start = 0;

        while(start + interval <= arr.length){
            end = start + interval - 1; // 끝값
            map.put(arr[end], map.getOrDefault(arr[end], 0)+1);
            solArr.add(map.size());

            map.put(arr[start], map.get(arr[start])-1);
            if(map.get(arr[start]) == 0) map.remove(arr[start]);

            start++;
        }
        return solArr;
    }
    public static void main(String[] args) throws IOException {
        Type_of_sales t = new Type_of_sales();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int i = 0;

        st = new StringTokenizer(br.readLine());
        int record = Integer.parseInt(st.nextToken());
        int interval = Integer.parseInt(st.nextToken());
        int[] arr = new int[record];

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        for(int num : t.solution(interval, arr)){
            System.out.print(num + " ");
        }
    }
}
