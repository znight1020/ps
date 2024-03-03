import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Edge>edgeList;
    static int V, E;
    static int[] parents;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parents = new int[V+1];
        edgeList = new ArrayList<>();

        make();
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(from, to, weight));
        }

        Collections.sort(edgeList);
        int cnt = 0;
        for(int i = 0; i < edgeList.size(); i++){
            Edge e = edgeList.get(i);
            if(union(e.from, e.to)){
                cnt++;
                answer += e.weight;
                if(cnt == E) break;
            }
        }

        System.out.print(answer);
    }

    static void make(){
        for(int i = 1; i <= V; i++) parents[i] = i;
    }
    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return false;
        else{
            if(a > b) parents[b] = a;
            else parents[a] = b;
            return true;
        }
    }
    static int find(int x){
        if(parents[x] == x) return x;
        else return parents[x] = find(parents[x]);
    }
    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
