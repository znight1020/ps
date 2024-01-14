package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두개의_숫자열 {
    public int solution(int min, int[] fixed, int[] compare){ // fixed가 원소의 개수가 더 많은 배열
       int answer = Integer.MIN_VALUE, sum;
       for(int i = 0; i < fixed.length - min + 1; i++){
           int temp = i;
           sum = 0;
           for(int j = 0; j < compare.length; j++){
               sum += fixed[temp] * compare[j];
               temp++;
           }
           if(sum > answer) answer = sum;
       }

       return answer;
    }

    public static void main(String[] args) throws IOException {
        두개의_숫자열 s = new 두개의_숫자열();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int i,j, t = Integer.parseInt(br.readLine());
        int[] A, B;

        for(int n = 1; n <= t; n++){
            st = new StringTokenizer(br.readLine());
            int aSize = Integer.parseInt(st.nextToken());
            int bSize = Integer.parseInt(st.nextToken());
            A = new int[aSize];
            B = new int[bSize];
            i = 0;
            j = 0;

            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                A[i] = Integer.parseInt(st.nextToken());
                i++;
            }
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                B[j] = Integer.parseInt(st.nextToken());
                j++;
            }
            System.out.print("#" + n + " ");
            if(aSize > bSize){
                System.out.println(s.solution(bSize, A, B));
            } else{
                System.out.println(s.solution(aSize, B, A));
            }
        }
    }
}
