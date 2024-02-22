package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Contact {

    static ArrayList<Integer>[] network = new ArrayList[101];

    static boolean[] vtd;
    static int answer;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 1; t <= 10; t++){
            for(int i = 0; i < 101; i++) network[i] = new ArrayList<>();
            answer = 0;
            vtd = new boolean[101];
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

        System.out.print(sb);
    }

    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> lastContacts = new PriorityQueue<>(Collections.reverseOrder());

        queue.add(start);
        vtd[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            lastContacts.clear(); // 새로운 레벨마다 우선순위 큐 초기화

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int next : network[current]) {
                    if (!vtd[next]) {
                        queue.add(next);
                        vtd[next] = true;
                        lastContacts.add(next); // 해당 레벨의 연락 받는 사람들 추가
                    }
                }
            }

            if (!lastContacts.isEmpty()) {
                answer = lastContacts.peek(); // 해당 레벨에서 마지막으로 연락받은 사람 갱신
            }
        }
    }
}
