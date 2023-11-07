package lecture.section7_recursive_tree_graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_shortest_distance {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] check, distance;
    public void BFS(int v){
        Queue<Integer> q = new LinkedList<>();
        check[v] = 1;
        distance[v] = 0;
        q.offer(v);

        while(!q.isEmpty()){
            int cv = q.poll();
            for(int nv : graph.get(cv)){
                if(check[nv] == 0){
                    check[nv] = 1;
                    q.offer(nv);
                    distance[nv] = distance[cv] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Graph_shortest_distance g = new Graph_shortest_distance();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new int[n+1];
        distance = new int[n+1];
        graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        g.BFS(1);

        for(int i = 2; i < distance.length; i++){
            System.out.println(i+"정점까지의 거리 : " + distance[i]);
        }
    }
}
