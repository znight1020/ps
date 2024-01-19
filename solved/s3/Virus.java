package s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Virus {
    static int[][] network;
    static int[] infection;
    static int answer = 0, vertex;
    public void BFS(int com){
        Queue<Integer> q = new LinkedList<>();
        q.offer(com);
        infection[com]++;
        while(!q.isEmpty()){
            int current = q.poll();
            for(int i = com+1; i <= vertex; i++){
                if((network[i][current] == 1 || network[current][i] == 1) && infection[i] == 0) {
                    answer++;
                    infection[i]++;
                    q.offer(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Virus v = new Virus();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        vertex = Integer.parseInt(br.readLine());
        int v1, v2;

        infection = new int[vertex+1]; // 방문 컴퓨터 체크 배열
        network = new int[vertex+1][vertex+1]; // 네트워크

        int pairNum = Integer.parseInt(br.readLine()); // 순서쌍 개수
        for(int i = 0; i < pairNum; i++){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            network[v1][v2] = 1;
        }
        v.BFS(1);
        System.out.print(answer);

    }
}
