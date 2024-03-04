import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] nodeList;
    static boolean[] vtd;
    static StringBuilder sbBFS = new StringBuilder();
    static StringBuilder sbDFS = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList[N+1];
        vtd = new boolean[N+1];

        for(int i = 0; i <= N; i++) nodeList[i] = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            nodeList[v1].add(v2);
            nodeList[v2].add(v1);
        }
        for(int i = 0; i < nodeList.length; i++) Collections.sort(nodeList[i]);
        DFS(V);
        vtd = new boolean[N+1];
        BFS(V);

        System.out.println(sbDFS);
        System.out.print(sbBFS);

    }
    static void DFS(int start){
        if(vtd[start]) return;
        vtd[start] = true;

        sbDFS.append(start).append(" ");
        for(int i = 0; i < nodeList[start].size(); i++) DFS(nodeList[start].get(i));
    }
    static void BFS(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int temp = q.poll();
            if(vtd[temp]) continue;
            vtd[temp] = true;
            q.addAll(nodeList[temp]);
            sbBFS.append(temp).append(" ");
        }
    }
}
