package lecture.section7_recursive_tree_graph.dfs;


class Node1{
    int data;
    Node1(int data){
        this.data = data;
        lt = rt = null;
    }
    Node1 lt, rt;
}
public class Minimum_distance_to_end_node {
    Node1 root;

    public int DFS(int level, Node1 root){
        if(root.lt == null && root.rt == null){
            return level;
        } else{
            return Math.min(DFS(level+1, root.lt), DFS(level+1, root.rt));
        }
    }

    public static void main(String[] args) {
        Minimum_distance_to_end_node m = new Minimum_distance_to_end_node();
        m.root = new Node1(1);
        m.root.lt = new Node1(2);
        m.root.rt = new Node1(3);
        m.root.lt.lt = new Node1(4);
        m.root.lt.rt = new Node1(5);

        System.out.println(m.DFS(0, m.root));
    }
}
