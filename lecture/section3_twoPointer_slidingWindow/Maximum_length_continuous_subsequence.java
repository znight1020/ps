package lecture.section3_twoPointer_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maximum_length_continuous_subsequence {
    public int solution(int[] arr, int partition){
        int max = 0, temp_i, temp_p, cnt;
        for(int i = 0; i < arr.length; i++){
            cnt = 0;
            temp_i = i;
            temp_p = partition;
            if(arr.length < i + max) break; // 더 이상 max 값 갱신 x

            while(temp_i < arr.length){
                if(arr[temp_i] == 1) {
                    cnt++;
                }
                else{
                    temp_p--;
                    if(temp_p == -1) break;
                    cnt++;
                }

                temp_i++;
            }

            if(max < cnt) max = cnt;
        }

        return max;
    }
    public static void main(String[] args) throws IOException {
        Maximum_length_continuous_subsequence m = new Maximum_length_continuous_subsequence();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        StringTokenizer st;

        str = br.readLine();
        st = new StringTokenizer(str);
        int size = Integer.parseInt(st.nextToken());
        int partition = Integer.parseInt(st.nextToken());
        int[] arr = new int[size];

        str = br.readLine();
        st = new StringTokenizer(str);
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(m.solution(arr, partition));
    }
}
