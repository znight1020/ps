import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] edgeList;
    static int N;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        edgeList = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) edgeList[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) edgeList[i].add(j);
            }
        }

        for(int i = 1; i <= N; i++) {solution(i);}

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void solution(int vertex){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vtd = new boolean[N+1];
        for(int i = 0; i < edgeList[vertex].size(); i++) q.add(edgeList[vertex].get(i));

        while(!q.isEmpty()){
            int temp = q.poll();

            for(int i = 0; i < edgeList[temp].size(); i++){
                if((edgeList[temp].get(i) == vertex && graph[vertex][vertex] == 1) || vtd[edgeList[temp].get(i)] ) continue;
                vtd[edgeList[temp].get(i)] = true;
                graph[vertex][edgeList[temp].get(i)] = 1;
                q.add(edgeList[temp].get(i));
            }
        }
    }
}