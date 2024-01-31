package solved.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM_Permutation {
    static boolean[] vtd;
    static int N, M;
    static int[] arr;

    static void perm(int L){
        if(L == M){
            for(int x : arr){
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else
        {
            for(int i = 1; i <= N; i++){
                if(!vtd[i]){
                    arr[L] = i;
                    vtd[i] = true;
                    perm(L+1);
                    vtd[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        vtd = new boolean[N+1];
        arr = new int[M];
        perm(0);
    }
}
