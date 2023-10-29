package lecture.section7_recursive_tree_graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node lt, rt;
    Node(int val){
        data = val;
        lt = rt = null;
    }
}

public class Binary_tree_level_search {
    Node root;

    public void BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        Node node;
        int level = 0, len;
        q.offer(root);
        while(!q.isEmpty()){
            len = q.size();
            System.out.print(level + " level node: ");
            for(int i = 0; i < len; i++){
                node = q.poll();
                System.out.print(node.data + " ");

                if(node.lt != null) q.offer(node.lt);
                if(node.rt != null) q.offer(node.rt);
            }
            level++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Binary_tree_level_search b = new Binary_tree_level_search();

        b.root = new Node(1);
        b.root.lt = new Node(2);
        b.root.rt = new Node(3);
        b.root.lt.lt = new Node(4);
        b.root.lt.rt = new Node(5);
        b.root.rt.lt = new Node(6);
        b.root.rt.rt = new Node(7);

        b.BFS(b.root);
    }
}
