package solved.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AnniversaryCake {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        int sx=0, sy=0, ex=0, ey=0;
        if(y1 == y2) { // x축과 평행한 일직선에 두 점이 놓여있을 경우 sy = 0 ,ey = height
            sx = x1;
            sy = 0;

            ex = x2;
            ey = height;
        } else { // y축과 평행한 일직선에 두 점이 놓여있을 경우 sx = 0 ,ex = width
            sx = 0;
            sy = y1;

            ex = width;
            ey = y2;
        }

        System.out.print(sx + " " + sy + " " + ex + " " + ey);
    }
}
