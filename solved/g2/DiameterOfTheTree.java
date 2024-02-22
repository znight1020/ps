package solved.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Node{
    int parent = 0;
    int data;
    int weight;

    public Node(){}
    public Node setNode(int parent, int data, int weight){
        this.parent = parent;
        this.data = data;
        this.weight = weight;

        return this;
    }
}
public class DiameterOfTheTree {
    static ArrayList<Node>[] tree;
    static long answer = 0;
    static boolean[] vtd;
    static ArrayList<Node> nodeList = new ArrayList<>();
    static int V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());

        nodeList.add(new Node()); // 0 dummy
        vtd = new boolean[V+1];

        tree = new ArrayList[V+1];
        for(int i = 0; i <= V; i++) {
            nodeList.add(new Node());
            tree[i] = new ArrayList<>();
        }


        for(int i = 0; i < V; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int to = Integer.parseInt(st.nextToken()); if(to == -1) break;
                int weight = Integer.parseInt(st.nextToken());

                Node n = nodeList.get(to).setNode(from, to, weight);
                tree[from].add(n);
            }
        }

        for(int i = 1; i <= V; i++){
            DFS(0, 0, nodeList.get(i));
        }

        System.out.println(answer);

    }

    static void DFS(int L, int diameter, Node startNode){
        if(L == V || (vtd[startNode.parent] &&  tree[startNode.data].size() == 2) ) {
            answer = Math.max(diameter, answer);
            return;
        }

        for(int i = 0; i < tree[startNode.data].size(); i++){
            if(vtd[startNode.data]) continue;
            vtd[startNode.data] = true;
            Node nextNode = tree[startNode.data].get(i);
            DFS(L + 1, diameter + nextNode.weight, nextNode);
            vtd[startNode.data] = false;
        }
    }
}
