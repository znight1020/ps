import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][][] dp;
    static boolean[][][] vtd;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); 
        M = Integer.parseInt(br.readLine());
        dp = new int[N+1][N+1][M+1];
        vtd = new boolean[N+1][N+1][M+1];

        if(N == 1) System.out.println(1);
        else System.out.print(topDown(N, N, M));
    }
    static int topDown(int pi, int prePi, int personNum){
        if(pi == personNum) return 1;
        if(pi == 0 || personNum == 0 || pi < personNum) return 0;

        vtd[pi][prePi][personNum] = true;

        for(int i = 1; i <= prePi && i <= pi; i++){ //
            if(!vtd[pi-i][i][personNum-1]) dp[pi][prePi][personNum] += topDown(pi-i, i, personNum-1);
            else dp[pi][prePi][personNum] += dp[pi-i][i][personNum-1];

        }
        return dp[pi][prePi][personNum];
    }
}
