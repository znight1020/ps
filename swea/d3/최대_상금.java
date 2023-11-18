package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 최대 자릿수 6, 최대 교환 횟수 10
public class 최대_상금 {
    static int ex;
    static int max;

    public int getValue(char[] arr){
        return Integer.parseInt(new String(arr));
    }
    public void DFS(int L, int start, char[] arr){
        if(L == ex){
            if(max < getValue(arr)) max = getValue(arr);
            return;
        }
        for(int i = start; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                int tempI = Integer.parseInt(String.valueOf(arr[i]));
                int tempJ = Integer.parseInt(String.valueOf(arr[j]));
                arr[i] = (char)(tempJ +'0');
                arr[j] = (char)(tempI +'0');
                DFS(L+1, i, arr);
                arr[i] = (char)(tempI +'0');
                arr[j] = (char)(tempJ +'0');
            }
        }
    }
    public static void main(String[] args) throws IOException {
        최대_상금 m = new 최대_상금();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        String str;
        char[] arr;

        for(int i = 1; i <= testCase; i++){
            st = new StringTokenizer(br.readLine());
            str = st.nextToken(); // 상금
            arr = str.toCharArray();
            ex = Integer.parseInt(st.nextToken()); // 교환 횟수
            max = Integer.MIN_VALUE;

            if (ex > arr.length) {
                ex = arr.length;
            }

            m.DFS(0,0, arr);

            System.out.println("#" + i + " " + max);
        }
    }
}
