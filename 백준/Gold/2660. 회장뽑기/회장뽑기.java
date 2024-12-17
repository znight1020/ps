import java.io.*;
import java.util.*;

public class Main {

    static int N, point = Integer.MAX_VALUE;
    static List<Integer> candidates = new ArrayList<>();
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if(from == -1 && to == -1) break;

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for(int i = 1; i < graph.size(); i++) {
            if(graph.get(i).size() == N-1) {
                point = 1;
                candidates.add(i);
            }
        }

        if(candidates.isEmpty()) {
            for(int i = 1; i <= N; i++) {
                int depth = bfs(i, new boolean[N+1]);
                if(depth != 0) {
                    if(depth < point) {
                        point = depth;
                        candidates = new ArrayList<>();
                    }
                    candidates.add(i);
                }
            }
        }

        System.out.println(point + " " + candidates.size());
        for(int candidate : candidates) System.out.print(candidate + " ");
    }

    static int bfs(int start, boolean[] vtd) {
        int depth = 0, maxDepth = 0;
        vtd[0] = true;
        vtd[start] = true;
        PriorityQueue<Person> pq = new PriorityQueue<>();
        pq.add(new Person(start, depth));

        while(!pq.isEmpty()) {
            Person p = pq.poll();
            for(int num : graph.get(p.num)){
                if(vtd[num]) continue;
                if(p.depth + 1 > point) return 0;

                vtd[num] = true;
                pq.add(new Person(num, p.depth+1));
                maxDepth = Math.max(maxDepth, p.depth+1);
            }
            depth++;
        }

        if(check(vtd)) return maxDepth;
        else return 0;
    }

    static boolean check(boolean[] vtd) {
        for(int i = 1; i <= N; i++) if(!vtd[i]) return false;
        return true;
    }

    static class Person implements Comparable<Person>{
        int num, depth;

        Person(int num, int depth){
            this.num = num;
            this.depth = depth;
        }

        @Override
        public int compareTo(Person p) {
            return this.depth - p.depth;
        }
    }
}
