package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_queen {
    static int answer = 0;
    public boolean valid(int L, int[] row){
        for(int i = 0; i < L; i++){
            if(row[i] == row[L]) return false;
            else if(Math.abs(i - L) == Math.abs(row[i] - row[L])) return false;
        }
        return true;
    }
    public void DFS(int L, int[] row, int n){
        if(L == n){
            answer++;
            return;
        }
        for(int i = 0; i < n; i++){
            row[L] = i;

            if(valid(L, row)){
                DFS(L+1, row, n);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        N_queen q = new N_queen();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] row;

        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1; t <= testCase; t++){
            int n = Integer.parseInt(br.readLine());
            row = new int[n];
            answer = 0;
            q.DFS(0, row, n);

            System.out.println("#" + t + " " + answer);

        }
    }
}
