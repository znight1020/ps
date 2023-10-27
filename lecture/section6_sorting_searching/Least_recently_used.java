package lecture.section6_sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Least_recently_used {
    public int[] solution(int cacheSize, int[] arr){
        int[] solArr = new int[cacheSize];
        int c_job = 0, sa_capacity = 0, temp, p, i;

        while(c_job < arr.length){
            temp = arr[c_job];
            p = -1;
            i = 0;

            for(int x : solArr){
                if(x == temp) {
                    p = i;
                    break;
                } else{
                    p = -1;
                }
                i++;
            }

            if(p == -1){ // 모두가 뒤로 한칸씩 밀리고 맨 앞에 temp 추가
                for(int m = sa_capacity - 1; m >= 0; m--){
                    solArr[m + 1] = solArr[m];
                }
                solArr[0] = temp;
                if(!(sa_capacity == cacheSize-1))sa_capacity++;

            } else{ // p값 전까지만 뒤로 한칸씩 밀림 -> 크기 변화 X
                for(int m = p - 1; m >= 0; m--){
                    solArr[m + 1] = solArr[m];
                }
                solArr[0] = temp;
            }

            c_job++;
        }


        return solArr;
    }
    public static void main(String[] args) throws IOException {
        Least_recently_used l = new Least_recently_used();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int cacheSize = Integer.parseInt(st.nextToken());
        int job = Integer.parseInt(st.nextToken());
        int[] arr = new int[job];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < job; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : l.solution(cacheSize, arr)){
            System.out.print(x + " ");
        }

    }
}
