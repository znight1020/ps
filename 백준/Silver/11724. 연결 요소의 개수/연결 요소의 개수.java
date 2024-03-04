import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] vtd;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        vtd = new boolean[N+1];
        arr = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) arr[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr[from].add(to);
            arr[to].add(from);
        }
        for(int i = 1; i <= N; i++){
            if(!vtd[i]){
                solution(i);
                cnt++;
            }
        }

        System.out.print(cnt);
    }

    static void solution(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while(!q.isEmpty()){
            int temp = q.poll();
            if(vtd[temp]) continue;
            vtd[temp] = true;

            q.addAll(arr[temp]);
        }
    }
}
