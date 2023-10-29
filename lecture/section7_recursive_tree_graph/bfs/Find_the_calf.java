package lecture.section7_recursive_tree_graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class NodeForCalf{
    int data;
    NodeForCalf back, go, skip;
    NodeForCalf(int pos){
        this.data = pos;
        back = go = skip = null;
    }

    void setData(){
        back = new NodeForCalf(this.data -1);
        go = new NodeForCalf(this.data +1);
        skip = new NodeForCalf(this.data +5);
    }
}

public class Find_the_calf {
    static int[] check;
    public int solution(NodeForCalf root, int tar_pos){
        int level = 0, len;
        Queue<NodeForCalf> q = new LinkedList<>();
        q.offer(root);

        NodeForCalf temp;

        while(!q.isEmpty()){
            len = q.size();
            //System.out.print("방문 노드: ");
            for(int i = 0; i < len; i++){
                temp = q.poll();
                if(temp.data < 1 || temp.data > 10000 || check[temp.data] == 1) continue;
                //System.out.print(temp.data + " ");

                if(temp.data == tar_pos) return level;
                else{
                    check[temp.data] = 1;
                    temp.setData();
                    q.offer(temp.back);
                    q.offer(temp.go);
                    q.offer(temp.skip);
                }
            }
            //System.out.println();
            level++;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        Find_the_calf f = new Find_the_calf();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int me_pos = Integer.parseInt(st.nextToken());
        int tar_pos = Integer.parseInt(st.nextToken());
        check = new int[10001];

        System.out.println(f.solution(new NodeForCalf(me_pos), tar_pos));
    }
}
