package solved.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE {
    static ArrayList<Integer>[] vArr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        boolean[] vtd = new boolean[N];

        vArr = new ArrayList[N];
        for(int i = 0; i < N; i++) vArr[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            vArr[v1].add(v2);
            vArr[v2].add(v1);
        }

        for(int i = 0; i < N; i++) {
            vtd[i] = true;
            DFS(1, i, vtd);
            vtd[i] = false;

            if(answer == 1) break;
        }

        System.out.print(answer);
    }

    static void DFS(int L, int currentVertex, boolean[] vtd){
        if(L >= 5) {
            answer = 1;
            return;
        }
        if(vArr[currentVertex].isEmpty()) return;

        for(int i = 0; i < vArr[currentVertex].size(); i++){
            int vertex = vArr[currentVertex].get(i);
            if(vtd[vertex]) continue;

            vtd[vertex] = true;
            DFS(L + 1, vertex, vtd);
            vtd[vertex] = false;
        }
    }
}
