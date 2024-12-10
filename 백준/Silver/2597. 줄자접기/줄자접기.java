import java.util.*;
import java.io.*;

public class Main {
    static float left = 0, right, N;
    static List<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Float.parseFloat(br.readLine());
        right = N;

        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points.add(new Point(Float.parseFloat(st.nextToken()), Float.parseFloat(st.nextToken())));
        }

        for(int i = 0; i < 3; i++) {
            Point colorPoint = points.get(i);
            if(colorPoint.start == colorPoint.end) {
                continue;
            }

            float mid = (colorPoint.start + colorPoint.end) / 2f;
            // 왼쪽에서 오른쪽으로 포갠다
            for(int j = i; j < 3; j++) {
                Point nextPoint = points.get(j);
                float start = nextPoint.start;
                float end = nextPoint.end;

                if(start < mid && end < mid) {
                    nextPoint.start = mid + (mid - start);
                    nextPoint.end = mid + (mid - end);
                }

                if(start < mid) {
                    nextPoint.start = nextPoint.end;
                    nextPoint.end = mid + (mid - start);
                }
                if(nextPoint.start > nextPoint.end) {
                    float temp = nextPoint.start;
                    nextPoint.start = nextPoint.end;
                    nextPoint.end = temp;
                }
            }

            if(right - mid < mid - left) right = mid + (mid - left);
            left = mid;
        }
        System.out.printf("%.1f", right-left);
    }

    static class Point{
        float start, end;

        Point(float start, float end) {
            if(start > end) {
                float temp = start;
                start = end;
                end = temp;
            }
            this.start = start;
            this.end = end;
        }
    }
}
