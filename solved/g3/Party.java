package solved.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int index;
    int time;
    Node(int index, int time){
        this.index = index;
        this.time = time;
    }


    @Override
    public int compareTo(Node o) {
        return this.time - o.time;
    }
}
public class Party {

    static final int INF = Integer.MAX_VALUE;
    static PriorityQueue<Node> pq;
    static int[] dist;
    static int[] goDist;
    static int[] backDist;
    static int N,M,X;

    static boolean[] vtd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N명의 학생
        M = Integer.parseInt(st.nextToken()); // M개의 단방향 도로
        X = Integer.parseInt(st.nextToken()); // 가중치

        ArrayList<Node>[] graph = new ArrayList[N+1];
        ArrayList<Node>[] graph2 = new ArrayList[N+1];
        for(int i = 1; i < N+1; i++){
            graph[i] = new ArrayList<>();
            graph2[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // u 에서
            int v = Integer.parseInt(st.nextToken()); // v 로
            int w = Integer.parseInt(st.nextToken()); // w 만큼의 비용

            graph[v].add(new Node(u, w));
            graph2[u].add(new Node(v, w));
        }

        goDist = dijkstra(X, graph);
        backDist = dijkstra(X, graph2);

        int max = Integer.MIN_VALUE;
        for(int i = 1; i < goDist.length; i++){
            if(goDist[i] + backDist[i] > max){
                max = goDist[i] + backDist[i];
            }
        }

        System.out.print(max);
    }

    static int[] dijkstra(int start, ArrayList<Node>[] graph){
        vtd = new boolean[N+1];
        pq = new PriorityQueue<>();

        dist = new int[N+1];
        Arrays.fill(dist, INF );

        dist[start] = 0;
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            int current = pq.poll().index;
            if(vtd[current]) continue;
            vtd[current] = true;
            for(Node node : graph[current]){
                if(dist[node.index] > dist[current] + node.time)
                    dist[node.index] = dist[current] + node.time;

                pq.add(new Node(node.index, dist[node.index]));
            }
        }

        return dist;
    }
}
