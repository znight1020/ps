import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long answer = Long.MAX_VALUE;
    static List<Point> pointList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        Point pre = null;
        long sum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Point p = new Point(x, y);
            if (i == 0) pre = p;
            else {
                sum += getManhattanDistance(pre, p);
                pre = p;
            }
            pointList.add(p);
        }

        getMinDistance(sum);
        System.out.println(answer);
    }

    static void getMinDistance(long totalDistance) {
        for (int i = 1; i < N - 1; i++) {
            Point pre = pointList.get(i - 1);
            Point current = pointList.get(i);
            Point next = pointList.get(i + 1);

            int threePointDistance = getManhattanDistance(pre, current) + getManhattanDistance(current, next);
            int skipDistance = getManhattanDistance(pre, next);
            if (skipDistance < threePointDistance) {
                long result = totalDistance - threePointDistance + skipDistance;
                if (result < answer) answer = result;
            }
        }
    }

    static int getManhattanDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
