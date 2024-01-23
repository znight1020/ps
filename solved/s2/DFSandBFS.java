package s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class DFSandBFS{
    static int N;

    static int[] vtd;
    
    static int[][] graph;

    void DFS(int V){
        
    }

    void BFS(int V){
        Queue<Integer> q = new LinkedList<>();
        int current;
        q.add(V);
        vtd[V]++;
        while(!q.isEmpty()){
            current = q.poll();
            for(int i = 0; i < N; i++){
                if(vtd[i] == 1) continue;
                else {
                    q.add(graph[current][i]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        DFSandBFS db = new DFSandBFS();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        
        graph = new int[N][N];
        vtd = new int[N];

        int V = Integer.parseInt(st.nextToken()); // 탐색 시작 번호
        
        int v1, v2;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());

            graph[v1][v2] = 1;
        }

        db.DFS(V);
        db.BFS(V);        
    }
}