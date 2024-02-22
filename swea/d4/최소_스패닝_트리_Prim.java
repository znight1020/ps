package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소_스패닝_트리_Prim {
    static PriorityQueue<Node> q = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);

    static ArrayList<Node>[] nodeList;

    static boolean[] vtd;

    static int V;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


        for(int t = 1; t <= T; t++){
            sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            nodeList = new ArrayList[V+1];
            vtd = new boolean[V+1];

            for(int i = 0; i <= V; i++) nodeList[i] = new ArrayList<>();

            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                nodeList[v1].add(new Node(v1, v2, weight));
            }
            Prim(1);

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
    }

    static void Prim(int vertex){
        int cnt = 0;
        // 시작 정점과 연결된 정점들 q 에 추가
        q.addAll(nodeList[vertex]);

        while(!q.isEmpty() && cnt < V){
            Node temp = q.poll(); // 가장 비용이 작은 Node 추출
            if(vtd[temp.v1] && vtd[temp.v2]) continue;

            sum += temp.weight; // 비용 더하기
            vtd[temp.v1] = true;// 이전 노드 방문 처리
            System.out.println(temp.toString());

            q.addAll(nodeList[temp.v2]); // 큐에 새 노드에서 갈 수 있는 간선 추가

            cnt++;
        }
    }
    static class Node{
        int v1, v2, weight;

        public Node(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", weight=" + weight +
                    '}';
        }
    }
}
