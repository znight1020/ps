import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;
    static int N, K;
    static int[][] map;
    static double[] dis;
    static double answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        dis = new double[N];
        for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        Arrays.fill(dis, INF);

        dijkstra();
        System.out.print(dis[1]);
    }

    static void dijkstra(){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0,K,0));

        while(!pq.isEmpty()){
            Point p = pq.poll();
            for(int to = 0; to < N; to++){
                if((p.time >= dis[to]) || p.from == to) continue;

                double noPotionTime = p.time + map[p.from][to];
                double potionTime = p.time + (map[p.from][to] / 2.0);
                if(dis[to] > noPotionTime){
                    dis[to] = noPotionTime;
                    pq.add(new Point(to, p.potion, dis[to]));
                }
                if(p.potion > 0 && dis[to] > potionTime) {
                    dis[to] = potionTime;
                    pq.add(new Point(to, p.potion-1, dis[to]));
                }
            }
        }
    }

    static class Point implements Comparable<Point>{
        int from, potion;
        double time;

        public Point(int from, int potion, double time) {
            this.from = from;
            this.potion = potion;
            this.time = time;
        }
        @Override
        public int compareTo(Point o) {
            return Double.compare(this.time, o.time);
        }
    }
}