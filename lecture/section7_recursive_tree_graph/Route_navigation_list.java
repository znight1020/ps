package lecture.section7_recursive_tree_graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 정점의 개수가 많아진다면 ArrayList로 푸는 것이 훨씬 효율적이다.
public class Route_navigation_list {
    // 정점의 수 n, 간선의 수 m
    static int n, m, answer = 0;
    static int[] check;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public void DFS(int vertex){
        if(vertex == n) answer++;
        else{
            for(int nextVertex : graph.get(vertex)){
                if(check[nextVertex] == 0){
                    check[nextVertex] = 1;
                    DFS(nextVertex);
                    check[nextVertex] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Route_navigation_list r = new Route_navigation_list();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new int[n+1];

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        check[1] = 1;
        r.DFS(1);

        System.out.println(answer);
    }
}
