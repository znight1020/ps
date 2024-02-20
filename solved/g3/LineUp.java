package solved.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LineUp {
    static ArrayList<Integer>[] graph;
    static int[] poto;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        poto = new int[N+1];
        graph = new ArrayList[N+1];

        for(int i = 0; i < N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            poto[B]++;
        }

        for(int i = 1; i <= N; i++){
            solution(i);
        }

        System.out.println(sb);
    }

    static void solution(int n){
        Queue<Integer> q = new LinkedList<>();
        if(poto[n] == 0) {
            q.add(n);
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            sb.append(temp).append(" ");

            for(int i = 0; i < graph[temp].size(); i++){
                poto[graph[temp].get(i)]--;
                if(poto[n] == 0) {
                    q.add(n);
                }
            }
        }
    }
}
