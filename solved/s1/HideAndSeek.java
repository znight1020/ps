package solved.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek {
    static int N, K;
    static int answer = 0;
    static boolean[] vtd;
    static int[] dn = {-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        vtd = new boolean[100001];
        BFS();

        System.out.print(answer);
    }

    static void BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int temp = q.poll();
                if(temp == K) return;

                if(temp-1 >= 0 && !vtd[temp-1]) {
                    q.add(temp-1);
                    vtd[temp-1] = true;
                }
                if(temp+1 <= 100000 && !vtd[temp+1]) {
                    q.add(temp+1);
                    vtd[temp+1] = true;
                }
                if(temp * 2 <= 100000 && !vtd[temp*2]){
                    q.add(temp*2);
                    vtd[temp*2] = true;
                }
            }
            answer++;
        }
    }
}
