package solved.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NAndM_9 {
    static int[] arr;
    static int N, M;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        answer = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        dicComb(0, 0, answer);
    }

    static void dicComb(int L, int start, int[] answer){
        if(L == M){
            for(int x : answer) System.out.print(x + " ");
            System.out.println();
            return;
        }

        if(start > 0 && arr[start] == arr[start-1]) return;
        for(int i = start; i < N; i++){
            answer[L] = arr[i];
            dicComb(L+1, start+1, answer);
        }
    }
}
