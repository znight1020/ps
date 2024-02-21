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
    static boolean[] vtd;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new LinkedList<>();
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        poto = new int[N+1];
        vtd = new boolean[N+1];
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
        for(int i = 1; i < poto.length; i++){
            if(poto[i] == 0) q.add(i);
        }
        solution();

        System.out.println(sb);
    }

    static void solution(){
        while(!q.isEmpty()){
            int temp = q.poll();
            sb.append(temp).append(" ");

            for(int i = 0; i < graph[temp].size(); i++){
                int candidate = graph[temp].get(i);
                poto[candidate]--;

                if(poto[candidate] == 0) q.add(candidate);
            }
        }
    }
}
