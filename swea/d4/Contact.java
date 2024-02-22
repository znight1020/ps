package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Contact {

    static ArrayList<Integer>[] network = new ArrayList[101];

    static boolean[] vtd = new boolean[101];
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 101; i++) network[i] = new ArrayList<>();
        for(int t = 1; t <= 1; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int iter = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < iter / 2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                network[from].add(to);
            }

            BFS(start);

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static void BFS(int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int outCnt = 0;
        int inCnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while(!q.isEmpty()){
            int cnt = 0;
            int temp = q.poll();
            outCnt++;
            System.out.println(temp);
            if(vtd[temp]) continue;

            vtd[temp] = true;
            for(int i = 0; i < network[temp].size(); i++){
                if(!vtd[network[temp].get(i)]) { // 방문하지 않은 노드
                    q.add(network[temp].get(i)); // 방문하지 않은 노드 큐에 추가
                    pq.add(network[temp].get(i)); // pq 추가
                    cnt++;
                    inCnt++;
                }
            }

            if(cnt == 0) answer = pq.poll();

            if(inCnt == outCnt){
                inCnt = 0;
                outCnt = 0;
                pq.clear();
            }
            // 바로 이전 단계의 pq 중 가장 큰값을 반환
            // cnt 가 1이상이면 더 나아가는 노드가 있음 해당 pq 추가
        }



    }
}
