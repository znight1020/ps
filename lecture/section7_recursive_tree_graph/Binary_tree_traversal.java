package lecture.section7_recursive_tree_graph;


class Node{
    int data;
    Node lt, rt;
    Node(int val){
        data = val;
        lt = rt = null;
    }
}
public class Binary_tree_traversal {
    Node root;

    public void DFS(Node root){
        if(root == null) return;
        else{
            //System.out.print(root.data + " "); // 전위
            DFS(root.lt);
            //System.out.print(root.data + " "); // 중위
            DFS(root.rt);
            //System.out.print(root.data + " "); // 후위
        }
    }

    public static void main(String[] args) {
        Binary_tree_traversal b = new Binary_tree_traversal();
        b.root = new Node(1);
        b.root.lt = new Node(2);
        b.root.rt = new Node(3);
        b.root.lt.lt = new Node(4);
        b.root.lt.rt = new Node(5);
        b.root.rt.lt = new Node(6);
        b.root.rt.rt = new Node(7);

        b.DFS(b.root);
    }
}
