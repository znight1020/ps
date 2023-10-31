package lecture.section7_recursive_tree_graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Node2{
    int data;
    Node2(int data){
        this.data = data;
        lt = rt = null;
    }
    Node2 lt, rt;
}

public class Minimum_distance_to_end_node_bfs {
    Node2 root;

    public int BFS(int level, Node2 root){
        Queue<Node2> q = new LinkedList<>();
        q.offer(root);
        Node2 temp;
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i = 0; i < qSize; i++){
                temp = q.poll();
                if(temp.lt == null && temp.rt == null) return level;
                if(temp.lt != null) q.offer(temp.lt);
                if(temp.rt != null) q.offer(temp.rt);
            }

            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Minimum_distance_to_end_node_bfs m = new Minimum_distance_to_end_node_bfs();
        m.root = new Node2(1);
        m.root.lt = new Node2(2);
        m.root.rt = new Node2(3);
        m.root.lt.lt = new Node2(4);
        m.root.lt.rt = new Node2(5);

        System.out.println(m.BFS(0, m.root));
    }
}
