package lecture.section7_recursive_tree_graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 한번 방문한 노드는 방문하지 않는다.
public class Route_navigation {
    static int[][] graph;
    static int[] visited;
    static int answer = 0;
    static int n;
    public void DFS(int vertex){
        if(vertex == n) answer++;
        else{
            for(int i = 1; i <= n; i++){
                if(graph[vertex][i] == 1 && visited[i] == 0){
                    visited[i] = 1;
                    DFS(i);
                    visited[i] = 0;
                };
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Route_navigation r = new Route_navigation();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int i = 0;

        n = Integer.parseInt(st.nextToken()) ;
        int edge = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        visited = new int[edge+1];

        // 방향 그래프
        while(i < edge){
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            i++;
        }

        visited[1] = 1;
        r.DFS(1);

        System.out.println(answer);
    }
}