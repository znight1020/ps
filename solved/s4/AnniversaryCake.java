package solved.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point{
    int y, x;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class AnniversaryCake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Point p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Point sTemp = new Point(p1.x, 0);
        Point eTemp = new Point(p2.x, h);

        System.out.print(sTemp.x + " " + sTemp.y + " " + eTemp.x + " " + eTemp.y);

    }
}
