package solved.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Node{
    int to, weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
public class DiameterOfTheTree {
    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<Node>[] tree;
    static long answer = 0;
    static boolean[] vtd;
    static int V;
    static int root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V+1];

        tree[0] = new ArrayList<>();
        vtd = new boolean[V+1];

        for(int i = 1; i <= V; i++) tree[i] = new ArrayList<>();

        for(int i = 0; i < V; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int to = Integer.parseInt(st.nextToken()); if(to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                tree[from].add(new Node(to, weight));
            }
        }

        vtd = new boolean[V+1];
        vtd[2] = true;
        findRoot(1, 0, 1);
        System.out.println("Root: " + root);

        vtd = new boolean[V+1];
        vtd[root] = true;
        findRoot(1, 0, root);

        System.out.print(answer);
    }

    /*(*/
    static void findRoot(int L, int diameter, int vertex){
//        if(L == V || vtd[tree[vertex]] ) {
//            System.out.println("ggg");
//            if(answer < diameter){
//                answer = diameter;
//                root = vertex;
//            }
//            return;
//        }

        for(int i = 0; i < tree[vertex].size(); i++){
            if(vtd[tree[vertex].get(i).to]) continue;

            vtd[tree[vertex].get(i).to] = true;
            int nextVertex = tree[vertex].get(i).to;
            int weight = tree[vertex].get(i).weight;
            DFS(L + 1, diameter + weight, nextVertex);
        }
    }

    static void DFS(int L, int diameter, int vertex){
        if(L == V || (tree[vertex].size() == 1 && vtd[tree[vertex].get(0).to])) {
            answer = Math.max(diameter, answer);
            return;
        }

        for(int i = 0; i < tree[vertex].size(); i++){
            if(vtd[tree[vertex].get(i).to]) continue;

            vtd[tree[vertex].get(i).to] = true;
            int nextVertex = tree[vertex].get(i).to;
            int weight = tree[vertex].get(i).weight;
            DFS(L + 1, diameter + weight, nextVertex);

        }
    }
}
